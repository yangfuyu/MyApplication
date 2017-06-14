package com.bc.mcapp.entity.commentlist;

//点击评价和全部评价的数据
//http://localhost:8080/MeiChe/comment?cmd=getCommentList&goodsId=1
public class CommentList_data {
private CommentTags commentTags;
private Comments comments;
public CommentTags getCommentTags() {
	return commentTags;
}
public void setCommentTags(CommentTags commentTags) {
	this.commentTags = commentTags;
}
public Comments getComments() {
	return comments;
}
public void setComments(Comments comments) {
	this.comments = comments;
}
@Override
public String toString() {
	return "CommentList_data [commentTags=" + commentTags + ", comments="
			+ comments + "]";
}

}
