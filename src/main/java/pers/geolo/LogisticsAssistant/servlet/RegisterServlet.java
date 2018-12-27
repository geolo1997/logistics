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
@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = MyBeanUtils.getBean(request, User.class);
        boolean result = UserService.getInstance().register(user);
        if (result) { // 注册成功
            // 登录信息存储至session
            request.getSession().setAttribute("user", user);
            // 转发至registerSuccess页面
            request.getRequestDispatcher("/registerSuccess.jsp").forward(request, response);
        } else { // 注册失败
            // 转发至registerFailed页面
            request.getRequestDispatcher("/registerFailed.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 转发至注册界面
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
}
