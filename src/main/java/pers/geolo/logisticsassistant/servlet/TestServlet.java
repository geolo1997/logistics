package pers.geolo.logisticsassistant.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 桀骜(Geolo)
 * @version 1.0
 * @date 2019/9/15
 */
@WebServlet(name = "testServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("head: " + req.getHeaderNames());
        System.out.println("query string: " + req.getQueryString());
        resp.getWriter().println("hahha");
        resp.getWriter().close();
    }
}
