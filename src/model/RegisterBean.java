package model;

import bo.User;
import dal.DAOFactory;
import dal.UserDAOJDBC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;

public class RegisterBean implements Serializable {

    private String login;
    private String pwd;
    private String creationResult;

    public RegisterBean() {
    }

    public void createUser(HttpServletRequest request) {
        login = request.getParameter("form-login");
        pwd = request.getParameter("form-pwd");
        creationResult = "";

        User user = new User(login, pwd);
        UserDAOJDBC dao = (UserDAOJDBC) DAOFactory.getUserDAO();

        try {
            dao.create(user);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            creationResult = "Ce login est déjà utilisé !";
        }
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

    public String getCreationResult() {
        return creationResult;
    }

    public void setCreationResult(String creationResult) {
        this.creationResult = creationResult;
    }
}
