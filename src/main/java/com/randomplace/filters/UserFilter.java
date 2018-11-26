package com.randomplace.filters;

import com.randomplace.security.UserSession;
import com.randomplace.utils.PagePath;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/user/*")
public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpSession session = httpServletRequest.getSession();
        Object attribute = session.getAttribute("user");
        if (attribute == null) {
            httpServletRequest.getRequestDispatcher(PagePath.SIGN_IN).forward(req, resp);
            return;
        } else {
            int userId = (int) attribute;
            if (!UserSession.isSessionValid(httpServletRequest, userId)) {
                httpServletRequest.getRequestDispatcher(PagePath.ERROR).forward(req, resp);
                return;
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
