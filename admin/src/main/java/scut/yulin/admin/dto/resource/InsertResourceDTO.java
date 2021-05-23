package scut.yulin.admin.dto.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021/5/23
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor

public class InsertResourceDTO {
  /**
   * 资源分类ID
   */
  private String categoryUuid;

  /**
   * URL
   */
  private String url;

  /**
   * 资源名字
   */
  private String name;

  /**
   * 资源描述
   */
  private String description;

  /**
   * 路径
   */
  private String path;

  /**
   * 组件
   */
  private String component;

  /**
   * 图标
   */
  private String iconcls;

  /**
   * 保活
   */
  private String keepalive;

  /**
   * 需要认证
   */
  private String requireauth;

  /**
   * 父id
   */
  private String parentid;
}
