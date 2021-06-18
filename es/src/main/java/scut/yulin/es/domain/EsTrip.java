package scut.yulin.es.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * trip
 *
 * @author
 */
@ApiModel(value = "scut.yulin.trip.model.Trip旅途 ")
@Data
@NoArgsConstructor
public class EsTrip implements Serializable {

  /**
   * 非数据库字段 当前旅途所有的日安排
   */
  @ApiModelProperty(value = "日安排列表")
  private List<EsResult_Trip_Routine_DTO> routineList;

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
   * 创建人uuid
   */
  @ApiModelProperty(value = "创建人uuid")
  private String creatorUuid;

  /**
   * 标题
   */
  @ApiModelProperty(value = "标题")
  private String title;

  /**
   * 简介
   */
  @ApiModelProperty(value = "简介")
  private String description;

  /**
   * 旅途分类
   */
  @ApiModelProperty(value = "旅途分类")
  private String classification;

  /**
   * 出发时间
   */
  @ApiModelProperty(value = "出发时间")
  private Date departTime;

  /**
   * 出行天数
   */
  @ApiModelProperty(value = "出行天数")
  private Integer duration;

  /**
   * 置顶 yes:1,no:0
   */
  @ApiModelProperty(value = "置顶 yes:1,no:0")
  private String rankTop;

  /**
   * 审核状态 passed:1,other:0
   */
  @ApiModelProperty(value = "审核状态 passed:1,other:0")
  private String status;

  /**
   * 是否私密行程 私密是1,公开是0
   */
  @ApiModelProperty(value = "是否私密行程 私密是1,公开是0")
  private String privateTrip;

  /**
   * 是否原创 原创是1,非原创是0
   */
  @ApiModelProperty(value = "是否原创 原创是1,非原创是0")
  private String original;

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

  public EsTrip(String uuid, String creatorUuid, String title, String description,
      String classification, Date departTime, Integer duration, String rankTop,
      String privateTrip, String original) {
    this.uuid = uuid;
    this.creatorUuid = creatorUuid;
    this.title = title;
    this.description = description;
    this.classification = classification;
    this.departTime = departTime;
    this.duration = duration;
    this.rankTop = rankTop;
    this.privateTrip = privateTrip;
    this.original = original;
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
    EsTrip other = (EsTrip) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getUuid() == null ? other.getUuid() == null
        : this.getUuid().equals(other.getUuid()))
        && (this.getCreatorUuid() == null ? other.getCreatorUuid() == null
        : this.getCreatorUuid().equals(other.getCreatorUuid()))
        && (this.getTitle() == null ? other.getTitle() == null
        : this.getTitle().equals(other.getTitle()))
        && (this.getDescription() == null ? other.getDescription() == null
        : this.getDescription().equals(other.getDescription()))
        && (this.getClassification() == null ? other.getClassification() == null
        : this.getClassification().equals(other.getClassification()))
        && (this.getDepartTime() == null ? other.getDepartTime() == null
        : this.getDepartTime().equals(other.getDepartTime()))
        && (this.getDuration() == null ? other.getDuration() == null
        : this.getDuration().equals(other.getDuration()))
        && (this.getRankTop() == null ? other.getRankTop() == null
        : this.getRankTop().equals(other.getRankTop()))
        && (this.getStatus() == null ? other.getStatus() == null
        : this.getStatus().equals(other.getStatus()))
        && (this.getPrivateTrip() == null ? other.getPrivateTrip() == null
        : this.getPrivateTrip().equals(other.getPrivateTrip()))
        && (this.getOriginal() == null ? other.getOriginal() == null
        : this.getOriginal().equals(other.getOriginal()))
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
    result = prime * result + ((getCreatorUuid() == null) ? 0 : getCreatorUuid().hashCode());
    result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
    result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
    result = prime * result + ((getClassification() == null) ? 0 : getClassification().hashCode());
    result = prime * result + ((getDepartTime() == null) ? 0 : getDepartTime().hashCode());
    result = prime * result + ((getDuration() == null) ? 0 : getDuration().hashCode());
    result = prime * result + ((getRankTop() == null) ? 0 : getRankTop().hashCode());
    result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
    result = prime * result + ((getPrivateTrip() == null) ? 0 : getPrivateTrip().hashCode());
    result = prime * result + ((getOriginal() == null) ? 0 : getOriginal().hashCode());
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
    sb.append(", creatorUuid=").append(creatorUuid);
    sb.append(", title=").append(title);
    sb.append(", description=").append(description);
    sb.append(", classification=").append(classification);
    sb.append(", departTime=").append(departTime);
    sb.append(", duration=").append(duration);
    sb.append(", rankTop=").append(rankTop);
    sb.append(", status=").append(status);
    sb.append(", privateTrip=").append(privateTrip);
    sb.append(", original=").append(original);
    sb.append(", createdTime=").append(createdTime);
    sb.append(", updatedTime=").append(updatedTime);
    sb.append(", deleted=").append(deleted);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}