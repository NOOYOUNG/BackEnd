package ch03_pjt_02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TransportationWalk tW=new TransportationWalk();
		//tW.move();

		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		//TransportationWalk transportationWalk=ctx.getBean("tWalk", TransportationWalk.class);
		//transportationWalk.move();
		
		CalAssembler calAssembler=ctx.getBean("calAssembler", CalAssembler.class);
		calAssembler.assemble();
		
		ctx.close();
	}

}
