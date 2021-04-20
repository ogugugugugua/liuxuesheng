package scut.yulin.trip.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * comment
 * @author 
 */
@ApiModel(value="scut.yulin.trip.model.Comment评论 ")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment implements Serializable {
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
     * 创建人uuid
     */
    @ApiModelProperty(value="创建人uuid")
    private String creatorUuid;

    /**
     * 上级评论uuid 0表示顶级评论
     */
    @ApiModelProperty(value="上级评论uuid 0表示顶级评论")
    private String parentUuid;

    /**
     * 评论内容
     */
    @ApiModelProperty(value="评论内容")
    private String content;

    /**
     * 用户对所评论对象的偏好 yes:1,no:0
     */
    @ApiModelProperty(value="用户对所评论对象的偏好 yes:1,no:0")
    private String preference;

    /**
     * 评论被点赞数
     */
    @ApiModelProperty(value="评论被点赞数")
    private Integer approved;

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
     * 状态 可见:1,不可见:0
     */
    @ApiModelProperty(value="状态 可见:1,不可见:0")
    private String state;

    /**
     * 已删除 yes:1,no:0
     */
    @ApiModelProperty(value="已删除 yes:1,no:0")
    private String deleted;

    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public String getParentUuid() {
        return parentUuid;
    }

    public String getContent() {
        return content;
    }

    public Integer getApproved() {
        return approved;
    }

    public String getState() {
        return state;
    }

    public Comment(String uuid,
                   String scheduleUuid, String scheduleTypeUuid,
                   String creatorUuid, String parentUuid,
                   String content){
        this.uuid = uuid;
        this.scheduleUuid = scheduleUuid;
        this.scheduleTypeUuid = scheduleTypeUuid;
        this.creatorUuid = creatorUuid;
        this.parentUuid = parentUuid;
        this.content = content;
    }
//
//    public Comment(String uuid,
//                   String scheduleUuid, String scheduleTypeUuid,
//                   String creatorUuid, String content){
//        this.uuid = uuid;
//        this.scheduleUuid = scheduleUuid;
//        this.scheduleTypeUuid = scheduleTypeUuid;
//        this.creatorUuid = creatorUuid;
//        this.content = content;
//    }


//    @Override
//    public boolean equals(Object that) {
//        if (this == that) {
//            return true;
//        }
//        if (that == null) {
//            return false;
//        }
//        if (getClass() != that.getClass()) {
//            return false;
//        }
//        Comment other = (Comment) that;
//        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
//            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
//            && (this.getScheduleUuid() == null ? other.getScheduleUuid() == null : this.getScheduleUuid().equals(other.getScheduleUuid()))
//            && (this.getScheduleTypeUuid() == null ? other.getScheduleTypeUuid() == null : this.getScheduleTypeUuid().equals(other.getScheduleTypeUuid()))
//            && (this.getCreatorUuid() == null ? other.getCreatorUuid() == null : this.getCreatorUuid().equals(other.getCreatorUuid()))
//            && (this.getParentUuid() == null ? other.getParentUuid() == null : this.getParentUuid().equals(other.getParentUuid()))
//            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
//            && (this.getPreference() == null ? other.getPreference() == null : this.getPreference().equals(other.getPreference()))
//            && (this.getApproved() == null ? other.getApproved() == null : this.getApproved().equals(other.getApproved()))
//            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
//            && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null : this.getUpdatedTime().equals(other.getUpdatedTime()))
//            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
//            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
//    }
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
//        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
//        result = prime * result + ((getScheduleUuid() == null) ? 0 : getScheduleUuid().hashCode());
//        result = prime * result + ((getScheduleTypeUuid() == null) ? 0 : getScheduleTypeUuid().hashCode());
//        result = prime * result + ((getCreatorUuid() == null) ? 0 : getCreatorUuid().hashCode());
//        result = prime * result + ((getParentUuid() == null) ? 0 : getParentUuid().hashCode());
//        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
//        result = prime * result + ((getPreference() == null) ? 0 : getPreference().hashCode());
//        result = prime * result + ((getApproved() == null) ? 0 : getApproved().hashCode());
//        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
//        result = prime * result + ((getUpdatedTime() == null) ? 0 : getUpdatedTime().hashCode());
//        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
//        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
//        return result;
//    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(getClass().getSimpleName());
//        sb.append(" [");
//        sb.append("Hash = ").append(hashCode());
//        sb.append(", id=").append(id);
//        sb.append(", uuid=").append(uuid);
//        sb.append(", scheduleUuid=").append(scheduleUuid);
//        sb.append(", scheduleTypeUuid=").append(scheduleTypeUuid);
//        sb.append(", creatorUuid=").append(creatorUuid);
//        sb.append(", parentUuid=").append(parentUuid);
//        sb.append(", content=").append(content);
//        sb.append(", preference=").append(preference);
//        sb.append(", approved=").append(approved);
//        sb.append(", createdTime=").append(createdTime);
//        sb.append(", updatedTime=").append(updatedTime);
//        sb.append(", state=").append(state);
//        sb.append(", deleted=").append(deleted);
//        sb.append(", serialVersionUID=").append(serialVersionUID);
//        sb.append("]");
//        return sb.toString();
//    }
}