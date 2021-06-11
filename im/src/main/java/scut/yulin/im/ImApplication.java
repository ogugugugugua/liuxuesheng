package scut.yulin.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"scut.yulin.im", "scut.yulin.trip"})
public class ImApplication {

  public static void main(String[] args) {
    SpringApplication.run(ImApplication.class, args);
  }

}
