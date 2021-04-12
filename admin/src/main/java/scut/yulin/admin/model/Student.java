package scut.yulin.admin.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    @ApiModelProperty(value = "留学生id")
    private Long id;

    @ApiModelProperty(value = "账户名")
    private String accountName;

    @ApiModelProperty(value = "密码")
    private String pwd;

    @ApiModelProperty(value = "性别 男为1,女为0")
    private String gender;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "所在国家")
    private String country;

    @ApiModelProperty(value = "所在城市")
    private String city;

    @ApiModelProperty(value = "所在地电话")
    private String localPhone;

    @ApiModelProperty(value = "国内电话")
    private String cnPhone;

    @ApiModelProperty(value = "邮箱")
    private String mail;

    @ApiModelProperty(value = "身份证")
    private String idCardNumber;

    @ApiModelProperty(value = "护照")
    private String passportNumber;

    @ApiModelProperty(value = "头像地址")
    private String avatarUrl;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "用户层级 普通用户0,vip1,超级vip2")
    private String grade;

    @ApiModelProperty(value = "上次登录时间")
    private Date lastLogin;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "已注销 已注销为1,未注销为0")
    private String deleted;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalPhone() {
        return localPhone;
    }

    public void setLocalPhone(String localPhone) {
        this.localPhone = localPhone;
    }

    public String getCnPhone() {
        return cnPhone;
    }

    public void setCnPhone(String cnPhone) {
        this.cnPhone = cnPhone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountName=").append(accountName);
        sb.append(", pwd=").append(pwd);
        sb.append(", gender=").append(gender);
        sb.append(", realName=").append(realName);
        sb.append(", country=").append(country);
        sb.append(", city=").append(city);
        sb.append(", localPhone=").append(localPhone);
        sb.append(", cnPhone=").append(cnPhone);
        sb.append(", mail=").append(mail);
        sb.append(", idCardNumber=").append(idCardNumber);
        sb.append(", passportNumber=").append(passportNumber);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", status=").append(status);
        sb.append(", grade=").append(grade);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}