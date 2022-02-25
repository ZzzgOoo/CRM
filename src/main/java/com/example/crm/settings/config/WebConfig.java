package com.example.crm.settings.config;

import com.example.crm.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建拦截器对象
        HandlerInterceptor interceptor=new LoginInterceptor();
        //指定拦截的请求uri地址
        //addPathPatterns:该地址将会被拦截，无法访问
        String[] path ={"/*/*.*"};
        //指定不拦截的地址
        //excludePathPatterns:排除某个地址，不执行拦截，放行该地址
        String[] excludePath ={"/login.html","/login","/*/*.js","/*/*.css","/*/*.png","*.do"};
        //添加拦截器
        registry.addInterceptor(interceptor).addPathPatterns(path).excludePathPatterns(excludePath);
    }
}
