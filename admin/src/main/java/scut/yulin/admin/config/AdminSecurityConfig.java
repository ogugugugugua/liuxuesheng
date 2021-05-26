package scut.yulin.admin.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import scut.yulin.admin.dto.resource.QueryResourceDTO;
import scut.yulin.admin.model.Resource;
import scut.yulin.admin.service.ResourceService;
import scut.yulin.admin.service.StudentAdminService;
import scut.yulin.security.component.DynamicSecurityService;
import scut.yulin.security.config.SecurityConfig;

/**
 * @Date 2021/5/20
 * @Author xieyulin
 * @Description TODO
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminSecurityConfig extends SecurityConfig {

  @Autowired
  private StudentAdminService adminService;

  @Autowired
  private ResourceService resourceService;

  @Bean
  public UserDetailsService userDetailsService() {
    //获取登录用户信息
    return username -> adminService.loadUserByUsername(username);
  }

  @Bean
  public DynamicSecurityService dynamicSecurityService() {
    return new DynamicSecurityService() {
      @Override
      public Map<String, ConfigAttribute> loadDataSource() {
        Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
        // 貌似是要拿到所有的resource
        List<Resource> resourceList = resourceService.getResourceList(new QueryResourceDTO(null));
        for (Resource resource : resourceList) {
//          map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(
//              resource.getUuid() + ":" + resource.getName()));
//          map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(
//              resource.getId() + ":" + resource.getUrl()));
          map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(
              resource.getUrl()));
        }
        return map;
      }
    };
  }
}
