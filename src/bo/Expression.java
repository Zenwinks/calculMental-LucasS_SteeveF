package bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Expression {

    public String generation(int difficulte, int fourchette){
        List<String> tabOp = new ArrayList<>();
        for (Operateur op : Operateur.values()) {
            tabOp.add(op.toString());
        }
        StringBuilder resultat = new StringBuilder();
        int base = 0;

        base += rand(fourchette) + 1;
        resultat.append(base + " ");
        for (int i=0; i < difficulte -1 ; i++) {
            int operande = 0;
            operande += rand(fourchette) + 1;
            resultat.append(operande + " ");
            resultat.append(tabOp.get(rand(4)) + " ");
        }
        int operandeUnaire = 0;
        operandeUnaire += rand(fourchette);
        resultat.append(operandeUnaire + " ");

        resultat.append(tabOp.get(rand(4)) + " ");
        resultat.append(tabOp.get(randUnaire(2)) + " ");

        return resultat.toString();
    }

    public Double resolution(String calcul){

        Double solution = 0d;
        Stack<Double> stack = new Stack();
        StringTokenizer stok = new StringTokenizer(calcul, " ");
        while (stok.hasMoreTokens()) {
            String token = stok.nextToken();

            try {
                Operateur op = Operateur.valueOf(token);
                if ( op.getType() == 1 ) {
                    Double op1 = 0d;
                    Double op2 = 0d;
                    op2 = stack.pop();
                    op1 = stack.pop();
                    stack.push(op.eval(op1, op2));
                } else {
                    Double op1 = 0d;
                    op1 = stack.pop();
                    stack.push(op.eval(op1));
                }
            } catch (Exception e ) {
                stack.push(Double.parseDouble(token));
            }
        }
        solution = stack.pop();
        return solution;
    }


    public Integer rand(int max){
        Double rand = (Math.random() * max);

        return rand.intValue();
    }

    public Integer randUnaire(int max) {
        Double rand = (Math.random() * max) + 4;

        return rand.intValue();
    }
}
