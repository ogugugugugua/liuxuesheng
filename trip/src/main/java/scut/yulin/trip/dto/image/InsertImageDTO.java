package scut.yulin.trip.dto.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * @date 2021/04/19
 */
public class InsertImageDTO {
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
     * 图片名字
     */
    private String name;

    /**
     * url连接
     */
    private String url;

    /**
     * 头图 yes:1,no:0
     */
    private String headImage;
}
