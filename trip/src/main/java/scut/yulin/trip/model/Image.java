package scut.yulin.trip.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * image 类
 * @author xieyulin
 * @date 2021/04/19
 */
@ApiModel(value="scut.yulin.trip.model.Image 图片")
@Data
public class Image implements Serializable {
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
     * 关联行程uuid
     */
    @ApiModelProperty(value="关联行程uuid")
    private String scheduleUuid;

    /**
     * 关联行程类型uuid
     */
    @ApiModelProperty(value="关联行程类型uuid")
    private String scheduleTypeUuid;

    /**
     * 图片名称
     */
    @ApiModelProperty(value="图片名称")
    private String name;

    /**
     * url连接
     */
    @ApiModelProperty(value="url连接")
    private String url;

    /**
     * 头图 yes:1,no:0
     */
    @ApiModelProperty(value="头图 yes:1,no:0")
    private String headImage;

    /**
     * 创建人uuid
     */
    @ApiModelProperty(value="创建人uuid")
    private String creatorUuid;

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

    public Image(String uuid,
                 String scheduleUuid, String scheduleTypeUuid,
                 String creatorUuid,
                 String name, String url,
                 String headImage){
        this.uuid = uuid;
        this.scheduleTypeUuid = scheduleTypeUuid;
        this.scheduleUuid = scheduleUuid;
        this.creatorUuid = creatorUuid;
        this.name = name;
        this.url = url;
        this.headImage = headImage;
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
        Image other = (Image) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getScheduleUuid() == null ? other.getScheduleUuid() == null : this.getScheduleUuid().equals(other.getScheduleUuid()))
            && (this.getScheduleTypeUuid() == null ? other.getScheduleTypeUuid() == null : this.getScheduleTypeUuid().equals(other.getScheduleTypeUuid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getHeadImage() == null ? other.getHeadImage() == null : this.getHeadImage().equals(other.getHeadImage()))
            && (this.getCreatorUuid() == null ? other.getCreatorUuid() == null : this.getCreatorUuid().equals(other.getCreatorUuid()))
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
        result = prime * result + ((getScheduleUuid() == null) ? 0 : getScheduleUuid().hashCode());
        result = prime * result + ((getScheduleTypeUuid() == null) ? 0 : getScheduleTypeUuid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getHeadImage() == null) ? 0 : getHeadImage().hashCode());
        result = prime * result + ((getCreatorUuid() == null) ? 0 : getCreatorUuid().hashCode());
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
        sb.append(", scheduleUuid=").append(scheduleUuid);
        sb.append(", scheduleTypeUuid=").append(scheduleTypeUuid);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", headImage=").append(headImage);
        sb.append(", creatorUuid=").append(creatorUuid);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}