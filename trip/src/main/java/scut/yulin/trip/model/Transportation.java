package scut.yulin.trip.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.NoArgsConstructor;
import scut.yulin.trip.dto.transportationType.QueryTransportationTypeDTO;
import scut.yulin.trip.service.TransportationTypeService;
import scut.yulin.trip.service.impl.TransportationTypeServiceImpl;

/**
 * transportation
 *
 * @author
 */
@ApiModel(value = "scut.yulin.trip.model.Transportation可用交通方式 ")
@NoArgsConstructor
//@Component
public class Transportation implements Serializable {

//  @Autowired
  TransportationTypeService transportationTypeService = new TransportationTypeServiceImpl();
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
   * 关联行程uuid
   */
  @ApiModelProperty(value = "关联行程uuid")
  private String scheduleUuid;

  /**
   * 关联行程类型uuid
   */
  @ApiModelProperty(value = "关联行程类型uuid")
  private String scheduleTypeUuid;

  /**
   * 交通工具类型uuid
   */
  @ApiModelProperty(value = "交通工具类型uuid")
  private String transportationTypeUuid;

  /**
   * 默认价格
   */
  @ApiModelProperty(value = "默认价格")
  private BigDecimal defaultPrice;

  /**
   * 交通工具编号
   */
  @ApiModelProperty(value = "交通工具编号")
  private String vehicleNumber;

  /**
   * 乘坐地点
   */
  @ApiModelProperty(value = "乘坐地点")
  private String boardingLocation;

  /**
   * 创建人uuid
   */
  @ApiModelProperty(value = "创建人uuid")
  private String creatorUuid;

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
   * 已删除 已删除为1,未删除为0
   */
  @ApiModelProperty(value = "已删除 已删除为1,未删除为0")
  private String deleted;

  private static final long serialVersionUID = 1L;

  public Transportation(String uuid, String scheduleUuid, String scheduleTypeUuid,
      String transportationTypeUuid, String vehicleNumber, String boardingLocation,
      String creatorUuid, BigDecimal defaultPrice) {
    this.uuid = uuid;
    this.scheduleTypeUuid = scheduleTypeUuid;
    this.scheduleUuid = scheduleUuid;
    this.transportationTypeUuid = transportationTypeUuid;
    this.vehicleNumber = vehicleNumber;
    this.boardingLocation = boardingLocation;
    this.defaultPrice = defaultPrice;
    this.creatorUuid = creatorUuid;
  }

  public TransportationType retrieveTransportationType(){
    QueryTransportationTypeDTO queryTransportationTypeDTO = new QueryTransportationTypeDTO(
        this.getTransportationTypeUuid());
    System.out.println("queryTransportationTypeDTO===>"+queryTransportationTypeDTO);
    return transportationTypeService.getTransportationTypeByUUID(queryTransportationTypeDTO);
  }

  public Long getId() {
    return id;
  }

  public String getUuid() {
    return uuid;
  }

  public String getScheduleUuid() {
    return scheduleUuid;
  }

  public String getScheduleTypeUuid() {
    return scheduleTypeUuid;
  }

  public String getTransportationTypeUuid() {
    return transportationTypeUuid;
  }

  public BigDecimal getDefaultPrice() {
    return defaultPrice;
  }

  public String getVehicleNumber() {
    return vehicleNumber;
  }

  public String getBoardingLocation() {
    return boardingLocation;
  }

  public String getCreatorUuid() {
    return creatorUuid;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public String getDeleted() {
    return deleted;
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public void setScheduleUuid(String scheduleUuid) {
    this.scheduleUuid = scheduleUuid;
  }

  public void setScheduleTypeUuid(String scheduleTypeUuid) {
    this.scheduleTypeUuid = scheduleTypeUuid;
  }

  public void setTransportationTypeUuid(String transportationTypeUuid) {
    this.transportationTypeUuid = transportationTypeUuid;
  }

  public void setDefaultPrice(BigDecimal defaultPrice) {
    this.defaultPrice = defaultPrice;
  }

  public void setVehicleNumber(String vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
  }

  public void setBoardingLocation(String boardingLocation) {
    this.boardingLocation = boardingLocation;
  }

  public void setCreatorUuid(String creatorUuid) {
    this.creatorUuid = creatorUuid;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public void setDeleted(String deleted) {
    this.deleted = deleted;
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
    Transportation other = (Transportation) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getUuid() == null ? other.getUuid() == null
        : this.getUuid().equals(other.getUuid()))
        && (this.getScheduleUuid() == null ? other.getScheduleUuid() == null
        : this.getScheduleUuid().equals(other.getScheduleUuid()))
        && (this.getScheduleTypeUuid() == null ? other.getScheduleTypeUuid() == null
        : this.getScheduleTypeUuid().equals(other.getScheduleTypeUuid()))
        && (this.getTransportationTypeUuid() == null ? other.getTransportationTypeUuid() == null
        : this.getTransportationTypeUuid().equals(other.getTransportationTypeUuid()))
        && (this.getDefaultPrice() == null ? other.getDefaultPrice() == null
        : this.getDefaultPrice().equals(other.getDefaultPrice()))
        && (this.getVehicleNumber() == null ? other.getVehicleNumber() == null
        : this.getVehicleNumber().equals(other.getVehicleNumber()))
        && (this.getBoardingLocation() == null ? other.getBoardingLocation() == null
        : this.getBoardingLocation().equals(other.getBoardingLocation()))
        && (this.getCreatorUuid() == null ? other.getCreatorUuid() == null
        : this.getCreatorUuid().equals(other.getCreatorUuid()))
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
    result = prime * result + ((getScheduleUuid() == null) ? 0 : getScheduleUuid().hashCode());
    result =
        prime * result + ((getScheduleTypeUuid() == null) ? 0 : getScheduleTypeUuid().hashCode());
    result = prime * result + ((getTransportationTypeUuid() == null) ? 0
        : getTransportationTypeUuid().hashCode());
    result = prime * result + ((getDefaultPrice() == null) ? 0 : getDefaultPrice().hashCode());
    result = prime * result + ((getVehicleNumber() == null) ? 0 : getVehicleNumber().hashCode());
    result =
        prime * result + ((getBoardingLocation() == null) ? 0 : getBoardingLocation().hashCode());
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
    sb.append(", transportationTypeUuid=").append(transportationTypeUuid);
    sb.append(", defaultPrice=").append(defaultPrice);
    sb.append(", vehicleNumber=").append(vehicleNumber);
    sb.append(", boardingLocation=").append(boardingLocation);
    sb.append(", creatorUuid=").append(creatorUuid);
    sb.append(", createdTime=").append(createdTime);
    sb.append(", updatedTime=").append(updatedTime);
    sb.append(", deleted=").append(deleted);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}