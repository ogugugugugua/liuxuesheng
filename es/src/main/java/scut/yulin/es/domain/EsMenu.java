package scut.yulin.es.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * menu
 *
 * @author
 */
@ApiModel(value = "scut.yulin.trip.model.Menu菜单")
@Data
@NoArgsConstructor
public class EsMenu implements Serializable {

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
   * 餐厅uuid
   */
  @ApiModelProperty(value = "餐厅uuid")
  private String restaurantUuid;

  /**
   * 菜名
   */
  @ApiModelProperty(value = "菜名")
  private String name;

  /**
   * 描述
   */
  @ApiModelProperty(value = "描述")
  private String description;

  /**
   * 价格
   */
  @ApiModelProperty(value = "价格")
  private BigDecimal price;

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

  public EsMenu(String uuid, String restaurantUuid, String name, String description,
      BigDecimal price) {
    this.uuid = uuid;
    this.restaurantUuid = restaurantUuid;
    this.name = name;
    this.description = description;
    this.price = price;
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
    EsMenu other = (EsMenu) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getUuid() == null ? other.getUuid() == null
        : this.getUuid().equals(other.getUuid()))
        && (this.getRestaurantUuid() == null ? other.getRestaurantUuid() == null
        : this.getRestaurantUuid().equals(other.getRestaurantUuid()))
        && (this.getName() == null ? other.getName() == null
        : this.getName().equals(other.getName()))
        && (this.getDescription() == null ? other.getDescription() == null
        : this.getDescription().equals(other.getDescription()))
        && (this.getPrice() == null ? other.getPrice() == null
        : this.getPrice().equals(other.getPrice()))
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
    result = prime * result + ((getRestaurantUuid() == null) ? 0 : getRestaurantUuid().hashCode());
    result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
    result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
    result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
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
    sb.append(", restaurantUuid=").append(restaurantUuid);
    sb.append(", name=").append(name);
    sb.append(", description=").append(description);
    sb.append(", price=").append(price);
    sb.append(", createdTime=").append(createdTime);
    sb.append(", updatedTime=").append(updatedTime);
    sb.append(", deleted=").append(deleted);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}