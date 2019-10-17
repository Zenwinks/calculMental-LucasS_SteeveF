package dal;

import bo.User;

import java.sql.*;
import java.util.List;

public class AccueilDAOJDBC extends DataAccessObjectJDBC<User> {

    private static final String GET_LEADERBOARD = "SELECT login,best_score FROM user ORDER BY best_score DESC LIMIT 10";

    public AccueilDAOJDBC(String dbUrl, String dbLogin, String dbPwd) {
        super(dbUrl, dbLogin, dbPwd);
    }

//    public List<User> leaderboard() throws SQLException {
//        List<User> leaderboard = null;
//        try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
//             PreparedStatement ps = connection.prepareStatement(GET_LEADERBOARD)) {
//            try (ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    User user = new User();
//                    user.setLogin(rs.getString("login"));
//                    user.setBestScore(rs.getInt("best_score"));
//                    leaderboard.add(user);
//                }
//            }
//        }
//        return leaderboard;
//    }

    @Override
    public void create(User object) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
