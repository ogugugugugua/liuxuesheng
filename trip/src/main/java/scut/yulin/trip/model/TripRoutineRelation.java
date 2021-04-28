package scut.yulin.trip.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * tripuuid_routineuuid_routineserial
 *
 * @author
 */
@ApiModel(value = "scut.yulin.trip.model.TripRoutineRelation某旅途id_该旅途某日安排id_该日在旅途第几天 ")
@Data
@NoArgsConstructor
public class TripRoutineRelation implements Serializable {

  /**
   * id
   */
  @ApiModelProperty(value = "id")
  private Long id;

  /**
   * uuid
   */
  @ApiModelProperty(value = "uuid")
  private String uuid;

  /**
   * 某个旅途uuid
   */
  @ApiModelProperty(value = "某个旅途uuid")
  private String tripUuid;

  /**
   * 旅途中某一天uuid
   */
  @ApiModelProperty(value = "旅途中某一天uuid")
  private String routineUuid;

  /**
   * 该天是第几天 用于排序
   */
  @ApiModelProperty(value = "该天是第几天 用于排序")
  private Integer routineSerial;

  /**
   * 创建时间
   */
  @ApiModelProperty(value = "创建时间")
  private Date createdTime;

  /**
   * 更新时间
   */
  @ApiModelProperty(value = "更新时间")
  private Date updatedTime;

  /**
   * 已删除 已删除 已删除为1,未删除为0
   */
  @ApiModelProperty(value = "已删除 已删除 已删除为1,未删除为0")
  private String deleted;

  private static final long serialVersionUID = 1L;

  public TripRoutineRelation(String uuid, String tripUuid, String routineUuid,
      Integer routineSerial) {
    this.uuid = uuid;
    this.tripUuid = tripUuid;
    this.routineUuid = routineUuid;
    this.routineSerial = routineSerial;
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
    TripRoutineRelation other = (TripRoutineRelation) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getUuid() == null ? other.getUuid() == null
        : this.getUuid().equals(other.getUuid()))
        && (this.getTripUuid() == null ? other.getTripUuid() == null
        : this.getTripUuid().equals(other.getTripUuid()))
        && (this.getRoutineUuid() == null ? other.getRoutineUuid() == null
        : this.getRoutineUuid().equals(other.getRoutineUuid()))
        && (this.getRoutineSerial() == null ? other.getRoutineSerial() == null
        : this.getRoutineSerial().equals(other.getRoutineSerial()))
        && (this.getCreatedTime() == null ? other.getCreatedTime() == null
        : this.getCreatedTime().equals(other.getCreatedTime()))
        && (this.getUpdatedTime() == null ? other.getUpdatedTime() == null
        : this.getUpdatedTime().equals(other.getUpdatedTime()))
        && (this.getDeleted() == null ? other.getDeleted() == null
        : this.getDeleted().equals(other.getDeleted()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
    result = prime * result + ((getTripUuid() == null) ? 0 : getTripUuid().hashCode());
    result = prime * result + ((getRoutineUuid() == null) ? 0 : getRoutineUuid().hashCode());
    result = prime * result + ((getRoutineSerial() == null) ? 0 : getRoutineSerial().hashCode());
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
    sb.append(", tripUuid=").append(tripUuid);
    sb.append(", routineUuid=").append(routineUuid);
    sb.append(", routineSerial=").append(routineSerial);
    sb.append(", createdTime=").append(createdTime);
    sb.append(", updatedTime=").append(updatedTime);
    sb.append(", deleted=").append(deleted);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}