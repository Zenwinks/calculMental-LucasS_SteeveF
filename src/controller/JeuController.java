package controller;

import bo.Question;
import model.JeuBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/jeu"})
public class JeuController extends HttpServlet {

    private static final String PAGE_JEU_JSP = "/WEB-INF/jsp/jeu.jsp";
    private static final String PAGE_RESULTS_JSP = "/WEB-INF/jsp/results.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JeuBean model = new JeuBean();
        HttpSession session = request.getSession(true);
        int i = (int)session.getAttribute("nbQuestions");
        if (i < 2){
            model.getQuestion(request);
            request.getRequestDispatcher(PAGE_JEU_JSP).forward(request, response);
        } else {
            model.setResultatFinal(request);
            request.getRequestDispatcher(PAGE_RESULTS_JSP).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        int i = (int)session.getAttribute("nbQuestions");
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        Question question = questions.get(i-1);
        question.setReponseUser(request.getParameter("form-reponse"));
        questions.set(i-1, question);
        session.setAttribute("questions", questions);

        doGet(request,response);
    }
}
