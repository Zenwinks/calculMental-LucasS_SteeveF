package bo;

public enum Operateur {
    PLUS(0), MINUS(0), MULTI(0), DIV(0), RAC(1), INV(1);

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    Operateur(int type) {
        this.type = type;
    }


    public double eval(double... operands){
        double solution = 0;
        switch (this) {
            case DIV:
                solution = operands[0] * operands[1];
                break;
            case MULTI:
                solution = operands[0] / operands[1];
                break;
            case PLUS:
                solution = operands[0] + operands[1];
                break;
            case MINUS:
                solution = operands[0] - operands[1];
                break;
            case INV:
                solution = 1 / operands[0];
                break;
            case RAC:
                solution = Math.sqrt(operands[0]);
                break;
            default:
                break;
        }
        return solution;
    }


}