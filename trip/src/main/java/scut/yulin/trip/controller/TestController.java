package scut.yulin.trip.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.common.vo.ResponseVO;

/**
 * @Date 2021/6/20
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
public class TestController {

  @RequestMapping("auth-service/register")
  public ResponseVO test(){
    return ResponseVO.success("留学生注册成功");
  }

  @RequestMapping("auth-service/account/login")
  public ResponseVO test2(){
    return ResponseVO.success("");
  }

  @RequestMapping("/fastdfs-service/image")
  public ResponseVO test3(){
    return ResponseVO.success("http://192.168.91.128/group1/M00/00/00/wKhbgF5aMteAWy0gAAJkI7-2yGk361.png","上传图片成功");
  }


}
