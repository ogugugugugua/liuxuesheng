package scut.yulin.trip.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import scut.yulin.common.vo.ResponseVO;
import scut.yulin.trip.dto.comment.InsertCommentDTO;
import scut.yulin.trip.dto.comment.QueryCommentDTO;
import scut.yulin.trip.model.Comment;
import scut.yulin.trip.service.CommentService;

import java.util.List;


@RestController
@RequestMapping("comment")
@Slf4j
public class CommentController {

    @Autowired
    CommentService service;


    @PostMapping("one")
    public ResponseVO addNewComment(@RequestBody InsertCommentDTO insertCommentDTO) {
        int result = service.addNewComment(insertCommentDTO);
        if (result == 1) {
            return ResponseVO.success("新增评论成功");
        }
        return ResponseVO.failed("insert failed");
    }

    @GetMapping("all")
    public ResponseVO getCommentLists(@RequestBody QueryCommentDTO queryCommentDTO) {
        try {
            List<Comment> allComments = service.getCommentLists(queryCommentDTO);
            Logger logger = LoggerFactory.getLogger(CommentController.class);
            logger.debug(allComments.toString());
            return ResponseVO.success(allComments);
        } catch (Exception e) {
            return ResponseVO.failed();
        }
    }

    @ApiOperation("根据uuid获得comment")
    @GetMapping
    public ResponseVO<Comment> getCommentByUUID(@RequestBody QueryCommentDTO queryCommentDTO) {
        Comment comment = service.getCommentByUUID(queryCommentDTO);
        if (comment != null) {
            return ResponseVO.success(comment);
        } else {
            return ResponseVO.failed("Comment with this UUID not found");
        }
    }

    @DeleteMapping("delete")
    public ResponseVO deleteComment(@RequestBody QueryCommentDTO queryCommentDTO){
        int status = service.deleteComment(queryCommentDTO);
        if (status == 1) {
            return ResponseVO.success("删除评论成功");
        }
        if (status == 2) {
            return ResponseVO.failed("目标评论不存在");
        }
        return ResponseVO.failed("删除评论失败");
    }

    @PutMapping("not/visible")
    public ResponseVO setCommentNotVisible(@RequestBody QueryCommentDTO queryCommentDTO){
        int status = service.setCommentNotVisible(queryCommentDTO);
        if (status == 1) {
            return ResponseVO.success("屏蔽违规评论成功");
        }
        return ResponseVO.failed("找不到该评论");
    }

    @PutMapping("visible")
    public ResponseVO setCommentVisible(@RequestBody QueryCommentDTO queryCommentDTO){
        System.out.println("controller:"+queryCommentDTO.toString());
        int status = service.setCommentVisible(queryCommentDTO);
        if (status == 1) {
            return ResponseVO.success("comment visible ok");
        }
        return ResponseVO.failed("comment not found");
    }

    @GetMapping("comment/schedule/list")
    public List<Comment> getCommentListByScheduleUUID(@RequestBody QueryCommentDTO queryCommentDTO) {
        return service.getCommentListByScheduleUUID(queryCommentDTO);
    }

}
