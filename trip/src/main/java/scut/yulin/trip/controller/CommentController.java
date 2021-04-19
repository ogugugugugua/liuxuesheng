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
    public ResponseVO insertComment(@RequestBody InsertCommentDTO insertCommentDTO) {
        int result = service.addNewComment(insertCommentDTO);
        if (result == 1) {
            return ResponseVO.success("insert ok");
        }
        return ResponseVO.failed("insert failed");
    }

    @GetMapping("all")
    public ResponseVO getAllCommentList(@RequestBody QueryCommentDTO queryCommentDTO) {
        try {
            List<Comment> allComments = service.findAllComments(queryCommentDTO);
            Logger logger = LoggerFactory.getLogger(CommentController.class);
            logger.debug(allComments.toString());
            System.out.println("----->" + allComments.toString());
            return ResponseVO.success(allComments);
        } catch (Exception e) {
            return ResponseVO.failed();
        }
    }

    @ApiOperation("根据uuid获得comment")
    @GetMapping
    public ResponseVO<Comment> findCommentByUUID(@RequestBody QueryCommentDTO queryCommentDTO) {
        Comment comment = service.findCommentByUUID(queryCommentDTO);
        if (comment != null) {
            return ResponseVO.success(comment);
        } else {
            return ResponseVO.failed("Comment with this UUID not found");
        }
    }

}
