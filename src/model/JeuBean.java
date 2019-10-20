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
        if (i == 2) {
            session.setAttribute("buttonValue", "Terminer le jeu");
        }

        List<Question> questions = (List<Question>) session.getAttribute("questions");
        questions.add(question);
        session.setAttribute("questions", questions);
    }

    public void setResultatFinal(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        int score = 0;

        for (Question question : questions) {
            if (question.getResultat() == question.getReponseUser()) {
                score++;
            }
        }

        session.setAttribute("scoreFinal", score);

        UserDAOJDBC daoUser = (UserDAOJDBC) DAOFactory.getUserDAO();
        JeuDAOJDBC daoJeu = (JeuDAOJDBC) DAOFactory.getJeuDAO();

        User user = (User) session.getAttribute("isConnected");
//        try {
//            if (user.getBestScore() < score) {
//                user.setBestScore(score);
//                daoUser.updateBestScore(score, user.getId());
//            }
//            daoJeu.insertScore(user.getId(), score);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
