package scut.yulin.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * resource
 *
 * @author
 */
@ApiModel(value = "scut.yulin.admin.model.Resource后台资源表,用于控制后台用户可以访问的接口，使用了Ant路径的匹配规则，可以使用通配符定义一系列接口的权限")
@Data
public class Resource implements Serializable {

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
   * 资源分类ID
   */
  @ApiModelProperty(value = "资源分类ID")
  private String categoryUuid;

  /**
   * URL
   */
  @ApiModelProperty(value = "URL")
  private String url;

  /**
   * 资源名字
   */
  @ApiModelProperty(value = "资源名字")
  private String name;

  /**
   * 资源描述
   */
  @ApiModelProperty(value = "资源描述")
  private String description;

  /**
   * 路径
   */
  @ApiModelProperty(value = "路径")
  private String path;

  /**
   * 组件
   */
  @ApiModelProperty(value = "组件")
  private String component;

  /**
   * 图标
   */
  @ApiModelProperty(value = "图标")
  private String iconcls;

  /**
   * 保活
   */
  @ApiModelProperty(value = "保活")
  private String keepalive;

  /**
   * 需要认证
   */
  @ApiModelProperty(value = "需要认证")
  private String requireauth;

  /**
   * 父id
   */
  @ApiModelProperty(value = "父id")
  private String parentid;

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

  public Resource(String uuid, String categoryUuid, String url, String name,
      String description, String path, String component, String iconcls, String keepalive,
      String requireauth, String parentid) {
    this.uuid = uuid;
    this.categoryUuid = categoryUuid;
    this.url = url;
    this.name = name;
    this.description = description;
    this.path = path;
    this.component = component;
    this.iconcls = iconcls;
    this.keepalive = keepalive;
    this.requireauth = requireauth;
    this.parentid = parentid;
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
    Resource other = (Resource) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getUuid() == null ? other.getUuid() == null
        : this.getUuid().equals(other.getUuid()))
        && (this.getCategoryUuid() == null ? other.getCategoryUuid() == null
        : this.getCategoryUuid().equals(other.getCategoryUuid()))
        && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
        && (this.getName() == null ? other.getName() == null
        : this.getName().equals(other.getName()))
        && (this.getDescription() == null ? other.getDescription() == null
        : this.getDescription().equals(other.getDescription()))
        && (this.getPath() == null ? other.getPath() == null
        : this.getPath().equals(other.getPath()))
        && (this.getComponent() == null ? other.getComponent() == null
        : this.getComponent().equals(other.getComponent()))
        && (this.getIconcls() == null ? other.getIconcls() == null
        : this.getIconcls().equals(other.getIconcls()))
        && (this.getKeepalive() == null ? other.getKeepalive() == null
        : this.getKeepalive().equals(other.getKeepalive()))
        && (this.getRequireauth() == null ? other.getRequireauth() == null
        : this.getRequireauth().equals(other.getRequireauth()))
        && (this.getParentid() == null ? other.getParentid() == null
        : this.getParentid().equals(other.getParentid()))
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
    result = prime * result + ((getCategoryUuid() == null) ? 0 : getCategoryUuid().hashCode());
    result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
    result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
    result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
    result = prime * result + ((getPath() == null) ? 0 : getPath().hashCode());
    result = prime * result + ((getComponent() == null) ? 0 : getComponent().hashCode());
    result = prime * result + ((getIconcls() == null) ? 0 : getIconcls().hashCode());
    result = prime * result + ((getKeepalive() == null) ? 0 : getKeepalive().hashCode());
    result = prime * result + ((getRequireauth() == null) ? 0 : getRequireauth().hashCode());
    result = prime * result + ((getParentid() == null) ? 0 : getParentid().hashCode());
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
    sb.append(", categoryUuid=").append(categoryUuid);
    sb.append(", url=").append(url);
    sb.append(", name=").append(name);
    sb.append(", description=").append(description);
    sb.append(", path=").append(path);
    sb.append(", component=").append(component);
    sb.append(", iconcls=").append(iconcls);
    sb.append(", keepalive=").append(keepalive);
    sb.append(", requireauth=").append(requireauth);
    sb.append(", parentid=").append(parentid);
    sb.append(", createdTime=").append(createdTime);
    sb.append(", updatedTime=").append(updatedTime);
    sb.append(", deleted=").append(deleted);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}