package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.Dashboardpage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class ListCustomerTest {
	WebDriver driver;
	@Test
	@Parameters({"username","password","FullName","CompanyName","Email","Phone","Address","City","State","country","Zip"})
	public void userShouldBeAbletoUseSearchBarOnListCustomer(String userName,String password,String fullname,String companyname,String emailid, String phonenum, String address,String city,String state,String country, String zipcode) {
		 driver = BrowserFactory.init();
			LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
			loginpage.enterUsername(userName);
			loginpage.enterPassword(password);
			loginpage.signInButtonToLogin();
			Dashboardpage dashboardpage = PageFactory.initElements(driver,Dashboardpage.class);
			 dashboardpage.verifyDashBoardPage();
		    dashboardpage.clickcustomerButton();
		    dashboardpage.clickListcustomer();
			ListCustomerPage listcustomerpage = PageFactory.initElements(driver,ListCustomerPage.class );
			listcustomerpage.clickAddCustomerOnListCustomer();
			listcustomerpage.enterFullName(fullname);
			listcustomerpage.enterCompany(companyname);
			listcustomerpage.enterEmailId(emailid);
			listcustomerpage.enterPhoneNumber(phonenum);
			listcustomerpage.enterAddress(address);
			listcustomerpage.enterCity(city);
			listcustomerpage.enterState(state);
			listcustomerpage.enterZipcode(zipcode);
			listcustomerpage.selectCountry(country);
			listcustomerpage.clickSaveButton();
			//dashboardpage.clickcustomerButton();
			dashboardpage.clickListcustomer();
			listcustomerpage.insertNameOnSearchBar();
			listcustomerpage.testListCustomerSummaryButton();
		
		
		
		
		
		
		
		
	}

}
