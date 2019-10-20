package bo;

import java.io.Serializable;

public class Jeu implements Serializable {

    private String login;
    private int score;

    public Jeu(){

    }

    public Jeu(String login, int score) {
        this.login = login;
        this.score = score;
    }

    public String getLogin() {
        return login;
    }

    public void setPseudo(String pseudo) {
        this.login = pseudo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
