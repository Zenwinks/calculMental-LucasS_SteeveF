package bo;

import java.io.Serializable;

public class Jeu implements Serializable {

    private String pseudo;
    private int score;

    public Jeu(){

    }

    public Jeu(String pseudo, int score) {
        this.pseudo = pseudo;
        this.score = score;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
