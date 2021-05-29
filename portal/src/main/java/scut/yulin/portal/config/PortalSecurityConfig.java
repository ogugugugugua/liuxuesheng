package scut.yulin.portal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import scut.yulin.admin.service.AdminService;
import scut.yulin.admin.service.ResourceService;

/**
 * @Date 2021/5/20
 * @Author xieyulin
 * @Description TODO
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class PortalSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AdminService adminService;

  @Autowired
  private ResourceService resourceService;

  @Bean
  public UserDetailsService studentUserDetailsService() {
    //获取登录用户信息
    return username -> adminService.loadUserByUsername(username);
  }


}
