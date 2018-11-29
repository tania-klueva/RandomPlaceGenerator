package com.randomplace.filters;

import com.randomplace.models.User;
import com.randomplace.security.UserSession;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/login")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        User currentUser = UserSession.getCurrentUser((HttpServletRequest) req);
        if (currentUser != null) {
            ((HttpServletResponse) resp).sendRedirect("/user");
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
