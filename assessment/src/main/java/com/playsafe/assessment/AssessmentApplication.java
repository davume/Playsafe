package com.playsafe.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@SpringBootApplication
public class AssessmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssessmentApplication.class, args);
    }

    @Component
    public class LogTimeFilter implements Filter {

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            long startTime = System.currentTimeMillis();
            chain.doFilter(request, response);
            long duration = System.currentTimeMillis() - startTime;
            String url = ((HttpServletRequest)request).getRequestURL().toString();
            System.out.println("Endpoint: "+ url + " >>>" + duration + " ms");
        }
    }
}
