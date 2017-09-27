package filter;

import bean.User;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by OovEver on 2017/9/27.
 */
@WebFilter(filterName = "ForeAuthFilter")
public class ForeAuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest  request     = (HttpServletRequest) req;
        HttpServletResponse response    = (HttpServletResponse) res;
        String              contextPath =request.getServletContext().getContextPath();
        String[] noNeedAuthPage = new String[]{
                "homepage",
                "checkLogin",
                "register",
                "loginAjax",
                "login",
                "product",
                "category",
                "search"};
        String uri = request.getRequestURI();
        uri = StringUtils.remove(uri, contextPath);
        if(uri.startsWith("/fore")&&!uri.startsWith("/foreServlet")){
            String method = StringUtils.substringAfterLast(uri,"/fore" );
            if(!Arrays.asList(noNeedAuthPage).contains(method)){
                User user =(User) request.getSession().getAttribute("user");
                if(null==user) {
                    response.sendRedirect("login.jsp");
                    return;
                }
            }
        }
        chain.doFilter(req, res);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
