let loginApp = new Vue({
    el: '#loginApp',
    data: {

    },
    methods: {
        login: function () {
            //检查用户输入数据的合法性
            if ( $("#username").val() =="" ) {
                alert("用户名不能为空");
                return ;
            }

            // var reg=/^1[3456789]\d{9}$/;
            // if(!reg.test($("#username").val())) {
            //     alert("请输入正确手机号");
            //     return;
            // }
            if ( $("#password").val() =="" ) {
                alert("密码不能为空");
                return;
            }
            //检查通过，发送ajax请求，请求服务器处理登录
            $.ajax({
                url: '/user/login',  //请求url
                type: 'post', //请求类型
                data: { //请求参数
                  username: $("#username").val(),
                  password: $("#password").val(),
                },
                success: function (r) {
                    if(r.state == 2000){
                        alert('登录成功');
                        console.log(r.data);
                        location.href = '/select.html'; //跳转到主页
                    }else{
                        alert(r.message);
                    }
                },
                error: function(xhr){
                    alert("服务器忙，请稍候重试！" + xhr.status);
                }

            });
        }
    },
    created: function () {

    }
});