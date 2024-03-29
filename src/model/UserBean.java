package model;

import bo.User;
import dal.DAOFactory;
import dal.UserDAOJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;

public class UserBean implements Serializable {

    private static final String FORM_FIELD_LOGIN = "form-login";
    private static final String FORM_FIELD_PWD = "form-pwd";
    public static final String ATT_AUTH_SESSION = "userConnected";

    private String login;
    private String pwd;
    private String authentResult;

    public UserBean() {
    }

    public void authenticate(HttpServletRequest request) {

        login = request.getParameter(FORM_FIELD_LOGIN);
        pwd = request.getParameter(FORM_FIELD_PWD);
        UserDAOJDBC dao = (UserDAOJDBC) DAOFactory.getUserDAO();
        User user = null;
        try {
            user = dao.authenticate(login, pwd);

            if (user != null) {
                HttpSession session = request.getSession(true);
                //TODO récupération et incrémentation du nombre de connexions
                session.setAttribute(ATT_AUTH_SESSION, user);
                authentResult = "Authentification réussie : Bienvenue " + login;
            } else {
                authentResult = "Authentification échouée : Le login ou le mot de passe n'est pas reconnu";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            authentResult = "Authentification échouée : Problème de connexion à la base de données ";
        }
    }

    public boolean isConnected(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User connectedUser = (User) session.getAttribute(ATT_AUTH_SESSION);
        return connectedUser != null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAuthentResult() {
        return authentResult;
    }

    public void setAuthentResult(String authentResult) {
        this.authentResult = authentResult;
    }
}
