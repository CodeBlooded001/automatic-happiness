package grouping;

import org.testng.annotations.Test;

public class Search {

	@Test(priority=1,groups = {"smoke","regression","search","all"})
	public void searchWithValidProduct() {
		System.out.println("search With Valid Product - Search");
	}
	@Test(priority = 2,groups = {"search","regression","all"})
	public void searchWithInValidProduct() {
		System.out.println("search With Invalid Product - Search");
	}
	@Test(priority = 3,groups = {"smoke","regression","search","all"})
	public void searchWithOutAnySearchItem() {
		System.out.println("search Without Any Product - Search");
	}
	
	
}
