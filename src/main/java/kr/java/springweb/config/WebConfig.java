package kr.java.springweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "kr.java.springweb")
public class WebConfig implements WebMvcConfigurer {

    // view resolver (view를 가공해서 처리하는 객체)
    // Controller가 return하는 것이 view. (Spring Web MVC)
    // String -> View를 호출하기 위한 리소스 추가
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // webapp -> 기본 경로
        // /WEB-INF/views/(hello).jsp
        // /WEB-INF/views/(my/hello).jsp
        // 결과적으로 중앙에 있는 파일명과 경로들만 입력해도 jsp와 연결
        resolver.setPrefix("/WEB-INF/views/"); // Prefix : 접두사 : 머리 -> 맨 앞에 붙히는거
        resolver.setSuffix(".jsp"); // Suffix : 접미사 : 꼬리 -> 맨 뒤에 붙히는거
        return resolver; // Bean으로 등록
    }

}
