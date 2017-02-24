package com.liuhy.web.servlet;

import com.liuhy.web.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by liuhy on 2017/2/24.
 */
@WebServlet(name = "HelloServlet", urlPatterns = "/HelloServlet")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从application作用域（ServletContext）获得spring容器
        //方式1： 手动从作用域获取
        ApplicationContext applicationContext =
                (ApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        //方式2：通过工具获取
        ApplicationContext apppApplicationContext2 =
                WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.addUser();
    }
}
