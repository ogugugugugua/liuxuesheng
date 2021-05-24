package scut.yulin.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * role
 * @author 
 */
@ApiModel(value="scut.yulin.admin.model.Role角色 ")
@Data
public class Role implements Serializable {

    /**
     * 非数据库字段，该角色对应的资源列表
     */
    private List<Resource> resourceList;

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
     * 角色类型 ROLE_super,admin,traveler,student,test
     */
    @ApiModelProperty(value="角色类型 ROLE_super,admin,traveler,student,test")
    private String name;

    /**
     * 角色类型中文名 超级管理员,管理员,运营,留学生,游客
     */
    @ApiModelProperty(value="角色类型中文名 超级管理员,管理员,运营,留学生,游客")
    private String namezh;

    /**
     * 角色描述
     */
    @ApiModelProperty(value="角色描述")
    private String description;

    /**
     * 用户数量
     */
    @ApiModelProperty(value="用户数量")
    private Integer count;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
     * 启用状态，0->禁用；1->启用
     */
    @ApiModelProperty(value="启用状态，0->禁用；1->启用")
    private String status;

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

    public Role(String uuid, String name, String namezh, String description, Integer count,
        Integer sort, String status) {
        this.uuid = uuid;
        this.name = name;
        this.namezh = namezh;
        this.description = description;
        this.count = count;
        this.sort = sort;
        this.status = status;
    }

    private static final long serialVersionUID = 1L;

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
        Role other = (Role) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getNamezh() == null ? other.getNamezh() == null : this.getNamezh().equals(other.getNamezh()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
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
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNamezh() == null) ? 0 : getNamezh().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", name=").append(name);
        sb.append(", namezh=").append(namezh);
        sb.append(", description=").append(description);
        sb.append(", count=").append(count);
        sb.append(", sort=").append(sort);
        sb.append(", status=").append(status);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updatedTime=").append(updatedTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}