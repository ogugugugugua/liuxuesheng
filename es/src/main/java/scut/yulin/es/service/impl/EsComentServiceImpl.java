package scut.yulin.es.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import scut.yulin.es.domain.EsComment;
import scut.yulin.es.service.EsCommentService;
import scut.yulin.trip.model.Comment;

/**
 * @Date 2021/6/20
 * @Author xieyulin
 * @Description TODO
 **/
@Service
public class EsComentServiceImpl implements EsCommentService {

  @Override
  public EsComment transform(Comment comment) {
    return null;
  }

  @Override
  public String transform(List<Comment> comment) {
    return null;
  }
}
