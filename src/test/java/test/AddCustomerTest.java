package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;

import page.Dashboardpage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {
	WebDriver driver;
	
	
	
	@Test
	@Parameters({"username","password","FullName","CompanyName","Email","Phone","Address","City","State","country","Zip"})
public void validCustomerShouldBeAbleToCreateCustomer(String userName,String password,String fullname,String companyname,String emailid, String phonenum, String address,String city,String state,String country, String zipcode)  {
	 driver = BrowserFactory.init();
	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	loginpage.enterUsername(userName);
	loginpage.enterPassword(password);
	loginpage.signInButtonToLogin();
	Dashboardpage dashboardpage = PageFactory.initElements(driver,Dashboardpage.class);
	 dashboardpage.verifyDashBoardPage();
    dashboardpage.clickcustomerButton();
    dashboardpage.clickAddcustomerButton();
    AddCustomerPage addcustomerpage = PageFactory.initElements(driver, AddCustomerPage.class);
    addcustomerpage.enterFullName(fullname);
    addcustomerpage.enterCompany(companyname);
    addcustomerpage.enterEmailId(emailid);
    addcustomerpage.enterPhoneNumber(phonenum);
    addcustomerpage.enterAddress(address);
    addcustomerpage.enterCity(city);
    addcustomerpage.enterState(state);
    addcustomerpage.enterZipcode(zipcode);
    addcustomerpage.selectCountry(country);
    addcustomerpage.clickSaveButton();
    addcustomerpage.verifysummary();
    dashboardpage.clickListcustomer();
    addcustomerpage.verifyEnteredNameandDelete();
   // addcustomerpage.verifysummary();
   
    
	}
	

}
