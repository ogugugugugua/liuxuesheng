package scut.yulin.es.service;

import java.util.List;
import org.springframework.stereotype.Service;
import scut.yulin.es.domain.EsComment;
import scut.yulin.trip.model.Comment;

/**
 * @Date 2021/6/18
 * @Author xieyulin
 * @Description TODO
 **/
public interface EsCommentService {

  EsComment transform(Comment comment);

  String transform(List<Comment> comment);
}
