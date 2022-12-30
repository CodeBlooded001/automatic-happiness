package dataProviders;

import org.testng.annotations.DataProvider;

public class SampleProvider {

	@DataProvider(name = "getTestData")
	public String[][] dataSupplier() {
		String[][] data = { { "yaseswini@gmail.com", "yashu12345!" }, { "yashu@gmail.com", "12345" },
				{ "yashu11@gmail.com", "12345" } };
		return data;
	}
	
	@DataProvider(name = "supplierOne")
	public String[][] dataSupplierOne(){
		String[][] dataOne = {{"x1","x2"},{"y1","y2"},{"z1","z2"}};
		return dataOne;
	}
	
	@DataProvider(name = "supplierTwo")
	public String[][] dataSupplierTwo(){
		String[][] dataOne = {{"x11","x22"},{"y11","y22"},{"z11","z22"}};
		return dataOne;
	}
}
