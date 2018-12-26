package pers.geolo.LogisticsAssistant.servlet;

import pers.geolo.LogisticsAssistant.entity.User;
import pers.geolo.LogisticsAssistant.service.UserService;
import pers.geolo.LogisticsAssistant.utils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) BeanUtils.getBean(request);
        boolean result = UserService.getInstance().update(user);
        if (result) { // 修改成功
            // 登录信息存储至session
            request.getSession().setAttribute("user", user);
            // 跳转至修改成功页面
            response.sendRedirect(request.getContextPath() + "/updateSuccess");
        } else { // 登录失败
            // 跳转至修改失败页面
            request.getRequestDispatcher("/updateFailed.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/myProfile.jsp").forward(request, response);
    }
}
