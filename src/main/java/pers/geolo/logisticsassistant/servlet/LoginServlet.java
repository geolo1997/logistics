package pers.geolo.logisticsassistant.servlet;

import org.apache.log4j.Logger;

import pers.geolo.logisticsassistant.entity.User;
import pers.geolo.logisticsassistant.service.UserService;

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

    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = UserService.getInstance().login(username, password);
        if (user != null) { // 登录成功
            // 登录信息存储至session
            request.getSession().setAttribute("user", user);
            LOGGER.info("登录成功！用户登录信息为：" + user.toString());
            // 重定向至主页面
            response.sendRedirect(request.getContextPath() + "/index");
        } else { // 登录失败
            // 转发至登录失败页面
            request.getRequestDispatcher("/loginFailed.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
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
