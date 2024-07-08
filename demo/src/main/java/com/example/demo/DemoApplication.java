package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
//		MyCalculator calculator=new MyCalculator();
//		calculator.calAdd(10,5);
//		calculator.calSub(10,5);
//		calculator.calMul(10,5);
//		calculator.calDiv(10,5);
		
//		calculator.calAdd(10,5,new CalAdd());
//		calculator.calSub(10,5,new CalSub());
//		calculator.calMul(10,5,new CalMul());
//		calculator.calDiv(10,5,new CalDiv());
		
//		calculator.calculate(10,5, new CalAdd());
//		calculator.calculate(10,5, new CalSub());
//		calculator.calculate(10,5, new CalAdd());
//		calculator.calculate(10,5, new CalAdd());
	
		new CalAssembler();
	}

}
