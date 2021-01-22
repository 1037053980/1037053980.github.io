let QA = new Vue({
    el:'#QA',
    data:{
        user: {
            "id": 6,
            "title": "",
            "typeName": "",
            "typeId": 1,
            "answer1": "",
            "answer2": "",
            "answer3": "",
            "answer4": "",
            "correct": 1,
            "gmtCreate": "2021-01-18T19:48:09",
            "gmtModified": "2021-01-18T19:48:09"
        }
    },
    methods:{
        loadQ: function (){
            // alert("ok,开始加载");
            let data = sessionStorage.getItem("courseId");
            $.ajax({
                url:'/question/get_question_unsolved',   //向user/question发出请求，获取问题数据
                type:'get',
                data:{  //请求参数
                    type:data
                },
                success: function (r) {
                    if(r.state == 2000){
                        if(r.data == null){
                            alert("所有题目你都刷完了!");
                            QA.user = null;
                        }
                        QA.user = r.data ;
                    }else{
                        alert('获取问题失败，' + r.message + "！");
                    }
                },
                error: function(xhr){
                    alert("服务器忙，请稍候重试！" + xhr.status);
                },
            });
        },
        confirm:function () {
            // console.log($('input:radio[name=' + "radio_1"+ ']:checked').val());
            // QA.user[0].correct = $('input:radio[name=' + "radio_1"+ ']:checked').val();
            // console.log(QA.user[0].correct);
            $.ajax({
                url:'/question/judge',   //向user/answer发出请求，提交答案
                type:'post',
                data:{  //请求参数
                    qid:QA.user.id,
                    select:$("#radio_1").prop('checked')?$('#radio_1').val():
                        ($("#radio_2").prop('checked')?$('#radio_2').val():
                            ($("#radio_3").prop('checked')?$('#radio_3').val():
                                ($("#radio_4").prop('checked')?$('#radio_4').val():null)))
                },
                success: function (r) {

                    if(r.state == 2000){
                      //  alert(r.data.result);
                        if (r.data.result) alert("回答正确");
                        else{
                            alert("回答错误");
                        }
                        if(QA.user.correct == 1) alert("正确答案是A " + QA.user.answer1);
                        else if(QA.user.correct == 2) alert("正确答案是B " + QA.user.answer2);
                        else if(QA.user.correct == 3) alert("正确答案是C " + QA.user.answer3);
                        else if(QA.user.correct == 4) alert("正确答案是D " + QA.user.answer4);

                        location.href='/question.html';  //成功下一题
                    }else{
                        alert('提交数据失败，' + r.message + "！");
                    }
                },
                error: function(xhr){
                    alert("服务器忙，请稍候重试！" + xhr.status);
                },
            });
        }
    },
    created:function (){
        this.loadQ();
    }

})