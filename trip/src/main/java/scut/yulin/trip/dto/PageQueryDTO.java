package scut.yulin.trip.dto;

import lombok.*;


@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PageQueryDTO {
    /**
     * 页码
     */
    Integer page = 1;

    /**
     * 每页数据量
     */
    Integer pageSize = 10;

    /**
     * offset
     */
    private Long offset;

    public Long getOffset() {
        return Long.valueOf(pageSize * (page - 1));
    }
}
