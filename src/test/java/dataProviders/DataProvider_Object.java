package dataProviders;

import org.testng.annotations.Test;

public class DataProvider_Object {
	
	//Two Dimensional
	@Test(dataProvider = "TwoDimensionalData", dataProviderClass = SampleProvider_Object.class)
	public void m1(String a , String b) {
		System.out.println(a+" "+b);
	}
	
	//One Dimensional
	@Test(dataProvider = "OneDimensionalData", dataProviderClass = SampleProvider_Object.class)
	public void m2(String x) {
		System.out.println(x);
	}
	
	//Iterator<Object>
	@Test(dataProvider = "IteratorObjectData",dataProviderClass = SampleProvider_Object.class)
	public void m3(Object y) {
		System.out.println(y);
	}
	
	@Test(dataProvider = "ListIteratorObjectArray",dataProviderClass = SampleProvider_Object.class)
	public void m4(Object z) {
		System.out.println(z);
	}
	@Test(dataProvider = "IteratorSetData",dataProviderClass = SampleProvider_Object.class)
	public void m5(Object s) {
		System.out.println(s);
	}
	
}
