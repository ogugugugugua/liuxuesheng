package scut.yulin.trip.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * room
 *
 * @author
 */
@ApiModel(value = "scut.yulin.trip.model.Room酒店房间")
@Data
@NoArgsConstructor
public class Room implements Serializable {

  /**
   * 非数据库字段 房间内设施列表
   */
  @ApiModelProperty(value = "equipmentList")
  private List<Equipment> equipmentList;

  /**
   * 非数据库字段 房间内床列表
   */
  @ApiModelProperty(value = "bedList")
  private List<Bed> bedList;

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
   * 房间类型
   */
  @ApiModelProperty(value = "房间类型")
  private String type;

  /**
   * 可入住人数
   */
  @ApiModelProperty(value = "可入住人数")
  private Integer numberPerson;

  /**
   * 默认价格
   */
  @ApiModelProperty(value = "默认价格")
  private BigDecimal defaultPrice;

  /**
   * 折扣价格
   */
  @ApiModelProperty(value = "折扣价格")
  private BigDecimal discountPrice;

  /**
   * 折扣价对应会员等级
   */
  @ApiModelProperty(value = "折扣价对应会员等级")
  private String vipGrade;

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

  public Room(String uuid, String type, String vipGrade, Integer numberPerson,
      BigDecimal defaultPrice, BigDecimal discountPrice) {
    this.uuid = uuid;
    this.type = type;
    this.vipGrade = vipGrade;
    this.numberPerson = numberPerson;
    this.defaultPrice = defaultPrice;
    this.discountPrice = discountPrice;
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
    Room other = (Room) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getUuid() == null ? other.getUuid() == null
        : this.getUuid().equals(other.getUuid()))
        && (this.getType() == null ? other.getType() == null
        : this.getType().equals(other.getType()))
        && (this.getNumberPerson() == null ? other.getNumberPerson() == null
        : this.getNumberPerson().equals(other.getNumberPerson()))
        && (this.getDefaultPrice() == null ? other.getDefaultPrice() == null
        : this.getDefaultPrice().equals(other.getDefaultPrice()))
        && (this.getDiscountPrice() == null ? other.getDiscountPrice() == null
        : this.getDiscountPrice().equals(other.getDiscountPrice()))
        && (this.getVipGrade() == null ? other.getVipGrade() == null
        : this.getVipGrade().equals(other.getVipGrade()))
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
    result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
    result = prime * result + ((getNumberPerson() == null) ? 0 : getNumberPerson().hashCode());
    result = prime * result + ((getDefaultPrice() == null) ? 0 : getDefaultPrice().hashCode());
    result = prime * result + ((getDiscountPrice() == null) ? 0 : getDiscountPrice().hashCode());
    result = prime * result + ((getVipGrade() == null) ? 0 : getVipGrade().hashCode());
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
    sb.append(", type=").append(type);
    sb.append(", numberPerson=").append(numberPerson);
    sb.append(", defaultPrice=").append(defaultPrice);
    sb.append(", discountPrice=").append(discountPrice);
    sb.append(", vipGrade=").append(vipGrade);
    sb.append(", createdTime=").append(createdTime);
    sb.append(", updatedTime=").append(updatedTime);
    sb.append(", deleted=").append(deleted);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}