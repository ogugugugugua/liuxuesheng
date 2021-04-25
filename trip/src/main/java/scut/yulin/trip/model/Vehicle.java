package scut.yulin.trip.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.NoArgsConstructor;
import scut.yulin.common.constant.CommonConstant;

/**
 * vehicle
 *
 * @author
 */
@ApiModel(value = "scut.yulin.trip.model.Vehicle交通 ")
//@Data
//@Getter
@NoArgsConstructor
public class Vehicle extends Schedule implements Serializable {

  /**
   * 非数据库字段 交通工具类型
   */
  @ApiModelProperty(value = "非数据库字段，交通工具类型")
  private TransportationType transportationType;

  /**
   * 非数据库字段 价钱列表
   */
  @ApiModelProperty(value = "非数据库字段，价钱列表")
  private List<Price> priceList;

  /**
   * 非数据库字段 图片列表
   */
  @ApiModelProperty(value = "非数据库字段，图片列表")
  private List<Image> imageList;


  /**
   * 非数据库字段 评论列表
   */
  @ApiModelProperty(value = "非数据库字段，评论列表")
  private List<Comment> commentList;

  /**
   * 非数据库字段 耗时，字符串表达
   */
  @ApiModelProperty(value = "非数据库字段，耗时")
  private String durationInString;

  /**
   * id
   */
  @ApiModelProperty(value = "id")
  private Long id;

  /**
   * 行程/交通uuid
   */
  @ApiModelProperty(value = "行程/交通uuid")
  private String uuid;

  /**
   * 行程类型uuid
   */
  @ApiModelProperty(value = "行程类型uuid")
  private String scheduleTypeUuid;

  /**
   * 交通工具类型uuid
   */
  @ApiModelProperty(value = "交通工具类型uuid")
  private String transportationTypeUuid;

  /**
   * 外文名称
   */
  @ApiModelProperty(value = "外文名称")
  private String localName;

  /**
   * 中文名称
   */
  @ApiModelProperty(value = "中文名称")
  private String cnName;

  /**
   * 交通工具编号
   */
  @ApiModelProperty(value = "交通工具编号")
  private String vehicleSerial;

  /**
   * 出发时间
   */
  @ApiModelProperty(value = "出发时间")
  private Date departureTime;

  /**
   * 交通耗时
   */
  @ApiModelProperty(value = "交通耗时")
  private Date duration;

  /**
   * 到达时间
   */
  @ApiModelProperty(value = "到达时间")
  private Date arrivalTime;

  /**
   * 出发地点
   */
  @ApiModelProperty(value = "出发地点")
  private String departureLocation;

  /**
   * 到达地点
   */
  @ApiModelProperty(value = "到达地点")
  private String arrivalLocation;

  /**
   * 舱位等级
   */
  @ApiModelProperty(value = "舱位等级")
  private String grade;

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

  public TransportationType getTransportationType() {
    return transportationType;
  }

  public List<Price> getPriceList() {
    return priceList;
  }

  public List<Image> getImageList() {
    return imageList;
  }

  public List<Comment> getCommentList() {
    return commentList;
  }

  public Long getId() {
    return id;
  }

  public String getUuid() {
    return uuid;
  }

  public String getScheduleTypeUuid() {
    return scheduleTypeUuid;
  }

  public String getTransportationTypeUuid() {
    return transportationTypeUuid;
  }

  public String getLocalName() {
    return localName;
  }

  public String getCnName() {
    return cnName;
  }

  public String getVehicleSerial() {
    return vehicleSerial;
  }

  public Date getDepartureTime() {
    return departureTime;
  }

  public Date getDuration() {
    return duration;
  }

  public Date getArrivalTime() {
    return arrivalTime;
  }

  public String getDepartureLocation() {
    return departureLocation;
  }

  public String getArrivalLocation() {
    return arrivalLocation;
  }

