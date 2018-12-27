package pers.geolo.LogisticsAssistant.servlet;

import pers.geolo.LogisticsAssistant.entity.User;
import pers.geolo.LogisticsAssistant.service.UserService;
import pers.geolo.LogisticsAssistant.utils.MyBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 桀骜
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = MyBeanUtils.getBean(request, User.class);
        boolean result = UserService.getInstance().login(user);
        if (result) { // 登录成功
            // 登录信息存储至session
            request.getSession().setAttribute("user", user);
            // 重定向至主页面
            response.sendRedirect(request.getContextPath() + "/index");
        } else { // 登录失败
            // 转发至登录失败页面
            request.getRequestDispatcher("/loginFailed.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) { // 如果存在会话信息，则自动登录
            // 重定向至主页面
            response.sendRedirect(request.getContextPath() + "/index");
        } else {
            // 转发到登录页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
