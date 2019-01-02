package pers.geolo.logisticsassistant.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletUtils {
    public static void returnJSON(HttpServletResponse response, String message)
            throws IOException {
        //指定返回的格式为JSON格式
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write(message);
        out.close();
    }
}
