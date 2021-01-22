let addQueApp = new Vue({
    el: '#addApp',
    data: {

    },
    methods: {
        addQ: function () {

            $.ajax({
                url: '/question/add_question',  //请求url
                type: 'post', //请求类型
                data: { //请求参数
                    title:$("#q_title").val(),
                    typeName:$("#q_type").val(),
                    answer1:$("#q_answer1").val(),
                    answer2:$("#q_answer2").val(),
                    answer3:$("#q_answer3").val(),
                    answer4:$("#q_answer4").val(),
                    correct:$("#q_correct").val()
                },
                success: function (r) {
                    if(r.state == 2000){
                        alert('添加成功');
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