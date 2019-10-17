package controller;

import model.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet( urlPatterns = {"/login"} )
public class LoginController extends HttpServlet {

    private static final String PAGE_LOGIN_JSP = "/WEB-INF/jsp/login.jsp";
    private static final String PAGE_HOME_JSP = "/accueil";
    private static final Logger LOGGER = Logger.getLogger( LoginController.class.getName() );

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        UserBean model = new UserBean();
        if ( model.isConnected( request ) ) {
            response.sendRedirect( request.getContextPath()+PAGE_HOME_JSP );
        } else {
            request.getRequestDispatcher( PAGE_LOGIN_JSP ).forward( request, response );
        }
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        UserBean model = new UserBean();
        model.authenticate( request );
        request.setAttribute( "loginBean", model );
        doGet( request, response );
    }
}
