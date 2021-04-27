package scut.yulin.trip.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import scut.yulin.common.constant.CommonConstant;

/**
 * hotel
 * @author 
 */
@ApiModel(value="scut.yulin.trip.model.Hotel住宿 ")
@Data
@NoArgsConstructor
public class Hotel extends Schedule implements Serializable {

    /**
     * 非数据库字段 房间列表
     */
    @ApiModelProperty(value = "roomList")
    private List<Room> roomList;

    /**
     * id
     */
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 行程/酒店uuid
     */
    @ApiModelProperty(value="行程/酒店uuid")
    private String uuid;

    /**
     * 行程类型uuid
     */
    @ApiModelProperty(value="行程类型uuid")
    private String scheduleTypeUuid;

    /**
     * 星级
     */
    @ApiModelProperty(value="星级")
    private Integer stars;

    /**
     * 外文名称
     */
    @ApiModelProperty(value="外文名称")
    private String localName;

    /**
     * 中文名称
     */
    @ApiModelProperty(value="中文名称")
    private String cnName;

    /**
     * 所在城市
     */
    @ApiModelProperty(value="所在城市")
    private String city;

    /**
     * 所在国家
     */
    @ApiModelProperty(value="所在国家")
    private String countryUuid;

    /**
     * 具体地址
     */
    @ApiModelProperty(value="具体地址")
    private String location;

    /**
     * 用户评分
     */
    @ApiModelProperty(value="用户评分")
    private BigDecimal rating;

    /**
     * 链接网址
     */
    @ApiModelProperty(value="链接网址")
    private String url;

    /**
     * 最早入住时间
     */
    @ApiModelProperty(value="最早入住时间")
    private String checkInTime;

    /**
     * 最晚离开时间
     */
    @ApiModelProperty(value="最晚离开时间")
    private String checkOutTime;

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

    public Hotel(String uuid, Integer stars, String localName, String cnName, String city,
        String countryUuid, String location, BigDecimal rating, String url, String checkInTime,
        String checkOutTime) {
        this.uuid = uuid;
        this.stars = stars;
        this.localName = localName;
        this.cnName = cnName;
        this.city = city;
        this.countryUuid = countryUuid;
        this.location = location;
        this.rating = rating;
        this.url = url;
        this.scheduleTypeUuid = CommonConstant.SCHEDULE_TYPE_HOTEL;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
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
        Hotel other = (Hotel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getScheduleTypeUuid() == null ? other.getScheduleTypeUuid() == null : this.getScheduleTypeUuid().equals(other.getScheduleTypeUuid()))
            && (this.getStars() == null ? other.getStars() == null : this.getStars().equals(other.getStars()))
            && (this.getLocalName() == null ? other.getLocalName() == null : this.getLocalName().equals(other.getLocalName()))
            && (this.getCnName() == null ? other.getCnName() == null : this.getCnName().equals(other.getCnName()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getCountryUuid() == null ? other.getCountryUuid() == null : this.getCountryUuid().equals(other.getCountryUuid()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getRating() == null ? other.getRating() == null : this.getRating().equals(other.getRating()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getCheckInTime() == null ? other.getCheckInTime() == null : this.getCheckInTime().equals(other.getCheckInTime()))
            && (this.getCheckOutTime() == null ? other.getCheckOutTime() == null : this.getCheckOutTime().equals(other.getCheckOutTime()))
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
        result = prime * result + ((getScheduleTypeUuid() == null) ? 0 : getScheduleTypeUuid().hashCode());
        result = prime * result + ((getStars() == null) ? 0 : getStars().hashCode());
        result = prime * result + ((getLocalName() == null) ? 0 : getLocalName().hashCode());
        result = prime * result + ((getCnName() == null) ? 0 : getCnName().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getCountryUuid() == null) ? 0 : getCountryUuid().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getRating() == null) ? 0 : getRating().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getCheckInTime() == null) ? 0 : getCheckInTime().hashCode());
        result = prime * result + ((getCheckOutTime() == null) ? 0 : getCheckOutTime().hashCode());
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
        sb.append(", stars=").append(stars);
        sb.append(", localName=").append(localName);
        sb.append(", cnName=").append(cnName);
        sb.append(", city=").append(city);
        sb.append(", countryUuid=").append(countryUuid);
        sb.append(", location=").append(location);
        sb.append(", rating=").append(rating);
        sb.append(", url=").append(url);
        sb.append(", checkInTime=").append(checkInTime);
        sb.append(", checkOutTime=").append(checkOutTime);
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
        return this.uuid;
    }
}