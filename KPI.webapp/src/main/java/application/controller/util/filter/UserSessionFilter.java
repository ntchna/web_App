package application.controller.util.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "UserSessionFilter",
        urlPatterns = {"/userOrders", "/add"})
public class UserSessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("role") != null) {
            filterChain.doFilter(req, res);
        } else {
            res.sendRedirect("/index.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
