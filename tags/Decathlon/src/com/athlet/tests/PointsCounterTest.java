/**
 * 
 */
package com.athlet.tests;

import com.athlet.domain.Result;
import com.athlet.domain.Sportsman;
import com.athlet.logic.PointsCounter;

import junit.framework.TestCase;

/**
 * @author Jaroslav Judin
 * May 26, 2010
 */
public class PointsCounterTest extends TestCase {


	PointsCounter counter;
	Sportsman man;
	Result res1;
	Result res2;
	Result res3;
	Result res4;
	Result res5;
	Result res6;
	Result res7;
	Result res8;
	Result res9;
	Result res10;
	
	public PointsCounterTest(String name) {
		super(name);
	}

	/*
	 * data from  http://en.wikipedia.org/wiki/Decathlon
	 */
	
	protected void setUp() throws Exception {
		super.setUp();
		
		counter = new PointsCounter();
		man = new Sportsman();
		res1 = new Result();
		res2 = new Result();
		res3 = new Result();
		res4 = new Result();
		res5 = new Result();
		res6 = new Result();
		res7 = new Result();
		res8 = new Result();
		res9 = new Result();
		res10 = new Result();
		
		res1.setSec(10.22);
		res2.setMeters(8.22); //sm
		res3.setMeters(19.17);
		res4.setMeters(2.27); //sm
		res5.setSec(45.68);
		res6.setSec(13.47);
		res7.setMeters(55.87);
		res8.setMeters(5.76);  //sm
		res9.setMeters(79.80);
		res10.setSec(3*60 + 58.70);
		
		man.setName("Erki Nool");
		man.addResult(res1);
		man.addResult(res2);
		man.addResult(res3);
		man.addResult(res4);
		man.addResult(res5);
		man.addResult(res6);
		man.addResult(res7);
		man.addResult(res8);
		man.addResult(res9);
		man.addResult(res10);

	}

	protected void tearDown() throws Exception {
		super.tearDown();
		man = null;
		res1 = res2 = res3 = res4 = res5 = 
			res6 = res7 = res8 =  res9 =  res10 = null; 
	}

	public final void testGetContents() {
		
		assertNotNull(man);
		assertNotNull(counter);
		
		man = counter.getTotalScore(man);
		System.out.println(man);
	}
	
}
