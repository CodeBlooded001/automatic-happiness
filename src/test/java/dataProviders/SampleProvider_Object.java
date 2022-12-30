package dataProviders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.annotations.DataProvider;

public class SampleProvider_Object {
	
	private static final int Object = 0;

	//Return Type - Two Dimensional Object Array
	@DataProvider(name="TwoDimensionalData")
	public Object[][] dataOne(){
		Object[][] x = {{"Yashu","Baby"},
						{"Potti","Pilla"},
						{"Pinki","Ammulu"}};
		return x;
	}
	
	//Return type - One Dimensional Object Array
	@DataProvider(name="OneDimensionalData")
	public Object[] dataTwo() {
		Object[] y = {"Yashu","Potti","Pinky","Ammulu"};
		return y;
	}

	/*	
	 * This is something which is not possible
	 	as return type cannot be List<Object>
	 * @DataProvider(name="IteratorObjectData")
		public List<Object> dataSupplier(){
		
		List<Object> list = new ArrayList<>();
		list.add("Yashu");
		list.add("TestEngineer");
		list.add(true);
		return list;
		
	}*/
	
	//Return type - Iterator<Object>
	@DataProvider(name="IteratorObjectData")
	public Iterator<Object> dataSupplierList() {
		List<Object> list = new ArrayList<>();
		list.add("Yashu");
		list.add("TestEngineer");
		list.add(true);
		return list.iterator(); //return type of this is Iterator<Object>
	}
	@DataProvider(name="ListIteratorObjectArray")
	public Iterator<Object[]> dataSupplierListObjectArray() {
	
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[] {"Yashu","Y","Pinky"});
		list.add(new Object[] {"Ammulu"});
		
		return list.iterator();
	}
	//Return type - Iterator<Object>
	@DataProvider(name="IteratorSetData")
	public Iterator<Object> dataSupplierSet() {
		Set<Object> set = new HashSet<>();
		set.add("Hi");
		set.add("Hey");
		set.add("How r u?");
		return set.iterator(); //return type of this is Iterator<Object>
	}
	
	
}
