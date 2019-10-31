
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
            }
        },
        dataType:"json",
        contentType:"application/json"
});
}