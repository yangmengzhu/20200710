package com.yang;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

public class reqServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       printInfo(req,resp);
    }

    private void printInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain; charset=utf-8");//最重要的响应头，告诉浏览器如何解读响应提的内容
        PrintWriter writer = resp.getWriter();
        String method = req.getMethod();
        writer.println("请求的方法是："+method);
        writer.println(req.getContextPath());//URL中context的路径
        writer.println(req.getProtocol());//请求协议版本
        Enumeration<String> headerNames = req.getHeaderNames();
        //获取所有的请求头
        while(headerNames.hasMoreElements()){
            String value=headerNames.nextElement();
            writer.println(value);
        }
        writer.println(req.getHeader("User-Agent") ); //请求头
        writer.println(req.getRequestURI());//URL中的完整路径
        writer.println(req.getParameter("key1"));//QueryString中name为key1的值
        Enumeration<String> parameterNames = req.getParameterNames();
        //获取所有的参数名称
        while(parameterNames.hasMoreElements()){
            String name=parameterNames.nextElement();
            writer.println(name);
        }
        //通过输入流来读取请求体中的内容
        InputStream inputStream = req.getInputStream();
    }
}
