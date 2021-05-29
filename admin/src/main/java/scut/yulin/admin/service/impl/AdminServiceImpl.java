package scut.yulin.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import scut.yulin.admin.dto.traveler.QueryTravelerDTO;
import scut.yulin.admin.model.CustomStudentUserDetails;
import scut.yulin.admin.model.CustomTravelerUserDetails;
import scut.yulin.admin.model.Resource;
import scut.yulin.admin.model.Student;
import scut.yulin.admin.model.Traveler;
import scut.yulin.admin.service.AdminService;
import scut.yulin.admin.service.StudentAdminService;
import scut.yulin.admin.service.TravelerAdminService;

/**
 * @Date 2021/5/29
 * @Author xieyulin
 * @Description 用于囊括留学生和旅客的鉴权行为
 **/
@Service
public class AdminServiceImpl implements AdminService {

  @Autowired
  StudentAdminService studentAdminService;

  @Autowired
  TravelerAdminService travelerAdminService;

  @Override
  public UserDetails loadUserByUsername(String username) {
    // 尝试获取该用户名的留学生
    Student student = studentAdminService.getStudentByAccountName(username);
    if (student != null) {
      List<Resource> resourceList = studentAdminService.getResourceList(student.getUuid());
      return new CustomStudentUserDetails(student, resourceList);
    }

    // 尝试获取该用户名的旅客
    Traveler traveler = travelerAdminService
        .getTravelerByName(new QueryTravelerDTO(null, username));
    if (traveler != null) {
      List<Resource> resourceList = travelerAdminService.getResourceList(traveler.getUuid());
      return new CustomTravelerUserDetails(traveler, resourceList);
    }

    throw new UsernameNotFoundException("用户名或密码错误");
  }

  @Override
  public List<Resource> getResourceList(String hrUuid) {
    List<Resource> list = null;
    list = studentAdminService.getResourceList(hrUuid);
    if (list != null) {
      return list;
    }
    return travelerAdminService.getResourceList(hrUuid);
  }
}
