package test;

import bo.Expression;
import bo.Jeu;
import dal.DAOFactory;
import dal.IDAO;
import dal.JeuDAOJDBC;
import dal.UserDAOJDBC;

import java.sql.SQLException;

public class Test {

    public static void main(String args[]) throws SQLException {
        Expression ex = new Expression();
        String rep = ex.generation(4, 50);
        System.out.println(rep);

        System.out.println(ex.resolution(rep));

        //JeuDAOJDBC dao = new JeuDAOJDBC("jdbc:mysql://localhost:3306/calcul_mental?serverTimezone=UTC","root","");
        //dao.insertScore(1,6);
    }
}