package scut.yulin.es.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * bed
 *
 * @author
 */
@ApiModel(value = "scut.yulin.trip.model.Bed酒店房间床规格")
@Data
@NoArgsConstructor
public class EsBed implements Serializable {

  /**
   * 床型id
   */
  @ApiModelProperty(value = "床型id")
  private Long id;

  /**
   * uuid
   */
  @ApiModelProperty(value = "uuid")
  private String uuid;

  /**
   * 房间uuid
   */
  @ApiModelProperty(value = "房间uuid")
  private String roomUuid;

  /**
   * 类型 双人床,单人床,沙发床,榻榻米
   */
  @ApiModelProperty(value = "类型 双人床,单人床,沙发床,榻榻米")
  private String type;

  /**
   * 该床型可容纳人数
   */
  @ApiModelProperty(value = "该床型可容纳人数")
  private Integer numberPerson;

  /**
   * 房间里该床型数量
   */
  @ApiModelProperty(value = "房间里该床型数量")
  private Integer quantity;

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
   * 已删除 yes:1,no:0
   */
  @ApiModelProperty(value = "已删除 yes:1,no:0")
  private String deleted;

  private static final long serialVersionUID = 1L;

  public EsBed(String uuid, Integer numberPerson, String type, String roomUuid,
      Integer quantity) {
    this.uuid = uuid;
    this.numberPerson = numberPerson;
    this.type = type;
    this.roomUuid = roomUuid;
    this.quantity = quantity;
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
    EsBed other = (EsBed) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getUuid() == null ? other.getUuid() == null
        : this.getUuid().equals(other.getUuid()))
        && (this.getRoomUuid() == null ? other.getRoomUuid() == null
        : this.getRoomUuid().equals(other.getRoomUuid()))
        && (this.getType() == null ? other.getType() == null
        : this.getType().equals(other.getType()))
        && (this.getNumberPerson() == null ? other.getNumberPerson() == null
        : this.getNumberPerson().equals(other.getNumberPerson()))
        && (this.getQuantity() == null ? other.getQuantity() == null
        : this.getQuantity().equals(other.getQuantity()))
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
    result = prime * result + ((getRoomUuid() == null) ? 0 : getRoomUuid().hashCode());
    result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
    result = prime * result + ((getNumberPerson() == null) ? 0 : getNumberPerson().hashCode());
    result = prime * result + ((getQuantity() == null) ? 0 : getQuantity().hashCode());
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
    sb.append(", roomUuid=").append(roomUuid);
    sb.append(", type=").append(type);
    sb.append(", numberPerson=").append(numberPerson);
    sb.append(", quantity=").append(quantity);
    sb.append(", createdTime=").append(createdTime);
    sb.append(", updatedTime=").append(updatedTime);
    sb.append(", deleted=").append(deleted);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}