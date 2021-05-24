package scut.yulin.admin.dto.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021/5/24
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertRoleDTO {
  /**
   * 角色类型 ROLE_super,admin,traveler,student,test
   * 必填
   */
  private String name;

  /**
   * 角色类型中文名 超级管理员,管理员,运营,留学生,游客
   * 必填
   */
  private String namezh;

  /**
   * 角色描述
   * 必填
   */
  private String description;

  /**
   * 用户数量
   */
  private Integer count;

  /**
   * 排序
   */
  private Integer sort;

  /**
   * 启用状态，0->禁用；1->启用
   */
  private String status;
}
