package hu.evosoft.javasetraining.bigdecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double op1 = 0.1d;
		double op2 = 0.2d;

		double res = op1 + op2;
		
		System.out.println(res);
		
		BigDecimal op3 = new BigDecimal("0.1");
		BigDecimal op4 = new BigDecimal("0.2");
		
		System.out.println("!!: "+op3.add(op4));

		BigDecimal bdec = new BigDecimal("50.23");
		BigDecimal bdecRes = bdec.multiply(new BigDecimal("30.44"));
		System.out.println("Multiply:" + bdecRes);
		// Using MathContext
		MathContext mc = new MathContext(2, RoundingMode.DOWN);
		BigDecimal bdecMath = bdec.multiply(new BigDecimal("30.44"), mc);
		System.out.println("Multiply using MathContext: " + bdecMath);
		
		
		BigDecimal b = new BigDecimal("50.345");
		bdec = b.subtract(new BigDecimal("34.765"));
		System.out.println("Subtract: " + bdec);
		//Using MathContext
		mc = new MathContext(2, RoundingMode.FLOOR);
		bdecMath = b.subtract(new BigDecimal("34.765"), mc);
		System.out.println("Subtract using MathContext: " + bdecMath);	
		
		
		BigDecimal op5 = new BigDecimal("1.0");
		BigDecimal op6 = new BigDecimal("3.0");
		
		mc = new MathContext(2, RoundingMode.UNNECESSARY);
		BigDecimal result = op5.divide(op6,mc);
		System.out.println("RES: "+res);
		
		BigDecimal multiplied = result.multiply(op6, mc);
		
		System.out.println(multiplied.compareTo(op5));
	}

}
