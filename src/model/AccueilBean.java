package model;


import bo.User;
import dal.AccueilDAOJDBC;
import dal.DAOFactory;
import dal.UserDAOJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class AccueilBean implements Serializable {

    public AccueilBean() {
    }

    public void getLeaders(HttpServletRequest request) {
        UserDAOJDBC dao = (UserDAOJDBC) DAOFactory.getUserDAO();
        try {
            List<User> leaders = dao.leaderboard();

            HttpSession session = request.getSession(true);
            session.setAttribute("leaders", leaders);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
