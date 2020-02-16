function post() {
    var bid = $("#bid").val();
    var parentid = $("#parentid").val();
    var commentcontent = $("#commentcontent").val();
    console.log(commentcontent);
    if (!commentcontent) {
        alert("不能回复空内容");
        return;
    }
    /**
     * 一次回复
     */
    $('#comment-show').load("/comment",{
        "id" : bid,
        "content" : commentcontent,
        "parentCommentId": parentid
    }, function () {
        if (parentid != -1) {
            $(window).scrollTo("#"+parentid+"", 400);
            clearContent();
        }else {
            window.location.reload();
        }
    });

}
function clearContent() {
    $("#parentid").val(-1);
    $("#commentcontent").val('');
}
function replay(obj) {
    var commId = $(obj).data('id');
    var commNickname = $(obj).data('nickname');
    $('#commentcontent').attr('placeholder','@'+commNickname).focus();
    $('#parentid').val(commId);
    $(window).scrollTo('#comment-container', 400);
}
