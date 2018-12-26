package pers.geolo.LogisticsAssistant.servlet;

import pers.geolo.LogisticsAssistant.entity.User;
import pers.geolo.LogisticsAssistant.utils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) BeanUtils.getBean(request);
//        boolean result = UserService.getInstance().register(user);
        boolean result = true;
        if (result) { // 注册成功
            System.out.println(user.getUsername());
            // 登录信息存储至session
            request.getSession().setAttribute("user", user);
            // 跳转至registerSuccessful页面
            RequestDispatcher dispatcher = request.getRequestDispatcher("/registerSuccess.jsp");
            dispatcher.forward(request, response);
        } else {
            // 注册失败
            RequestDispatcher dispatcher = request.getRequestDispatcher("/registerFailed.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 跳转至注册界面
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
}
