package sample;

import org.testng.annotations.Test;

public class TimeOutAttribute {

	@Test
	public void m2() {
		System.out.println("m2");
	}
	@Test(timeOut = 3000)
	public void m1() {
		System.out.println("m1");
		
	}
	@Test
	public void m3() {
		System.out.println("m3");
	}
}
