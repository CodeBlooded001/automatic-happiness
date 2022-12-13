package grouping;

import org.testng.annotations.Test;

public class Register {

	@Test
	public void registerByProvidingOnlyMandatoryFields() {
		System.out.println("Register By Providing Only Mandatory Fields - Register");
	}
	
	@Test
	public void registerByProvidingAllFields() {
		System.out.println("Register By Providing All Fields - Register");
	}
	
	@Test
	public void registerByNotProvidingAnyFields() {
		System.out.println("Register By Not Providing Any Fields - Register");
	}
	@Test
	public void registerByProvidingDuplicateEmailAddress() {
		System.out.println("Register By Not Providing Duplicate Email Address - Register");
	}
}
