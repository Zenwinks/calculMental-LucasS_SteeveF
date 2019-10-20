package dal;

import bo.Jeu;
import bo.User;

import javax.servlet.ServletContext;

public class DAOFactory {

    private static String mode;
    private static String dbUrl;
    private static String dbLogin;
    private static String dbPwd;


    public static void init( ServletContext context ) throws ClassNotFoundException {

        mode = context.getInitParameter( "DS_MODE" );
        switch ( mode ) {
            case "JDBC" :
                Class.forName( context.getInitParameter( "DB_DRIVER" ) );
                dbUrl = context.getInitParameter( "DB_URL" );
                dbLogin = context.getInitParameter( "DB_LOGIN" );
                dbPwd = context.getInitParameter( "DB_PWD" );
                break;
            case "JPA":
            default:
                //TODO
        }
    }

    public static IDAO<User> getUserDAO() {
        IDAO<User> dao;
        switch ( mode ) {
            case "JDBC" :
                dao = new UserDAOJDBC(dbUrl, dbLogin, dbPwd);
                break;
            case "JPA" :
            default:
                //TODO
                dao = null;
        }
        return dao;
    }

    public static IDAO<Jeu> getJeuDAO() {
        IDAO<Jeu> dao;
        switch ( mode ) {
            case "JDBC" :
                dao = new JeuDAOJDBC(dbUrl, dbLogin, dbPwd);
                break;
            case "JPA" :
            default:
                //TODO
                dao = null;
        }
        return dao;
    }


}