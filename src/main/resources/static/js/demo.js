/**
 * 展开二级评论
 */
function collapseComments(e){
    var id = e.getAttribute("data-id");
    var comments = $("#comment-"+id);

    var collapse = e.getAttribute("data-collapse");
    if(collapse){
        //折叠二级评论
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    }else{
        //展开二级评论
        comments.addClass("in");
        //标记二级评论展开状态。
        e.setAttribute("data-collapse","in");
        e.classList.add("active");
    }
}

/**
 * 提交回复
 */
function post(){
    var questionId=$("#question_id").val();
    var text=$("#text").val();
    comment2target(questionId,1,text);
}

function comment2target(targetId,type,content){
    var txt=content.replace(/\s*/g,"");
    if(txt.length>0){
        $.ajax({
            type:"POST",
            url:"/comment",
            dataType:"json",
            contentType:"application/json",
            data:JSON.stringify({
                "parentId":targetId,
                "content":txt,
                "type":type
            }),
            success:function(response){
                if(response.code == 200){
                    window.history.go(0);
                }else{
                    if(response.code==2002){
                        var isAccepted = confirm(response.message);
                        if(isAccepted){
                            window.open("https://github.com/login/oauth/authorize?client_id=c3dee334071c1ff8bc12&redirect_uri=http://localhost:8888/callback&scope=user&state=1");
                            window.localStorage.setItem("closable",true);
                        }
                    }else{
                        alert(response.message);
                    }
                }
            }
        });
    }else{
        alert("评论不能为空！");
    }
}

/**
 * 提交二级评论
 * @param commentId
 */
function comment(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#input-"+commentId).val();
    comment2target(commentId,2,content);
}