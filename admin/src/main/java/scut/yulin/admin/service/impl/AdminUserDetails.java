package scut.yulin.admin.service.impl;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import scut.yulin.admin.model.Student;

/**
 * SpringSecurity需要的用户详情
 * @author xieyulin
 * @date 2021/05/19
 */
public class AdminUserDetails implements UserDetails {
    private Student student;

    public AdminUserDetails(Student student) {
        this.student = student;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //返回当前用户的权限
        return Arrays.asList(new SimpleGrantedAuthority("TEST"));
    }

    @Override
    public String getPassword() {
        return student.getPwd();
    }

    @Override
    public String getUsername() {
        return student.getAccountName();
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