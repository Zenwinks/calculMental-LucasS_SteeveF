package filter;

import model.UserBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/accueil"})
public class LoginFilter implements Filter {

    private static final String PAGE_LOGIN = "/login";

    @Override
    public void doFilter( ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain ) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest)servletRequest).getSession(  );
        if ( null == session || null == session.getAttribute( UserBean.ATT_AUTH_SESSION )) {
            ((HttpServletResponse)servletResponse).sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + PAGE_LOGIN);
        } else {
            filterChain.doFilter( servletRequest, servletResponse );
        }
    }
}