package selenium.advance.UsingTestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConfigAnnotations {
	
	@BeforeSuite
	public void Bs() {
		System.out.println("open database connectivity");
	}
	@AfterSuite
	public void As() {
		System.out.println("close database connectivity");
	}
	@BeforeTest
	public void Bt() {
		System.out.println("pre conditions");
	}
	@AfterTest
	public void At() {
		System.out.println("post conditions");
	}
	@BeforeClass
	public void Bc() {
		System.out.println("Launch the browser");
	}
	@AfterClass
	public void Ac() {
		System.out.println("close browser");
	}
	@BeforeMethod
	public void Bm() {
		System.out.println("login executed");
	}
	@AfterMethod
	public void Am() {
		System.out.println("logout executed");
	}
	@Test
	
	public void demo() {
		System.out.println("hello");
	}
}
