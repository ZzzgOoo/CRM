//package com.example.crm.filter;
//
//import com.example.crm.settings.domain.User;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class LoginFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request= (HttpServletRequest) servletRequest;
//        HttpServletResponse response= (HttpServletResponse) servletResponse;
//        String path = request.getServletPath();
//        System.out.println(path);
//        User user= (User) request.getSession().getAttribute("user");
//            if ("/login.html".equals(path)||"/login".equals(path)){
//                System.out.println("2222222");
//                filterChain.doFilter(request,response);
//            }else {
//                if (user!=null){
//                    System.out.println("33333");
//                    filterChain.doFilter(request,response);
//                }else {
//                    System.out.println("111");
//                    response.sendRedirect("/login.html");
//                }
//            }
//        filterChain.doFilter(request,response);
//    }
//}
