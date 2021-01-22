let test = new Vue({
    el:'#test',
    data:{
        userData:{
            "id": 4,
            "uid": 3,
            "solvedTotal": 0,
            "acTotal": 0,
            "woTotal": 0,
            "gmtCreate": "2021-01-19T10:55:35",
            "gmtModified": "2021-01-19T11:00:46"
        }
    },
    methods: {
        loadInfo: function () {
            $.ajax({
                url: '/user/detail',
                type: 'get',
                data: {

                },
                success: function (r) {
                    if( r.state == 2000) {
                        test.userData = r.data;
                    }else {
                        alert("加载失败" + r.message + "!");
                    }
                },
                error:function(xhr) {
                    alert("服务器忙，请稍候重试！"+xhr.status);
                }
            });
        }
    },
    created : function (){
        this.loadInfo();
    }
})
let userInfoApp = new Vue({
    el: '#userInfoApp', //Vue绑定要操作的元素
    data: { //Vue绑定的数据（可供页面上元素显示）
        user : {
            username: '',
            phone: '',
            email: '',
            gender: 0,
        }
    },
    methods: {
        //加载用户资料
        loadInfo: function () {
            $.ajax({
                url: '/user/get_by_id',  //请求url
                type: 'get', //请求类型
                data: { //请求参数

                },
                success: function (r) {
                    if(r.state == 2000){
                        userInfoApp.user = r.data ;
                    }else{
                        alert('获取用户资料失败，' + r.message + "！");
                    }
                },
                error: function(xhr){
                    alert("服务器忙，请稍候重试！" + xhr.status);
                }
            });
        },
        changeInfo: function () {
            //发送ajax请求，请求服务器更新用户资料
            $.ajax({
                url: '/user/changeInfo',
                type: 'post',
                data: {
                    phone: $("#phone").val(),
                    email: $("#email").val(),
                    //$("#male").prop('checked'):
                    // 获取id为male元素的checked属性值,若选中,返回true;
                    //否则返回false
                    gender: $("#male").prop('checked')?$('#male').val():
                        ($("#female").prop('checked')?$('#female').val():null)
                },
                success: function (r) {
                    if( r.state == 2000) {
                        alert("修改成功");
                    }else {
                        alert("修改用户资料失败" + r.message + "!");
                    }
                },
                error:function(xhr) {
                    alert("服务器忙，请稍候重试！"+xhr.status);
                }
            });
        }
    },
    created: function () {  //Vue对象建立完成时，要执行的匿名函数
        this.loadInfo() ; //调用loadInfo方法执行
    }
});
