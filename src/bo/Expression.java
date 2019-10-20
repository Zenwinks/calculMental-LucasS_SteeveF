package bo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Expression {

    public Expression() {
    }

    public String generation(){
        int min = 3;
        int max = 6;
        int nbChiffres = min + (int)(Math.random() * ((max - min) + 1));
        int valMax = 50;

        List<String> tab = new ArrayList<>();
        for (Operateur op : Operateur.values()) {
            tab.add(op.toString());
        }
        StringBuilder resultat = new StringBuilder();
        int base = 0;

        base += rand(valMax) + 1;
        resultat.append(base + " ");
        for (int i=0; i < nbChiffres -1 ; i++) {
            int ope = 0;
            ope += rand(valMax) + 1;
            resultat.append(ope + " ");
            resultat.append(tab.get(rand(4)) + " ");
        }
        int opeUn = 0;
        opeUn += rand(valMax);
        resultat.append(opeUn + " ");

        resultat.append(tab.get(rand(4)) + " ");
        resultat.append(tab.get(randUnaire(2)) + " ");
        String res =resolution(resultat.toString());
        Double dou = Double.parseDouble(res.replace(',','.'));
        if (dou.isNaN())
        {
            String resultatF = generation();
            return resultatF;
        }
        else{
            return resultat.toString();
        }

    }

    public String resolution(String calcul){
        Stack<Double> stack = new Stack();
        String[] split = calcul.split("\\s+");
        for(String str : split){
            try {
                Operateur op = Operateur.valueOf(str);
                if(op.getType() == 0){
                    Double op1 = stack.pop();
                    Double op2 = stack.pop();
                    stack.push(op.eval(op2,op1));
                }
                else if (op.getType() ==1){
                    Double op1 = stack.pop();
                    stack.push(op.eval(op1));
                }
            }
            catch (Exception e){
                stack.push(Double.parseDouble(str));
            }
        }
        Double resultat = stack.pop();
        DecimalFormat df = new DecimalFormat("0.00");
        String resultatFinal = df.format(resultat);
        return resultatFinal;
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
