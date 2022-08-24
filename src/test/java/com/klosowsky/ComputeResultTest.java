package com.klosowsky;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class ComputeResultTest {

    @Test
    public void divisionByZeroTest(){
        MathOperation mathOperation = new MathOperation();
        mathOperation.setOperator("div");
        mathOperation.setValue1(2);
        mathOperation.setValue2(0);
        assertThrows(ArithmeticException.class,()->mathOperation.computeResult());
    }

    @Test
    public void threePlusFourIsSevenTest(){
        MathOperation mathOperation = new MathOperation();
        mathOperation.setOperator("add");
        mathOperation.setValue1(3);
        mathOperation.setValue2(4);
        Assert.assertEquals(7.0,mathOperation.computeResult(),0.0001);
    }

    @Test
    public void sevenMinusFourIsThreeTest(){
        MathOperation mathOperation = new MathOperation();
        mathOperation.setOperator("sub");
        mathOperation.setValue1(7);
        mathOperation.setValue2(4);
        Assert.assertEquals(3.0,mathOperation.computeResult(),0.0001);
    }

    @Test
    public void fiveMultipleByFourIsTwenty(){
        MathOperation mathOperation = new MathOperation();
        mathOperation.setOperator("mul");
        mathOperation.setValue1(5);
        mathOperation.setValue2(4);
        Assert.assertEquals(20.0,mathOperation.computeResult(),0.0001);
    }

    @Test
    public void squareRootOfNine(){
        MathOperation mathOperation = new MathOperation();
        mathOperation.setOperator("sqrt");
        mathOperation.setValue1(9);
        Assert.assertEquals(3,mathOperation.computeResult(),0.0001);
    }

}
