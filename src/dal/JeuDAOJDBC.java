package dal;

import bo.Jeu;
import bo.User;

import java.sql.*;
import java.util.List;

public class JeuDAOJDBC extends DataAccessObjectJDBC<Jeu>{

    private static final String INSERT_SCORE_QUERY = "INSERT INTO score VALUES (null,?,?);";
    private static final String BEST_SCORE_JOUEUR = "SELECT best_score FROM user WHERE id = ?";

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

    public int getBestScore(int idUser) throws SQLException {
        int bestscore = 0;
        try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
             PreparedStatement ps = connection.prepareStatement(BEST_SCORE_JOUEUR)){
            ps.setInt(1,idUser);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    bestscore = rs.getInt("best_score");
                }
            }
        }
        return bestscore;
    }

    @Override
    public void create(Jeu object) {

    }

    @Override
    public List<Jeu> findAll() {
        return null;
    }
}

