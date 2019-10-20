package bo;

import java.io.Serializable;

public class Question implements Serializable {

    private String calcul;
    private String resultat;

    public Question(String calcul, String resultat) {
        this.calcul = calcul;
        this.resultat = resultat;
    }

    public String getCalcul() {
        return calcul;
    }

    public void setCalcul(String calcul) {
        this.calcul = calcul;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
}
