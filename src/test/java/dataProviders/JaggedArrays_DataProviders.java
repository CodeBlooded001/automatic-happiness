package dataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JaggedArrays_DataProviders {

	@Test(dataProvider = "Data_Supplier")
	//public void sampleTest(Object a) {
	public void sampleTest(Object[] a) {
		
		//dynamically findind the length of that particular data
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println("-----------------------------");
	}
	
	@DataProvider(name="Data_Supplier")
	public Object[][] dataSupplier() {
			
		Object[][] data = {{"a","b","c"},
				{"d","e"},
				{"f"}};
			return data;
		}
	
}
