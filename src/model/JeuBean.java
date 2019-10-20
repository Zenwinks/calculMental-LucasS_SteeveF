package model;

import bo.Expression;
import bo.Question;
import bo.User;
import dal.DAOFactory;
import dal.JeuDAOJDBC;
import dal.UserDAOJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;
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

        int i = (int) session.getAttribute("nbQuestions");
        session.setAttribute("nbQuestions", ++i);
        if (i == 10) {
            session.setAttribute("buttonValue", "Terminer le jeu");
        }

        List<Question> questions = (List<Question>) session.getAttribute("questions");
        questions.add(question);
        session.setAttribute("questions", questions);
    }

    public boolean verifReponse(String repProp,String solution){
        if(Double.parseDouble(repProp) == (Double.parseDouble(solution))){
            return true;
        }
        else {
            return false;
        }
    }

    public void setResultatFinal(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        int score = 0;

        for (Question question : questions) {
            if (verifReponse(question.getResultat().replace(',', '.'), question.getReponseUser().replace(',', '.'))) {
                score++;
            }
        }

        session.setAttribute("scoreFinal", score);

        UserDAOJDBC daoUser = (UserDAOJDBC) DAOFactory.getUserDAO();
        JeuDAOJDBC daoJeu = (JeuDAOJDBC) DAOFactory.getJeuDAO();

        User user = (User) session.getAttribute("userConnected");
        try {
            if (score > user.getBestScore()) {
                user.setBestScore(score);
                daoUser.updateBestScore(score, user.getId());
            }
            daoJeu.insertScore(user.getId(), score);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
