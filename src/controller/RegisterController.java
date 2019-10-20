package controller;

import model.RegisterBean;
import model.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    private static final String PAGE_REGISTER_JSP = "/WEB-INF/jsp/register.jsp";
    private static final String PAGE_LOGIN_JSP = "/WEB-INF/jsp/register.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(PAGE_REGISTER_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegisterBean model = new RegisterBean();
        model.createUser(request);
        if(model.getCreationResult() != ""){
            request.setAttribute( "registerBean", model );
            doGet(request, response);
        } else {
            request.getRequestDispatcher(PAGE_LOGIN_JSP).forward(request, response);
        }
    }
}
