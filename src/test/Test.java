package test;

import bo.Expression;
import model.JeuBean;

public class Test {
    public static void main(String[] args) {
        Expression ex = new Expression();
        String rep = ex.generation();
        System.out.println(rep);
    }
}
