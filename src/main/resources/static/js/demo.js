
function post(){
    var questionId=$("#question_id").val();
    var text=$("#text").val();
    $.ajax({
        type:"POST",
        url:"/comment",
        data:JSON.stringify({
            "parentId":questionId,
            "content":text,
            "type":1
        }),
        success:function(response){
            if(response.code == 200){
                // $("#comment_section").hide();
                alert(response.message);
            }else{
                if(response.code==2001){
                    var isAccepted=confirm(response.message);
                    if(isAccepted){
                        window.open("https://github.com/login/oauth/authorize?client_id=c3dee334071c1ff8bc12&redirect_uri=http://localhost:8888/callback&scope=user&state=1");
                    }
                }
                else{
                    alert(response.message);
                }
            }
        },
        dataType:"json",
        contentType:"application/json"
});
}