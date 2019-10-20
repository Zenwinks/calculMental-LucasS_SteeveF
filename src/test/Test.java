package test;

import bo.Expression;

public class Test {

    public static void main(String args[]) {
        Expression ex = new Expression();
        String rep = ex.generation(4, 10);
        System.out.println(rep);

        System.out.println(ex.resolution(rep));
    }
}