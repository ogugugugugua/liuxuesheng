package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.trip.dto.comment.InsertCommentDTO;
import scut.yulin.trip.dto.comment.QueryCommentDTO;
import scut.yulin.trip.mbg.mapper.CommentDao;
import scut.yulin.trip.model.Comment;
import scut.yulin.trip.model.CommentExample;
import scut.yulin.trip.service.CommentService;

/**
 * 评论service实现类
 *
 * @date 2021/04/19
 */

@Service
public class CommentServiceImpl implements CommentService {

  @Autowired
  CommentDao commentDao;

  /**
   * 新增评论
   */
  @Override
  public int addNewComment(InsertCommentDTO insertCommentDTO) {
    String creatorUuid = insertCommentDTO.getCreatorUuid();
    String scheduleUuid = insertCommentDTO.getScheduleUuid();
    String scheduleTypeUuid = insertCommentDTO.getScheduleTypeUuid();
    String parentUuid =
        Inspections.isNotBlank(insertCommentDTO.getParentUuid()) ? insertCommentDTO.getParentUuid()
            : IdUtil.randomUUID();

    Assert.notBlank(creatorUuid);
    Assert.notBlank(scheduleUuid);
    Assert.notBlank(scheduleTypeUuid);
    Assert.notBlank(parentUuid);

    Comment comment = new Comment(IdUtil.randomUUID(),
        scheduleUuid, scheduleTypeUuid,
        creatorUuid, parentUuid,
        insertCommentDTO.getContent());

    return commentDao.insertSelective(comment);
  }

  /**
   * 根据UUID找到评论
   */
  @Override
  public Comment findCommentByUUID(QueryCommentDTO queryCommentDTO) {
    CommentExample example = new CommentExample();
    String uuid = queryCommentDTO.getUuid();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andStateEqualTo(CommonConstant.COMMENT_STATE_VISIBLE)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<Comment> comments = commentDao.selectByExample(example);
    if (comments.size() > 0) {
      return comments.get(0);
    }
    return null;
  }

  //TODO: 需要写xml
  @Override
  public Comment findParentCommentByCurrentUUID(QueryCommentDTO queryCommentDTO) {
    return null;
  }

  /**
   * 根据当前评论UUID找到其所有回复评论（子评论）
   */
  @Override
  public List<Comment> findChildrenCommentsByCurrentUUID(QueryCommentDTO queryCommentDTO) {
    CommentExample example = new CommentExample();
    String parentUuid = queryCommentDTO.getParentUuid();
    example.setLimit(queryCommentDTO.getPageSize());
    example.setOffset(queryCommentDTO.getOffset());
    example.createCriteria()
        .andParentUuidEqualTo(parentUuid)
        .andStateEqualTo(CommonConstant.COMMENT_STATE_VISIBLE)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return commentDao.selectByExample(example);
  }

  /**
   * 审核员设置评论为不可见
   */
  @Override
  public void setCommentNotVisible(QueryCommentDTO queryCommentDTO) {
    Comment comment = findCommentByUUID(queryCommentDTO);
    comment.setState(CommonConstant.COMMENT_STATE_NOT_VISIBLE);
    String uuid = queryCommentDTO.getUuid();
    CommentExample example = new CommentExample();
    example.createCriteria().andUuidEqualTo(uuid);
    commentDao.updateByExampleSelective(comment, example);
  }

  /**
   * 审核员设置评论为可见
   */
  @Override
  public void setCommentVisible(QueryCommentDTO queryCommentDTO) {
    Comment comment = findCommentByUUID(queryCommentDTO);
    comment.setState(CommonConstant.COMMENT_STATE_VISIBLE);
    String uuid = queryCommentDTO.getUuid();
    CommentExample example = new CommentExample();
    example.createCriteria().andUuidEqualTo(uuid);
    commentDao.updateByExampleSelective(comment, example);
  }

  /**
   * 查询所有的评论
   */
  @Override
  public List<Comment> findAllComments(QueryCommentDTO queryCommentDTO) {
    CommentExample example = new CommentExample();
    example.setLimit(queryCommentDTO.getPageSize());
    example.setOffset(queryCommentDTO.getOffset());
    example.createCriteria()
        .andStateEqualTo(CommonConstant.COMMENT_STATE_VISIBLE)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return commentDao.selectByExample(example);
  }

  /**
   * 根据行程类型和uuid获取该行程的所有评论
   */
  @Override
  public List<Comment> findCommentsByScheduleTypeAndScheduleUUID(QueryCommentDTO queryCommentDTO) {
    CommentExample example = new CommentExample();
    example.setLimit(queryCommentDTO.getPageSize());
    example.setOffset(queryCommentDTO.getOffset());
    example.createCriteria()
        .andScheduleTypeUuidEqualTo(queryCommentDTO.getScheduleTypeUuid())
        .andScheduleUuidEqualTo(queryCommentDTO.getScheduleUuid())
        .andDeletedEqualTo(CommonConstant.NOT_DELETED)
        .andStateEqualTo(CommonConstant.COMMENT_STATE_VISIBLE);
    return commentDao.selectByExample(example);
  }


}
