package model;


import bo.Question;
import bo.User;
import dal.DAOFactory;
import dal.UserDAOJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccueilBean implements Serializable {

    public AccueilBean() {
    }

    public void getLeaders(HttpServletRequest request) {
        List<Question> questions = new ArrayList<>();
        int nbQuestions = 0;

        UserDAOJDBC dao = (UserDAOJDBC) DAOFactory.getUserDAO();
        try {
            List<User> leaders = dao.leaderboard();

            HttpSession session = request.getSession(true);
            session.setAttribute("leaders", leaders);

            session.setAttribute("nbQuestions", nbQuestions);
            session.setAttribute("buttonValue", "Calcul suivant");
            session.setAttribute("questions", questions);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
