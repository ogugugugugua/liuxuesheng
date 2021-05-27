package scut.yulin.admin.dto.traveler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021/5/27
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor

public class InsertTravelerDTO {

  /**
   * 账户名
   */
  private String accountName;

  /**
   * 密码
   */
  private String pwd;

  /**
   * 性别 男为1,女为0
   */
  private String gender;

  /**
   * 真实姓名
   */
  private String realName;

  /**
   * 所在国家
   */
  private String country;

  /**
   * 所在城市
   */
  private String city;

  /**
   * 电话前缀
   */
  private String phoneCode;

  /**
   * 所在地电话
   */
  private String localPhone;

  /**
   * 国内电话
   */
  private String cnPhone;

  /**
   * 邮箱
   */
  private String mail;

  /**
   * 邮箱已验证 已验证为1,未验证为0
   */
  private String mailVerified;

  /**
   * 头像地址
   */
  private String avatarUrl;

  /**
   * 状态
   */
  private String status;

  /**
   * 用户层级 普通用户0,vip1,超级vip2
   */
  private String grade;
}
