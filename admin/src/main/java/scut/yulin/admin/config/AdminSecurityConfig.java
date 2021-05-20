package scut.yulin.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import scut.yulin.admin.service.StudentAdminService;
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

  @Bean
  public UserDetailsService userDetailsService() {
    //获取登录用户信息
    return username -> adminService.loadUserByUsername(username);
  }

}
