let registerApp =new Vue({
    el:'#registerApp',//Vue绑定的要操作的元素
    data:{//绑定的数据

    },
    methods:{//方法
        reg:function () {
            //检验数据的有效性
            if($("#username").val()== ""){
                alert("手机号码不能为空");
                return;
            }
            var reg=/^1[3456789]\d{9}$/;
            if(!reg.test($("#username").val())) {
                alert("请输入正确手机号");
                return;
            }
            if($("#password").val()==""){
                alert("密码不能为空");
                return;
            }
            if($("#password").val()!= $("#password2").val()){
                alert("两次密码不一致");
                return;
            }
            //发送ajax请求，请求服务器注册
            $.ajax({
                url:'/user/register',
                type:'post',
                data:{
                    username:$("#username").val(),
                    password:$("#password").val()
                },
                success:function (r) {
                    console.log(r);
                    if(r.state == 2000){
                        alert("注册成功");
                        location.href = "/index.html"; //跳转到登录页
                    }else {
                        alert(r.message);
                        // location.href = "/login.html"; //跳转到登录页
                    }
                },
                error:function (xhr) {
                    alert("服务器繁忙，请稍后重试！" + xhr.status);
                }
            });
        }
    },
    created:function () {//Vue对象建立完成时要执行的匿名函数
        //alert("Vue对象建立完成...");
    }
});