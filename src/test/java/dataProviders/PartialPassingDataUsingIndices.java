package dataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PartialPassingDataUsingIndices {

	@Test(dataProvider = "dataSupply")
	public void sampleTest(String a) {
		System.out.println(a);
	}
	
	//Only prints a and d which is 0 and 3rd position
	@DataProvider(name = "dataSupply",indices = {0,3})
	public Object[] supplier() {
		Object[] data = {"a","b","c","d"};
		return data;
	}
}
