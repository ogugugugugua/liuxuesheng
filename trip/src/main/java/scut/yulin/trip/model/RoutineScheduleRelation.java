package scut.yulin.trip.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * routineuuid_scheduleuuid_scheduletypeuuid_scheduleserial
 * @author 
 */
@ApiModel(value="scut.yulin.trip.model.RoutineScheduleRelation某日安排id_该日某行程id_该行程类型id_该行程在该日中排序序号 ")
@Data
@NoArgsConstructor
public class RoutineScheduleRelation implements Serializable {
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
     * 某一天uuid
     */
    @ApiModelProperty(value="某一天uuid")
    private String routineUuid;

    /**
     * 当天某行程uuid
     */
    @ApiModelProperty(value="当天某行程uuid")
    private String scheduleUuid;

    /**
     * 该行程类型uuid
     */
    @ApiModelProperty(value="该行程类型uuid")
    private String scheduleTypeUuid;

    /**
     * 该行程序号 用于排序
     */
    @ApiModelProperty(value="该行程序号 用于排序")
    private Integer scheduleSerial;

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
     * 已删除 已删除为1,未删除为0
     */
    @ApiModelProperty(value="已删除 已删除为1,未删除为0")
    private String deleted;

    private static final long serialVersionUID = 1L;

    public RoutineScheduleRelation(String uuid, String routineUuid, String scheduleUuid,
        String scheduleTypeUuid, Integer scheduleSerial) {
        this.uuid = uuid;
        this.routineUuid = routineUuid;
        this.scheduleSerial = scheduleSerial;
        this.scheduleUuid = scheduleUuid;
        this.scheduleTypeUuid = scheduleTypeUuid;
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
        RoutineScheduleRelation other = (RoutineScheduleRelation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getRoutineUuid() == null ? other.getRoutineUuid() == null : this.getRoutineUuid().equals(other.getRoutineUuid()))
            && (this.getScheduleUuid() == null ? other.getScheduleUuid() == null : this.getScheduleUuid().equals(other.getScheduleUuid()))
            && (this.getScheduleTypeUuid() == null ? other.getScheduleTypeUuid() == null : this.getScheduleTypeUuid().equals(other.getScheduleTypeUuid()))
            && (this.getScheduleSerial() == null ? other.getScheduleSerial() == null : this.getScheduleSerial().equals(other.getScheduleSerial()))
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
        result = prime * result + ((getRoutineUuid() == null) ? 0 : getRoutineUuid().hashCode());
        result = prime * result + ((getScheduleUuid() == null) ? 0 : getScheduleUuid().hashCode());
        result = prime * result + ((getScheduleTypeUuid() == null) ? 0 : getScheduleTypeUuid().hashCode());
        result = prime * result + ((getScheduleSerial() == null) ? 0 : getScheduleSerial().hashCode());
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
        sb.append(", routineUuid=").append(routineUuid);
        sb.append(", scheduleUuid=").append(scheduleUuid);
        sb.append(", scheduleTypeUuid=").append(scheduleTypeUuid);
        sb.append(", scheduleSerial=").append(scheduleSerial);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}