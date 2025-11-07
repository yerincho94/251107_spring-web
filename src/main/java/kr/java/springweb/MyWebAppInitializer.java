package kr.java.springweb;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import kr.java.springweb.config.AppConfig;
import kr.java.springweb.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// 실행 구동부
public class MyWebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Context를 만드는 작업 -> Context를 Tomcat에 연결하는 작업
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(AppConfig.class); // config 넣어야함.
        context.register(WebConfig.class); // config 넣어야함.

        // DispatcherServlet등록 <- Spring에서는 DispatcherServlet을 중앙에 위치시킨 다음에 Spring에 등록된 여러 페이지를 알아서 배치
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context); // context를 연결시켜줘야함.
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
