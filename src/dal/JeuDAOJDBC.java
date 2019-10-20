package dal;

import bo.Jeu;
import bo.User;

import java.sql.*;
import java.util.List;

public class JeuDAOJDBC extends DataAccessObjectJDBC<Jeu>{

    private static final String INSERT_SCORE_QUERY = "INSERT INTO score VALUES (null,?,?);";

    public JeuDAOJDBC(String dbUrl, String dbLogin, String dbPwd) {
        super(dbUrl, dbLogin, dbPwd);
    }


    public void insertScore(int idUser, int score) throws SQLException {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
             PreparedStatement ps = connection.prepareStatement(INSERT_SCORE_QUERY)) {
            ps.setInt(1, idUser);
            ps.setInt(2, score);
            ps.executeUpdate();
        }
    }

    @Override
    public void create(Jeu object) {

    }

    @Override
    public List<Jeu> findAll() {
        return null;
    }
}

