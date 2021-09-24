package scut.yulin.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"scut.yulin.common","scut.yulin.trip","scut.yulin.es"})
public class EsApplication {

  public static void main(String[] args) {
    SpringApplication.run(EsApplication.class, args);
  }

}
