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

    public Comment getCommentByUUID(QueryCommentDTO queryCommentDTO);

    //TODO
    public Comment findParentCommentByCurrentUUID(QueryCommentDTO queryCommentDTO);

    public List<Comment> findChildrenCommentsByCurrentUUID(QueryCommentDTO queryCommentDTO);

    public int setCommentNotVisible(QueryCommentDTO queryCommentDTO);

    public int setCommentVisible(QueryCommentDTO queryCommentDTO);

    public List<Comment> getCommentLists(QueryCommentDTO queryCommentDTO);

    public List<Comment> getCommentListByScheduleUUID(QueryCommentDTO queryCommentDTO);

    public int deleteComment(QueryCommentDTO queryCommentDTO);

}
