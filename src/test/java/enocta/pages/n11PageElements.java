package enocta.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import enocta.testbase.BaseClass;

public class n11PageElements {
	
	@FindBy(xpath = "//a[text()='Giriş Yap']")
	public WebElement loginPageBt;
	
	@FindBy(id = "email")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(xpath = "//*[@id=\"loginButton\"]")
	public WebElement loginBt;
	
	@FindBy(id = "searchData")
	public WebElement searchBt;
	
	@FindBy(css = "#minPrice")
	public WebElement minPrice;
	
	@FindBy(css = "#maxPrice")
	public WebElement maxPrice;
	
	@FindBy(id = "priceSearchButton")
	public WebElement priceSearchButton;
	
	@FindBy(xpath = "//*[@id=\"view\"]//li")
	public List<WebElement> phoneList;
	
	@FindBy(id = "unf-sell")
	public WebElement storesBt;
	
	@FindBy(xpath = "//*[@id=\"unf-sell\"]//div//div[@class='shopPoint']/span")
	public List<WebElement> pointsOfStores;
	
	@FindBy(xpath = "//*[@id=\"unf-sell\"]/div[2]/div[1]/div[11]/a[3]")
	public List<WebElement> nextBt;
	
	@FindBy(xpath = "//*[@id=\"unfDetailForm\"]/div/div/div/button")
	public WebElement add;

	
	public n11PageElements()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}

}
