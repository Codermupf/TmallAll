package servlet;

import bean.*;
import comparator.*;
import dao.CategoryDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.ProductImageDAO;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.util.HtmlUtils;
import util.Page;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by OovEver on 2017/9/26.
 */
@WebServlet(name = "ForeServlet")
public class ForeServlet extends BaseForeServlet {
    public String home(HttpServletRequest request, HttpServletResponse response, Page page) {
        List<Category> cs      = new CategoryDAO().list();
        ProductDAO     p       = new ProductDAO();
        ServletContext context = getServletContext( );
        p.fill(cs);
        p.fillByRow(cs);
//        new ProductDAO().fill(cs);
//        new ProductDAO().fillByRow(cs);
        request.setAttribute("cs", cs);
        return "home.jsp";
    }
    public String register(HttpServletRequest request, HttpServletResponse response, Page page) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        name = HtmlUtils.htmlEscape(name);
        System.out.println(name);
        boolean exist = userDAO.isExist(name);

        if(exist){
            request.setAttribute("msg", "用户名已经被使用,不能使用");
            return "register.jsp";
        }

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        userDAO.add(user);

        return "@registerSuccess.jsp";
    }
    public String login(HttpServletRequest request, HttpServletResponse response, Page page) {
        String name = request.getParameter("name");
        name = HtmlUtils.htmlEscape(name);
        String password = request.getParameter("password");

        User user = userDAO.get(name,password);

        if(null==user){
            request.setAttribute("msg", "账号密码错误");
            return "login.jsp";
        }
        request.getSession().setAttribute("user", user);
        return "@forehome";
    }
    public String logout(HttpServletRequest request, HttpServletResponse response, Page page) {
        request.getSession().removeAttribute("user");
        return "@forehome";
    }
}