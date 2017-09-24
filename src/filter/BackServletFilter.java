package filter;

import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by OovEver on 2017/9/19.
 */
@WebFilter(filterName = "BackServletFilter")
public class BackServletFilter implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest是ServletRequest的子类
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
//        解决相对路径问题，返回站点的根路径，
        String contextPath=request.getServletContext().getContextPath ();
//        通过request.getRequestURI()取出访问的uri: /tmall/admin_category_list
        String uri = request.getRequestURI();
        //        得到工程名
        uri =StringUtils.remove(uri, contextPath);
        if(uri.startsWith("/admin_")){


            String servletPath = StringUtils.substringBetween(uri,"_", "_") + "Servlet";
            String method = StringUtils.substringAfterLast(uri,"_" );
            request.setAttribute("method", method);
//            ("/" + servletPath)="/categoryServlet"
            req.getRequestDispatcher("/" + servletPath).forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }
    public void init(FilterConfig config) throws ServletException {

    }

}
