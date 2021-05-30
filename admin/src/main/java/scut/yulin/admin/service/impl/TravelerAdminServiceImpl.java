package scut.yulin.admin.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import scut.yulin.admin.dto.hr_role.QueryHrRoleRelationDTO;
import scut.yulin.admin.dto.login.LoginDTO;
import scut.yulin.admin.dto.traveler.InsertTravelerDTO;
import scut.yulin.admin.dto.traveler.ModifyTravelerDTO;
import scut.yulin.admin.dto.traveler.QueryTravelerDTO;
import scut.yulin.admin.model.CustomTravelerUserDetails;
import scut.yulin.admin.service.HrRoleRelationService;
import scut.yulin.admin.service.TravelerAdminService;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.ReflectionCopy;
import scut.yulin.mbg.mbg.mapper.TravelerDao;
import scut.yulin.mbg.model.Resource;
import scut.yulin.mbg.model.Traveler;
import scut.yulin.mbg.model.TravelerExample;
import scut.yulin.security.util.JwtTokenUtil;

/**
 * @Date 2021/5/27
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class TravelerAdminServiceImpl implements TravelerAdminService {

  @Autowired
  private JwtTokenUtil jwtTokenUtil;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private TravelerDao dao;
  @Autowired
  private HrRoleRelationService hrRoleRelationService;

  /**
   * 增加新游客
   */
  @Override
  public int addNewTraveler(InsertTravelerDTO dto) {
    String accountName = dto.getAccountName();
    String pwd = dto.getPwd();
    Assert.notBlank(accountName, "accountName blank");
    Assert.notBlank(pwd, "password blank");
    pwd = passwordEncoder.encode(pwd);
    Traveler traveler = new Traveler(IdUtil.randomUUID(), accountName, pwd, dto.getGender(),
        dto.getRealName(),
        dto.getCountry(), dto.getCity(), dto.getPhoneCode(), dto.getLocalPhone(), dto.getCnPhone(),
        dto.getMail(), CommonConstant.ACCOUNT_MAIL_NOT_VERIFIED, dto.getAvatarUrl(),
        CommonConstant.ACCOUNT_STATUS_NOT_VERIFIED, CommonConstant.ACCOUNT_GRADE_NORMAL);
    dao.insertSelective(traveler);
    return 1;
  }

  /**
   * 获得所有的游客列表
   */
  @Override
  public List<Traveler> getTravelerList(QueryTravelerDTO dto) {
    TravelerExample example = new TravelerExample();
    example.setLimit(dto.getPageSize());
    example.setOffset(dto.getOffset());
    example.createCriteria().andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return dao.selectByExample(example);
  }

  /**
   * 根据uuid获取游客信息
   */
  @Override
  public Traveler getTravelerByUUID(QueryTravelerDTO dto) {
    String uuid = dto.getUuid();
    if (uuid == null) {
      return null;
    }
    TravelerExample example = new TravelerExample();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<Traveler> travelerList = dao.selectByExample(example);
    if (travelerList.size() == 0) {
      return null;
    }
    return travelerList.get(0);
  }

  /**
   * 根据账号名称获取游客信息
   */
  @Override
  public Traveler getTravelerByName(QueryTravelerDTO dto) {
    String accountName = dto.getAccountName();
    if (accountName == null) {
      return null;
    }
    TravelerExample example = new TravelerExample();
    example.createCriteria()
        .andAccountNameEqualTo(accountName)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<Traveler> travelerList = dao.selectByExample(example);
    if (travelerList.size() == 0) {
      return null;
    }
    return travelerList.get(0);
  }

  /**
   * 删除游客
   */
  @Override
  public int deleteTraveler(QueryTravelerDTO dto) {
    String uuid = dto.getUuid();
    if (uuid == null) {
      return 2;
    }
    Traveler traveler = getTravelerByUUID(dto);
    if (traveler == null) {
      return 2;
    }
    TravelerExample example = new TravelerExample();
    example.createCriteria()
        .andUuidEqualTo(uuid);
    traveler.setDeleted(CommonConstant.DELETED);
    dao.updateByExampleSelective(traveler, example);
    return 1;
  }

  /**
   * 修改游客信息
   */
  @Override
  public int modifyTraveler(ModifyTravelerDTO dto) {
    String uuid = dto.getUuid();
    if (uuid == null) {
      return 2;
    }
    Traveler traveler = getTravelerByUUID(dto);
    if (traveler == null) {
      return 2;
    }
    ReflectionCopy.stringSetterForUpdate(traveler, "pwd", dto.getPwd());
    ReflectionCopy.stringSetterForUpdate(traveler, "City", dto.getCity());
    ReflectionCopy.stringSetterForUpdate(traveler, "accountName", dto.getAccountName());
    ReflectionCopy.stringSetterForUpdate(traveler, "gender", dto.getGender());
    ReflectionCopy.stringSetterForUpdate(traveler, "realName", dto.getRealName());
    ReflectionCopy.stringSetterForUpdate(traveler, "country", dto.getCountry());
    ReflectionCopy.stringSetterForUpdate(traveler, "phoneCode", dto.getPhoneCode());
    ReflectionCopy.stringSetterForUpdate(traveler, "localPhone", dto.getLocalPhone());
    ReflectionCopy.stringSetterForUpdate(traveler, "localPhone", dto.getLocalPhone());
    ReflectionCopy.stringSetterForUpdate(traveler, "cnPhone", dto.getCnPhone());
    ReflectionCopy.stringSetterForUpdate(traveler, "mail", dto.getMail());
    ReflectionCopy.stringSetterForUpdate(traveler, "AvatarUrl", dto.getAvatarUrl());
    ReflectionCopy.setter(traveler, "updatedTime", new Date(), Date.class);

    TravelerExample example = new TravelerExample();
    example.createCriteria()
        .andUuidEqualTo(uuid);
    dao.updateByExampleSelective(traveler, example);
    return 1;
  }

  /**
   * 根据SpringSecurity令牌中的信息获取当前访问服务的旅客
   *
   * @return 当前旅客
   */
  @Override
  public Traveler getCurrentTraveler() {
    SecurityContext ctx = SecurityContextHolder.getContext();
    Authentication auth = ctx.getAuthentication();
    CustomTravelerUserDetails travelerDetails = (CustomTravelerUserDetails) auth.getPrincipal();
    return travelerDetails.getTraveler();
  }

  /**
   * 游客登录
   */
  @Override
  public String login(LoginDTO dto) {
    String token = null;
    //密码需要客户端加密后传递
    try {
      UserDetails userDetails = loadUserByUsername(dto.getUsername());
      if (!passwordEncoder.matches(dto.getPassword(), userDetails.getPassword())) {
        return "密码不正确";
      }
      if (!userDetails.isEnabled()) {
        return "帐号已被禁用";
      }
      UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
          userDetails, null, userDetails.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authentication);
      token = jwtTokenUtil.generateToken(userDetails);
    } catch (AuthenticationException e) {
      log.warn("登录异常:{}", e.getMessage());
    }
    return token;
  }

  /**
   * 根据账户名称获取符合SpringSecurity规范的游客用户信息
   */
  @Override
  public UserDetails loadUserByUsername(String username) {
    Traveler traveler = getTravelerByName(new QueryTravelerDTO(null, username));
    if (traveler != null) {
      List<Resource> resourceList = getResourceList(traveler.getUuid());
      return new CustomTravelerUserDetails(traveler, resourceList);
    }
    throw new UsernameNotFoundException("用户名或密码错误");

  }

  /**
   * 根据游客uuid获取其拥有的资源列表
   */
  @Override
  public List<Resource> getResourceList(String hrUuid) {
    return hrRoleRelationService
        .getResourceListByHrUUID(new QueryHrRoleRelationDTO(hrUuid, null));
  }
}
