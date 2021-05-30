package scut.yulin.admin.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import scut.yulin.mbg.model.Resource;

/**
 * @Date 2021/5/29
 * @Author xieyulin
 * @Description 用于囊括留学生和旅客的鉴权行为
 **/
public interface AdminService {

  /**
   * 获取用户信息
   */
  UserDetails loadUserByUsername(String username);

  List<Resource> getResourceList(String hrUuid);
}
