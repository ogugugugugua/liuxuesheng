package scut.yulin.trip.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class InsertCommentDTO {
    /**
     * 关联行程uuid
     */
    private String scheduleUuid;

    /**
     * 关联行程类型uuid
     */
    private String scheduleTypeUuid;

    /**
     * 创建人uuid
     */
    private String creatorUuid;

    /**
     * 上级评论uuid 0表示顶级评论
     */
    private String parentUuid;

    /**
     * 评论内容
     */
    private String content;

}
