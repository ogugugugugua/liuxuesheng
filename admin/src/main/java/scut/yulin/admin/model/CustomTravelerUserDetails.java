package scut.yulin.admin.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import scut.yulin.common.utils.Inspections;
import scut.yulin.mbg.model.Resource;
import scut.yulin.mbg.model.Traveler;

/**
 * @Date 2021/5/28
 * @Author xieyulin
 * @Description SpringSecurity需要的用户详情 这个项目的标准用户类(旅客)，也就是能被SpringSecurity识别的用户类
 **/
public class CustomTravelerUserDetails implements UserDetails {

  // 旅客信息
  private final Traveler traveler;
  // 该旅客拥有的资源权限
  private final List<Resource> resourceList;

  public CustomTravelerUserDetails(Traveler traveler,
      List<Resource> resourceList) {
    this.traveler = traveler;
    this.resourceList = resourceList;
  }

  public Traveler getTraveler() {
    return traveler;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Inspections.isNotEmpty(resourceList) ? resourceList.stream()
        .map(role -> new SimpleGrantedAuthority(role.getUrl()))
        .collect(Collectors.toList()) : null;
  }

  @Override
  public String getPassword() {
    return traveler.getPwd();
  }

  @Override
  public String getUsername() {
    return traveler.getAccountName();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
