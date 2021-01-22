let passwordApp = new Vue({
    el: '#passwordApp', //Vue绑定的要操作的元素
    data:{ //绑定的数据

    },
    methods:{ //方法
        changePassword: function () {
            //检验数据的有效性
            if( $("#oldPassword").val() == "" ){
                alert("原密码不能为空");
                return;
            }

            if( $("#newPassword").val() == "" ){
                alert("新密码不能为空");
                return;
            }

            if ( $("#newPassword").val() != $("#newPassword2").val() ) {
                alert("两次新密码输入不一致");
                return;
            }

            //发送ajax请求，请求服务器注册
            $.ajax({
                url: '/user/change_password',
                type: 'post',
                data: {
                    oldPassword: $("#oldPassword").val(),
                    newPassword: $("#newPassword").val()
                },
                success: function (r) {
                    if( r.state == 2000) {
                        alert("修改密码成功");
                        location.href = "/index.html"; //跳转到主页
                    }else {
                        alert("修改密码失败！" + r.message +"！");
                    }
                },
                error:function(xhr) {
                    alert("服务器忙，请稍候重试！"+xhr.status);
                }
            });
        }
    },
    created: function() { //Vue对象建立完成时要自动执行的匿名函数
        //alert("Vue对象建立完成...");
    }
});