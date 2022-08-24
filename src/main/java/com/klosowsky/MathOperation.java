package com.klosowsky;



public class MathOperation {
    private String operator;
    private double value1;
    private double value2;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }

    public double computeResult(){
        switch (operator) {
            case "add":
                return value1+value2;
            case "sub":
                return value1-value2;
            case "mul":
                return value1*value2;
            case "sqrt":
                return Math.sqrt(value1);
            case "div":
                if(value2==0){
                    throw new ArithmeticException("Division by zero");
                }
                return value1/value2;
            default:
                throw new UnsupportedOperationException("Bad operator");
        }
    }

}
