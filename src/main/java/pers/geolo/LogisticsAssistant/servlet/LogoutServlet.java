package pers.geolo.LogisticsAssistant.servlet;

import pers.geolo.LogisticsAssistant.entity.User;
import pers.geolo.LogisticsAssistant.service.UserService;

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        UserService.getInstance().logout(user);
        // 删除会话信息
        request.getSession().setAttribute("user", null);
        response.sendRedirect(request.getContextPath() + "/logoutSuccess.jsp");
    }
}
