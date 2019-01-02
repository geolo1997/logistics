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
@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            UserService.getInstance().logout(user);
            LOGGER.info("用户" + user.getUsername() + "(" + user.getRealName() + ")注销登录");
            // 删除会话信息
            request.getSession().removeAttribute("user");
        }
        response.sendRedirect(request.getContextPath() + "/logoutSuccess.jsp");
    }
}
