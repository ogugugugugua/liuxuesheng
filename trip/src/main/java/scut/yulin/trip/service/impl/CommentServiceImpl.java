package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.trip.dto.comment.InsertCommentDTO;
import scut.yulin.trip.dto.comment.QueryCommentDTO;
import scut.yulin.trip.mbg.mapper.CommentDao;
import scut.yulin.trip.model.Comment;
import scut.yulin.trip.model.CommentExample;
import scut.yulin.trip.model.CommentExample.Criteria;
import scut.yulin.trip.service.CommentService;

/**
 * 评论service实现类
 *
 * @date 2021/04/19
 */

@Service
@Slf4j
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
            : "0";

//    Assert.notBlank(creatorUuid);
    creatorUuid = IdUtil.randomUUID();
    Assert.notBlank(scheduleUuid);
    Assert.notBlank(scheduleTypeUuid);
//    Assert.notBlank(parentUuid);

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
  public Comment getCommentByUUID(QueryCommentDTO queryCommentDTO) {
    return this.getCommentWithCondition(queryCommentDTO, false, true);
  }

  private Comment getCommentWithCondition(QueryCommentDTO queryCommentDTO,
      Boolean DELETED, Boolean VISIBLE) {
    String uuid = queryCommentDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    CommentExample example = new CommentExample();
    Criteria criteria = example.createCriteria();
    criteria.andUuidEqualTo(uuid);

    if (DELETED) {
      criteria.andDeletedEqualTo(CommonConstant.DELETED);
    } else {
      criteria.andDeletedEqualTo(CommonConstant.NOT_DELETED);
      if (VISIBLE) {
        criteria.andStateEqualTo(CommonConstant.COMMENT_STATE_VISIBLE);
      } else {
        criteria.andStateEqualTo(CommonConstant.COMMENT_STATE_NOT_VISIBLE);
      }
    }

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
  public int setCommentNotVisible(QueryCommentDTO queryCommentDTO) {
    String uuid = queryCommentDTO.getUuid();
    System.out.println("uuid:" + uuid);
    if (uuid == null) {
      return 2;
    }
    System.out.println("setCommentNotVisible uuid ok");
    Comment comment = this.getCommentWithCondition(queryCommentDTO,false,true);
    if (comment == null) {
      return 2;
    }
    System.out.println("setCommentNotVisible comment ok");
    comment.setState(CommonConstant.COMMENT_STATE_NOT_VISIBLE);
    CommentExample example = new CommentExample();
    example.createCriteria().andUuidEqualTo(uuid);
    commentDao.updateByExampleSelective(comment, example);
    return 1;
  }

  /**
   * 审核员设置评论为可见
   */
  @Override
  public int setCommentVisible(QueryCommentDTO queryCommentDTO) {
    String uuid = queryCommentDTO.getUuid();
    if (uuid == null) {
      return 2;
    }
    System.out.println("setCommentVisible uuid ok");
    Comment comment = this.getCommentWithCondition(queryCommentDTO,false,false);
    if (comment == null) {
      return 2;
    }
    System.out.println("setCommentVisible comment ok");
    comment.setState(CommonConstant.COMMENT_STATE_VISIBLE);
    CommentExample example = new CommentExample();
    example.createCriteria().andUuidEqualTo(uuid);
    commentDao.updateByExampleSelective(comment, example);
    return 1;
  }

  /**
   * 查询所有的评论
   */
  @Override
  public List<Comment> getCommentLists(QueryCommentDTO queryCommentDTO) {
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
  public List<Comment> getCommentListByScheduleUUID(QueryCommentDTO queryCommentDTO) {
    String scheduleUuid = queryCommentDTO.getScheduleUuid();
    if (scheduleUuid == null) {
      return null;
    }
    CommentExample example = new CommentExample();
    example.setLimit(queryCommentDTO.getPageSize());
    example.setOffset(queryCommentDTO.getOffset());
    example.createCriteria()
        .andScheduleUuidEqualTo(scheduleUuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED)
        .andStateEqualTo(CommonConstant.COMMENT_STATE_VISIBLE);
    return commentDao.selectByExample(example);
  }

  @Override
  public int deleteComment(QueryCommentDTO queryCommentDTO) {
    String uuid = queryCommentDTO.getUuid();
    if (uuid == null) {
      log.debug("delete comment uuid not found");
      return 2;
    }
    Comment comment = this.getCommentByUUID(queryCommentDTO);
    if (comment == null) {
      log.debug("delete comment not found");
      return 2;
    }

    comment.setDeleted(CommonConstant.DELETED);

    CommentExample example = new CommentExample();
    example.createCriteria().andUuidEqualTo(uuid);

    commentDao.updateByExampleSelective(comment, example);
    return 1;
  }


}
