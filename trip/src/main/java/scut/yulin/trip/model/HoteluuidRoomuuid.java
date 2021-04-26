package scut.yulin.trip.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * hoteluuid_roomuuid
 * @author 
 */
@ApiModel(value="scut.yulin.trip.model.HoteluuidRoomuuid酒店uuid_房间uuid ")
@Data
@NoArgsConstructor
public class HoteluuidRoomuuid implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * uuid
     */
    @ApiModelProperty(value="uuid")
    private String uuid;

    /**
     * 酒店uuid
     */
    @ApiModelProperty(value="酒店uuid")
    private String hotelUuid;

    /**
     * 酒店房间uuid
     */
    @ApiModelProperty(value="酒店房间uuid")
    private String roomUuid;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createdTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private Date updatedTime;

    /**
     * 已删除 yes:1,no:0
     */
    @ApiModelProperty(value="已删除 yes:1,no:0")
    private String deleted;

    private static final long serialVersionUID = 1L;

    public HoteluuidRoomuuid(String uuid, String hotelUuid, String roomUuid) {
        this.uuid = uuid;
        this.roomUuid = roomUuid;
        this.hotelUuid = hotelUuid;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HoteluuidRoomuuid other = (HoteluuidRoomuuid) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getHotelUuid() == null ? other.getHotelUuid() == null : this.getHotelUuid().equals(other.getHotelUuid()))
            && (this.getRoomUuid() == null ? other.getRoomUuid() == null : this.getRoomUuid().equals(other.getRoomUuid()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getHotelUuid() == null) ? 0 : getHotelUuid().hashCode());
        result = prime * result + ((getRoomUuid() == null) ? 0 : getRoomUuid().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uuid=").append(uuid);
        sb.append(", hotelUuid=").append(hotelUuid);
        sb.append(", roomUuid=").append(roomUuid);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}