  public String getGrade() {
    return grade;
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

  public void setTransportationType(TransportationType transportationType) {
    this.transportationType = transportationType;
  }

  public void setPriceList(List<Price> priceList) {
    this.priceList = priceList;
  }

  public void setImageList(List<Image> imageList) {
    this.imageList = imageList;
  }

  public void setCommentList(List<Comment> commentList) {
    this.commentList = commentList;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public void setScheduleTypeUuid(String scheduleTypeUuid) {
    this.scheduleTypeUuid = scheduleTypeUuid;
  }

  public void setTransportationTypeUuid(String transportationTypeUuid) {
    this.transportationTypeUuid = transportationTypeUuid;
  }

  public void setLocalName(String localName) {
    this.localName = localName;
  }

  public void setCnName(String cnName) {
    this.cnName = cnName;
  }

  public void setVehicleSerial(String vehicleSerial) {
    this.vehicleSerial = vehicleSerial;
  }

  public void setDepartureTime(Date departureTime) {
    this.departureTime = departureTime;
  }

  public void setDuration(Date duration) {
    this.duration = duration;
  }

  public void setArrivalTime(Date arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public void setDepartureLocation(String departureLocation) {
    this.departureLocation = departureLocation;
  }

  public void setArrivalLocation(String arrivalLocation) {
    this.arrivalLocation = arrivalLocation;
  }

  public void setGrade(String grade) {
    this.grade = grade;
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

  public Vehicle(String uuid, String transportationTypeUuid,
      String localName, String cnName, String vehicleSerial,
      Date departureTime, Date duration, Date arrivalTime,
      String departureLocation, String arrivalLocation, String grade) {
    this.uuid = uuid;
    this.transportationTypeUuid = transportationTypeUuid;
    this.localName = localName;
    this.cnName = cnName;
    this.vehicleSerial = vehicleSerial;
    this.departureTime = departureTime;
    this.duration = duration;
    this.arrivalTime = arrivalTime;
    this.departureLocation = departureLocation;
    this.arrivalLocation = arrivalLocation;
    this.grade = grade;
    this.scheduleTypeUuid = CommonConstant.SCHEDULE_TYPE_VEHICLE;
  }

  public String getDurationInString() {
    try {
      long diff = this.getArrivalTime().getTime() - this.getDepartureTime().getTime();
      long day = diff / (1000 * 60 * 60 * 24);
      long hour = (diff - day * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
      long min = (diff - day * (1000 * 60 * 60 * 24) - hour * (1000 * 60 * 60)) / (1000 * 60);
      return day + " days, " + hour + " hours, " + min + " mins";
    } catch (Exception e) {
      return e.getCause() + e.getMessage();
    }
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
    Vehicle other = (Vehicle) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getUuid() == null ? other.getUuid() == null
        : this.getUuid().equals(other.getUuid()))
        && (this.getScheduleTypeUuid() == null ? other.getScheduleTypeUuid() == null
        : this.getScheduleTypeUuid().equals(other.getScheduleTypeUuid()))
        && (this.getTransportationTypeUuid() == null ? other.getTransportationTypeUuid() == null
        : this.getTransportationTypeUuid().equals(other.getTransportationTypeUuid()))
        && (this.getLocalName() == null ? other.getLocalName() == null
        : this.getLocalName().equals(other.getLocalName()))
        && (this.getCnName() == null ? other.getCnName() == null
        : this.getCnName().equals(other.getCnName()))
        && (this.getVehicleSerial() == null ? other.getVehicleSerial() == null
        : this.getVehicleSerial().equals(other.getVehicleSerial()))
        && (this.getDepartureTime() == null ? other.getDepartureTime() == null
        : this.getDepartureTime().equals(other.getDepartureTime()))
        && (this.getDuration() == null ? other.getDuration() == null
        : this.getDuration().equals(other.getDuration()))
        && (this.getArrivalTime() == null ? other.getArrivalTime() == null
        : this.getArrivalTime().equals(other.getArrivalTime()))
        && (this.getDepartureLocation() == null ? other.getDepartureLocation() == null
        : this.getDepartureLocation().equals(other.getDepartureLocation()))
        && (this.getArrivalLocation() == null ? other.getArrivalLocation() == null
        : this.getArrivalLocation().equals(other.getArrivalLocation()))
        && (this.getGrade() == null ? other.getGrade() == null
        : this.getGrade().equals(other.getGrade()))
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
    result =
        prime * result + ((getScheduleTypeUuid() == null) ? 0 : getScheduleTypeUuid().hashCode());
    result = prime * result + ((getTransportationTypeUuid() == null) ? 0
        : getTransportationTypeUuid().hashCode());
    result = prime * result + ((getLocalName() == null) ? 0 : getLocalName().hashCode());
    result = prime * result + ((getCnName() == null) ? 0 : getCnName().hashCode());
    result = prime * result + ((getVehicleSerial() == null) ? 0 : getVehicleSerial().hashCode());
    result = prime * result + ((getDepartureTime() == null) ? 0 : getDepartureTime().hashCode());
    result = prime * result + ((getDuration() == null) ? 0 : getDuration().hashCode());
    result = prime * result + ((getArrivalTime() == null) ? 0 : getArrivalTime().hashCode());
    result =
        prime * result + ((getDepartureLocation() == null) ? 0 : getDepartureLocation().hashCode());
    result =
        prime * result + ((getArrivalLocation() == null) ? 0 : getArrivalLocation().hashCode());
    result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
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
    sb.append(", scheduleTypeUuid=").append(scheduleTypeUuid);
    sb.append(", transportationTypeUuid=").append(transportationTypeUuid);
    sb.append(", localName=").append(localName);
    sb.append(", cnName=").append(cnName);
    sb.append(", vehicleSerial=").append(vehicleSerial);
    sb.append(", departureTime=").append(departureTime);
    sb.append(", duration=").append(duration);
    sb.append(", arrivalTime=").append(arrivalTime);
    sb.append(", departureLocation=").append(departureLocation);
    sb.append(", arrivalLocation=").append(arrivalLocation);
    sb.append(", grade=").append(grade);
    sb.append(", createdTime=").append(createdTime);
    sb.append(", updatedTime=").append(updatedTime);
    sb.append(", deleted=").append(deleted);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }

  @Override
  public String getScheduleType() {
    return this.getScheduleTypeUuid();
  }

  @Override
  public String getSchedule() {
    return this.getUuid();
  }
}