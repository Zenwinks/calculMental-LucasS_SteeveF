package model;

import bo.Expression;
import bo.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

public class JeuBean implements Serializable {

    private String reponseUser;

    public JeuBean() {
    }

    public void getQuestion(HttpServletRequest request) {
        Expression expr = new Expression();
        String calcul = expr.generation();
        String resultat = expr.resolution(calcul);
        Question question = new Question(calcul, resultat);

        HttpSession session = request.getSession(true);
        session.setAttribute("calcul", calcul);
        session.setAttribute("reponse", resultat);

        int i = (int)session.getAttribute("nbQuestions");
        session.setAttribute("nbQuestions", ++i);
        if (i == 10){
            session.setAttribute("buttonValue", "Terminer le jeu");
        }

        List<Question> questions = (List<Question>)session.getAttribute("questions");
        questions.add(question);
        session.setAttribute("questions", questions);
    }

    public void setResultatFinal(HttpServletRequest request){

    }
}
