package scut.yulin.trip.dto.image;

import lombok.*;
import scut.yulin.trip.dto.PageQueryDTO;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
/**
 * 图片查询DTO
 * @date 2021/04/19
 */
public class QueryImageDTO extends PageQueryDTO {
    String uuid;
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
}
