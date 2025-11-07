package kr.java.springweb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "kr.java.springweb")
public class AppConfig {
    // bean을 추가
}
