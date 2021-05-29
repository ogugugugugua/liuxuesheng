package scut.yulin.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"scut.yulin.common", "scut.yulin.admin",
    "scut.yulin.security", "scut.yulin.portal"})
@MapperScan({"scut.yulin.common", "scut.yulin.admin",
    "scut.yulin.security", "scut.yulin.portal"})
public class PortalApplication {

  public static void main(String[] args) {
    SpringApplication.run(PortalApplication.class, args);
  }

}
