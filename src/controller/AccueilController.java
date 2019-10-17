package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/accueil"})
public class AccueilController extends HttpServlet {

    private static final String PAGE_ACCUEIL_JSP = "/WEB-INF/jsp/accueil.jsp";

    private static final Logger LOGGER = Logger.getLogger( AccueilController.class.getName() );

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.log( Level.INFO, "Request : " + request);
        request.getRequestDispatcher(PAGE_ACCUEIL_JSP).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
