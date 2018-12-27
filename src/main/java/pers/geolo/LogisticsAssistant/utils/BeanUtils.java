package pers.geolo.LogisticsAssistant.utils;

import pers.geolo.LogisticsAssistant.entity.Cargo;
import pers.geolo.LogisticsAssistant.entity.User;

import javax.servlet.http.HttpServletRequest;

public class BeanUtils {

    public static Object getBean(HttpServletRequest request) {
        if (request.getParameter("username") != null) {
            User user = new User();
            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));
            return user;
        } else  if(request.getParameter("cargoName") != null) {
            // TODO 将货主设置为当前会话用户
            Cargo cargo = new Cargo();
            cargo.setCargoName(request.getParameter("cargoName"));
            return cargo;
        }
        return null;
    }
}
