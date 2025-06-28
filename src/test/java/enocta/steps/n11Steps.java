package enocta.steps;


import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import enocta.utils.CommonMethods;
import enocta.utils.ConfigsReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class n11Steps extends CommonMethods {
	
	String pName = null;

	@When("Go to login page")
	public void go_to_login_page() {

		click(n11Page.loginPageBt);

	}

	@When("I enter valid username")
	public void i_enter_valid_username() {
		waitForVisibility(n11Page.username);
		sendText(n11Page.username, ConfigsReader.getProperty("username"));
	}

	@When("I enter valid password")
	public void i_enter_valid_password() {
		sendText(n11Page.password, ConfigsReader.getProperty("password"));
	}

	@Then("I click the login button")
	public void i_click_the_login_button() {
		click(n11Page.loginBt);
	}

	@When("I click the search button and write cell phone")
	public void i_click_the_search_button_and_write_cell_phone() {
		sendText(n11Page.searchBt, "cep telefonu" + Keys.ENTER);

	}

	@When("I filter the price as 15000 - 20000 TL")
	public void i_filter_the_price_as_tl() {
		sendText(n11Page.minPrice, "15000");
		sendText(n11Page.maxPrice, "20000");
		click(n11Page.priceSearchButton);
	}

	@When("I choose the phone")
	public void i_choose_the_phone() {
		for (int i = 0; i < n11Page.phoneList.size(); i++) {
			if (i == n11Page.phoneList.size() - 1) {
				click(n11Page.phoneList.get(i));
			}
		}

	}

	@When("I go to details of the phone and choose the seller")
	public void i_go_to_details_of_the_phone_and_choose_the_seller() {
		waitForVisibility(n11Page.storesBt);
		click(n11Page.storesBt);
		if(n11Page.pointsOfStores.size() < 1) 
		{
			System.out.println("There is no another store to sell this phone");
			click(n11Page.add);
			pName = n11Page.phoneName1.getText();
			return;
		}
		if(n11Page.pointsOfStores.size() == 1)
		{
			
			click(n11Page.add);
			pName = n11Page.phoneName1.getText();
			return;
		}
		
		
			double lowestP = Double.MAX_VALUE;
			WebElement lowestScoreSeller = null;
		    do {
		       

		        for (WebElement sellerElement : n11Page.pointsOfStores) {
		            try {
		                String pointText = sellerElement.getText().trim().replace(",", ".");
		                if (pointText.matches("\\d+(\\.\\d+)?")) {
		                    double point = Double.parseDouble(pointText);
		                    if (point < lowestP) {
		                        lowestP = point;
		                        lowestScoreSeller = sellerElement;
		                    }
		                }
		            } catch (Exception e) {
		                System.out.println("Couldn't read the point: " + sellerElement.getText());
		            }
		        }

		        if (!n11Page.nextBt.isEmpty() && n11Page.nextBt.get(0).isDisplayed()) {
		            click(n11Page.nextBt.get(0));
		            wait(2);
		        } else {
		            break;
		        }

		    } while (true);

		    if (lowestScoreSeller != null) {
		        jsClick(lowestScoreSeller);
		        click(n11Page.add);
		        pName = n11Page.phoneName1.getText();
		       
		    } else {
		        System.out.println("Failed to find store");
		    }
		
		}
		
	

	@Then("I add the shopping cart and check it")
	public void i_add_the_shopping_cart_and_check_it() {

		click(n11Page.sCartBt);
		String sCartPName = n11Page.phoneName2.getText();
		Assert.assertEquals("The account name does not match",pName, sCartPName);

	}

}
