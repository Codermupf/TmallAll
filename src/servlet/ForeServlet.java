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

}
