package scut.yulin.trip.dto.comment;

import lombok.*;
import scut.yulin.trip.dto.PageQueryDTO;

/**
 *
 */
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QueryCommentDTO extends PageQueryDTO {
    private String uuid;
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
}
