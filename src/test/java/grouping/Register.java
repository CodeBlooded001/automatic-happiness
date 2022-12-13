package grouping;

import org.testng.annotations.Test;

public class Register {

	@Test(priority=1,groups= {"smoke","sanity","regression","register","all"})
	public void registerByProvidingOnlyMandatoryFields() {
		System.out.println("Register By Providing Only Mandatory Fields - Register");
	}
	
	@Test(priority=2,groups= {"sanity","regression","register","all"})
	public void registerByProvidingAllFields() {
		System.out.println("Register By Providing All Fields - Register");
	}
	
	@Test(priority=3,groups= {"sanity","regression","register","all"})
	public void registerByNotProvidingAnyFields() {
		System.out.println("Register By Not Providing Any Fields - Register");
	}
	@Test(priority=4,groups= {"smoke","register","all"})
	public void registerByProvidingDuplicateEmailAddress() {
		System.out.println("Register By Not Providing Duplicate Email Address - Register");
	}
}
