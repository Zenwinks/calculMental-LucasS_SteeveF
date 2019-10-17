package dal;

import bo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOJDBC extends DataAccessObjectJDBC<User> {

    private static final String AUTHENT_QUERY = "SELECT * FROM user WHERE login = ? AND password = ?";
    private static final String GET_LEADERBOARD = "SELECT login,best_score FROM user ORDER BY best_score DESC LIMIT 10";

    public UserDAOJDBC(String dbUrl, String dbLogin, String dbPwd) {
        super(dbUrl, dbLogin, dbPwd);
    }

    @Override
    public void create(User objet) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    public User authenticate(String login, String password) throws SQLException {

        User user = null;
        try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
             PreparedStatement ps = connection.prepareStatement(AUTHENT_QUERY)) {
            ps.setString(1, login);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    user.setNbConnections(rs.getInt("connections") + 1);
                }
            }
        }
        return user;
    }

    public List<User> leaderboard() throws SQLException {
        List<User> leaderboard = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
             PreparedStatement ps = connection.prepareStatement(GET_LEADERBOARD)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setLogin(rs.getString("login"));
                    user.setBestScore(rs.getInt("best_score"));
                    leaderboard.add(user);
                }
            }
        }
        return leaderboard;
    }
}
