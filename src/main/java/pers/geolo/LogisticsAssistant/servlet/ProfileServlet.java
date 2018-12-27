package pers.geolo.LogisticsAssistant.servlet;

import org.apache.commons.beanutils.BeanUtils;
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
@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User oldUser = (User) request.getSession().getAttribute("user");
        User newUser = MyBeanUtils.getBean(request, User.class);
        if (oldUser.getUsername().equals(newUser.getUsername())) { // 和会话中的用户名匹配
            UserService.getInstance().update(newUser);
            // 更新后的信息存储至session
            request.getSession().setAttribute("user", newUser);
            // 重定向至修改成功页面
            response.sendRedirect(request.getContextPath() + "/updateSuccess");
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
