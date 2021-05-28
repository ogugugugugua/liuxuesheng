package scut.yulin.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * traveler
 *
 * @author
 */
@ApiModel(value = "scut.yulin.admin.model.Traveler旅客 ")
@Data
public class Traveler implements Serializable {

  /**
   * 旅客id
   */
  @ApiModelProperty(value = "旅客id")
  private Long id;

  /**
   * uuid
   */
  @ApiModelProperty(value = "uuid")
  private String uuid;

  /**
   * 账户名
   */
  @ApiModelProperty(value = "账户名")
  private String accountName;

  /**
   * 密码
   */
  @ApiModelProperty(value = "密码")
  private String pwd;

  /**
   * 性别 男为1,女为0
   */
  @ApiModelProperty(value = "性别 男为1,女为0")
  private String gender;

  /**
   * 真实姓名
   */
  @ApiModelProperty(value = "真实姓名")
  private String realName;

  /**
   * 所在国家
   */
  @ApiModelProperty(value = "所在国家")
  private String country;

  /**
   * 所在城市
   */
  @ApiModelProperty(value = "所在城市")
  private String city;

  /**
   * 电话前缀
   */
  @ApiModelProperty(value = "电话前缀")
  private String phoneCode;

  /**
   * 所在地电话
   */
  @ApiModelProperty(value = "所在地电话")
  private String localPhone;

  /**
   * 国内电话
   */
  @ApiModelProperty(value = "国内电话")
  private String cnPhone;

  /**
   * 邮箱
   */
  @ApiModelProperty(value = "邮箱")
  private String mail;

  /**
   * 邮箱已验证 已验证为1,未验证为0
   */
  @ApiModelProperty(value = "邮箱已验证 已验证为1,未验证为0")
  private String mailVerified;

  /**
   * 头像地址
   */
  @ApiModelProperty(value = "头像地址")
  private String avatarUrl;

  /**
   * 状态
   */
  @ApiModelProperty(value = "状态")
  private String status;

  /**
   * 用户层级 普通用户0,vip1,超级vip2
   */
  @ApiModelProperty(value = "用户层级 普通用户0,vip1,超级vip2")
  private String grade;

  /**
   * 上次登录时间
   */
  @ApiModelProperty(value = "上次登录时间")
  private Date lastLogin;

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
   * 已注销 已注销为1,未注销为0
   */
  @ApiModelProperty(value = "已注销 已注销为1,未注销为0")
  private String deleted;

  private static final long serialVersionUID = 1L;

  public Traveler() {
  }

  public Traveler(String uuid, String accountName, String pwd, String gender,
      String realName, String country, String city, String phoneCode, String localPhone,
      String cnPhone, String mail, String mailVerified, String avatarUrl, String status,
      String grade) {
    this.uuid = uuid;
    this.accountName = accountName;
    this.pwd = pwd;
    this.gender = gender;
    this.realName = realName;
    this.country = country;
    this.city = city;
    this.phoneCode = phoneCode;
    this.localPhone = localPhone;
    this.cnPhone = cnPhone;
    this.mail = mail;
    this.mailVerified = mailVerified;
    this.avatarUrl = avatarUrl;
    this.status = status;
    this.grade = grade;
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
    Traveler other = (Traveler) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getUuid() == null ? other.getUuid() == null
        : this.getUuid().equals(other.getUuid()))
        && (this.getAccountName() == null ? other.getAccountName() == null
        : this.getAccountName().equals(other.getAccountName()))
        && (this.getPwd() == null ? other.getPwd() == null : this.getPwd().equals(other.getPwd()))
        && (this.getGender() == null ? other.getGender() == null
        : this.getGender().equals(other.getGender()))
        && (this.getRealName() == null ? other.getRealName() == null
        : this.getRealName().equals(other.getRealName()))
        && (this.getCountry() == null ? other.getCountry() == null
        : this.getCountry().equals(other.getCountry()))
        && (this.getCity() == null ? other.getCity() == null
        : this.getCity().equals(other.getCity()))
        && (this.getPhoneCode() == null ? other.getPhoneCode() == null
        : this.getPhoneCode().equals(other.getPhoneCode()))
        && (this.getLocalPhone() == null ? other.getLocalPhone() == null
        : this.getLocalPhone().equals(other.getLocalPhone()))
        && (this.getCnPhone() == null ? other.getCnPhone() == null
        : this.getCnPhone().equals(other.getCnPhone()))
        && (this.getMail() == null ? other.getMail() == null
        : this.getMail().equals(other.getMail()))
        && (this.getMailVerified() == null ? other.getMailVerified() == null
        : this.getMailVerified().equals(other.getMailVerified()))
        && (this.getAvatarUrl() == null ? other.getAvatarUrl() == null
        : this.getAvatarUrl().equals(other.getAvatarUrl()))
        && (this.getStatus() == null ? other.getStatus() == null
        : this.getStatus().equals(other.getStatus()))
        && (this.getGrade() == null ? other.getGrade() == null
        : this.getGrade().equals(other.getGrade()))
        && (this.getLastLogin() == null ? other.getLastLogin() == null
        : this.getLastLogin().equals(other.getLastLogin()))
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
    result = prime * result + ((getAccountName() == null) ? 0 : getAccountName().hashCode());
    result = prime * result + ((getPwd() == null) ? 0 : getPwd().hashCode());
    result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
    result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
    result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
    result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
    result = prime * result + ((getPhoneCode() == null) ? 0 : getPhoneCode().hashCode());
    result = prime * result + ((getLocalPhone() == null) ? 0 : getLocalPhone().hashCode());
    result = prime * result + ((getCnPhone() == null) ? 0 : getCnPhone().hashCode());
    result = prime * result + ((getMail() == null) ? 0 : getMail().hashCode());
    result = prime * result + ((getMailVerified() == null) ? 0 : getMailVerified().hashCode());
    result = prime * result + ((getAvatarUrl() == null) ? 0 : getAvatarUrl().hashCode());
    result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
    result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
    result = prime * result + ((getLastLogin() == null) ? 0 : getLastLogin().hashCode());
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
    sb.append(", accountName=").append(accountName);
    sb.append(", pwd=").append(pwd);
    sb.append(", gender=").append(gender);
    sb.append(", realName=").append(realName);
    sb.append(", country=").append(country);
    sb.append(", city=").append(city);
    sb.append(", phoneCode=").append(phoneCode);
    sb.append(", localPhone=").append(localPhone);
    sb.append(", cnPhone=").append(cnPhone);
    sb.append(", mail=").append(mail);
    sb.append(", mailVerified=").append(mailVerified);
    sb.append(", avatarUrl=").append(avatarUrl);
    sb.append(", status=").append(status);
    sb.append(", grade=").append(grade);
    sb.append(", lastLogin=").append(lastLogin);
    sb.append(", createdTime=").append(createdTime);
    sb.append(", updatedTime=").append(updatedTime);
    sb.append(", deleted=").append(deleted);
    sb.append(", serialVersionUID=").append(serialVersionUID);
    sb.append("]");
    return sb.toString();
  }
}