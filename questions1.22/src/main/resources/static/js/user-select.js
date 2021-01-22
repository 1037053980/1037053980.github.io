let app = new Vue({
    el:'#sub',
    data:{
        typeList:[
            {
                "id": 1,
                "title": "数据结构",
                "gmtCreate": "2021-01-16T21:17:40",
                "gmtModified": "2021-01-16T21:17:40"
            },
            {
                "id": 2,
                "title": "离散数学",
                "gmtCreate": "2021-01-17T19:26:35",
                "gmtModified": "2021-01-17T19:26:35"
            }
        ]
    },
    methods: {
        reg: function(){
            $.ajax({
                url: '/que_type/get_type_list',  //请求url
                type: 'get', //请求类型
                data: { //请求参数
                    
                },
                success: function (r) {
                    if(r.state == 2000){
                        app.typeList = r.data ;
                    }else{
                        alert('获取失败，' + r.message + "！");
                    }
                },
                error: function(xhr){
                    alert("服务器忙，请稍候重试！" + xhr.status);
                }
            });
        },
        jump:function (course_id) {
            sessionStorage.setItem("courseId",course_id);
            //跳转到修改页面
            window.location.href="/question.html";
        }
    },
    created:function (){
        this.reg();
    }

})


let show_up = new Vue({
    el:'#show',
    data:{
        isAdMi:{
            "id":false
        }
    },
    methods: {
        isAdminister:function () {
            $.ajax({
                url: '/user/is_administer',  //请求url
                type: 'get', //请求类型
                data: { //请求参数

                },
                success: function (r) {
                    if(r.state == 2000){
                        if (r.data == 1) {
                            show_up.isAdMi.id = true;
                        }

                    }else{
                        alert('获取失败，' + r.message + "！");
                    }
                },
                error: function(xhr){
                    alert("服务器忙，请稍候重试！" + xhr.status);
                }
            });
        }
    },
    created:function (){
        this.isAdminister();
    }
})