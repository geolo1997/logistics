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
@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ProfileServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User oldUser = (User) request.getSession().getAttribute("user");
        User newUser = MyBeanUtils.getBean(request, User.class);
        if (oldUser.getId() == newUser.getId()) { // 和会话中的用户id匹配
            UserService.getInstance().update(newUser);
            // 更新后的信息存储至session
            request.getSession().setAttribute("user", newUser);
            LOGGER.info("个人信息修改，修改前：" + oldUser.toString() + "\n修改后：" + newUser.toString());
            // 转发至修改成功页面
            request.getRequestDispatcher("/updateSuccess.jsp").forward(request, response);
        } else { // 修改失败
            // 转发至修改失败页面
            request.getRequestDispatcher("/updateFailed.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            request.getRequestDispatcher("/myProfile.jsp").forward(request, response);
        }
    }
}
