package scut.yulin.trip.service;

import scut.yulin.trip.dto.comment.InsertCommentDTO;
import scut.yulin.trip.dto.comment.QueryCommentDTO;
import scut.yulin.trip.model.Comment;

import java.util.List;

/**
 * @date 2021/04/19
 */
public interface CommentService {

    public int addNewComment(InsertCommentDTO insertCommentDTO);

    public Comment findCommentByUUID(QueryCommentDTO queryCommentDTO);

    //TODO
    public Comment findParentCommentByCurrentUUID(QueryCommentDTO queryCommentDTO);

    public List<Comment> findChildrenCommentsByCurrentUUID(QueryCommentDTO queryCommentDTO);

    public void setCommentNotVisible(QueryCommentDTO queryCommentDTO);

    public void setCommentVisible(QueryCommentDTO queryCommentDTO);

    public List<Comment> findAllComments(QueryCommentDTO queryCommentDTO);

    public List<Comment> getCommentListByScheduleUUID(QueryCommentDTO queryCommentDTO);
}
