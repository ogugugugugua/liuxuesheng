package scut.yulin.trip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import scut.yulin.common.config.WebMvcConfig;

@SpringBootApplication(scanBasePackages = {"scut.yulin.common","scut.yulin.trip"})
public class TripApplication {

    public static void main(String[] args) {
        SpringApplication.run(TripApplication.class, args);
    }

    @Bean
    public WebMvcConfig getConfig() {
        return new WebMvcConfig();
    }
}
