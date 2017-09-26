package filter;

import bean.Category;
import bean.OrderItem;
import bean.User;
import dao.CategoryDAO;
import dao.OrderItemDAO;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by OovEver on 2017/9/25.
 */
@WebFilter(filterName = "ForeServletFilter")
public class ForeServletFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String contextPath=request.getServletContext().getContextPath();
        request.getServletContext().setAttribute("contextPath", contextPath);

        User user =(User) request.getSession().getAttribute("user");
        int cartTotalItemNumber= 0;
        if(null!=user){
            List<OrderItem> ois = new OrderItemDAO().listByUser(user.getId());
            for (OrderItem oi : ois) {
                cartTotalItemNumber+=oi.getNumber();
            }
        }
        request.setAttribute("cartTotalItemNumber", cartTotalItemNumber);

        List<Category> cs=(List<Category>) request.getAttribute("cs");
        if(null==cs){
            cs=new CategoryDAO().list();
            request.setAttribute("cs", cs);
        }

        String uri = request.getRequestURI();
        uri =StringUtils.remove(uri, contextPath);
        if(uri.startsWith("/fore")&&!uri.startsWith("/foreServlet")){
            String method = StringUtils.substringAfterLast(uri,"/fore" );
            request.setAttribute("method", method);
            req.getRequestDispatcher("/foreServlet").forward(request, response);
            return;
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
