package pers.geolo.logisticsassistant.servlet;

import org.apache.log4j.Logger;
import pers.geolo.logisticsassistant.entity.User;
import pers.geolo.logisticsassistant.service.UserService;
import pers.geolo.logisticsassistant.util.MyBeanUtils;

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

    private static final Logger LOGGER = Logger.getLogger(RegisterServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = MyBeanUtils.getBean(request, User.class);
        user = UserService.getInstance().register(user);
        if (user != null) { // 注册成功
            // 登录信息存储至session
            request.getSession().setAttribute("user", user);
            LOGGER.info("注册成功，注册信息为：" + user.toString());
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
