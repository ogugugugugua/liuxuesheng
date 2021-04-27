package scut.yulin.trip.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * routine
 * @author 
 */
@ApiModel(value="scut.yulin.trip.model.Routine日安排")
@Data
@NoArgsConstructor
public class Routine implements Serializable {
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
     * 当前日期
     */
    @ApiModelProperty(value="当前日期")
    private Date curDate;

    /**
     * 补充信息
     */
    @ApiModelProperty(value="补充信息")
    private String supplement;

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
        Routine other = (Routine) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getCurDate() == null ? other.getCurDate() == null : this.getCurDate().equals(other.getCurDate()))
            && (this.getSupplement() == null ? other.getSupplement() == null : this.getSupplement().equals(other.getSupplement()))
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
        result = prime * result + ((getCurDate() == null) ? 0 : getCurDate().hashCode());
        result = prime * result + ((getSupplement() == null) ? 0 : getSupplement().hashCode());
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
        sb.append(", curDate=").append(curDate);
        sb.append(", supplement=").append(supplement);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}