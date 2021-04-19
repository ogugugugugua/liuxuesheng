package scut.yulin.trip.dto;

import lombok.*;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class PageQueryDTO {
    /**
     * 页码
     */
    @NonNull
    Integer page;

    /**
     * 每页数据量
     */
    @NonNull
    Integer pageSize;

    /**
     * offset
     */
    private Long offset;

    public Long getOffset() {
        return Long.valueOf(pageSize * (page - 1));
    }
}
