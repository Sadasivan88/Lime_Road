package com.stepdefinition;
import org.openqa.selenium.WebDriver;

import com.baseclass.BrowserName;
import com.baseclass.Lime_Road_Base_Class;
import com.baseclass.NykkaBase;
import com.page_object_manager.Lime_Road_Page_Object_Manager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Lime_Road_Step_Definition extends NykkaBase{
	
	
	@When("User launch the url {string}")
	public void User_launch_the_url(String url) {
		System.out.println("User_launch_the_url(String url)");
		getWebPage(url,"navigate");
	}
	@And("User Clicks on shop men")
	public void User_Clicks_on_shop_men() throws Exception {
		System.out.println("User_Clicks_on_shop_men()");
		Thread.sleep(2000);
		clickElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getShop_men());
	}
	@And("User hovers mouse over Men module")
	public void User_hovers_mouse_over_men_module() {
		System.out.println("User_hovers_mouse_over_men_module()");
		explicitWait(15, "clickable",Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getMen_category());
		moveToTargetElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getMen_category());
	}
	@And("User clicks the Tshirt under sports wear sub module")
	public void User_clicks_the_Tshirt_under_sports_wear_sub_module() {
		System.out.println("User_clicks_the_Tshirt_under_sports_wear_sub_module()");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moveToTargetElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getSports_t_shirt());
		clickElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getSports_t_shirt());
	}
	@And("User clicks on trending radio button")
	public void User_clicks_on_trending_radio_button() {
		System.out.println("User_clicks_on_trending_radio_button()");
		explicitWait(15,"clickable",Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getTrending_radio_button() );
		clickElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getTrending_radio_button());
	}
	@And("User clicks on brand option")
	public void User_clicks_on_brand_option() throws Exception {
		System.out.println("User_clicks_on_brand_option()");
		moveToTargetElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getBrand_option());
		clickElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getBrand_option());
	}
	
	@And("User clicks on campus sutra brand")
	public void User_clicks_on_campus_sutra_brand() {
		System.out.println("User_clicks_on_campus_sutra_brand()");
		explicitWait(15,"clickable",Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getCampus_sutra_brand());
		moveToTargetElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getCampus_sutra_brand());
		clickElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getCampus_sutra_brand());
	}
		
	@Then("User validates the brand name")
	public void User_validates_the_brand_name() {
	    System.out.println("User_validates_the_brand_name()");
		System.out.println(driver.getTitle());
	}
	@And("User selects the desired tshirt and opens in new tab")
	public void User_selects_the_desired_tshirt_and_opens_in_new_tab() throws Exception {
		System.out.println("User_selects_the_desired_tshirt_and_opens_in_new_tab()");
		Thread.sleep(2000);
		explicitWait(15, "clickable", Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getSeven_seven_nine_rupees_tshirt());
		moveToTargetElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getSeven_seven_nine_rupees_tshirt());
		rightClick(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getSeven_seven_nine_rupees_tshirt());
		keyPressNow("down");
		keyPressNow("enter");
		keyReleaseNow("down");
		keyReleaseNow("enter");
		Thread.sleep(1000);
	}
	
	@And("User switches to the desired tshirt tab with url {string}")
	public void User_switches_to_the_desired_tshirt_tab_with_url(String url) {
		System.out.println("User_switches_to_the_desired_tshirt_tab_with_url(String url)");
		switchTab(url);
	}
	
	@And("User selects small size tshirt")
	public void User_selects_small_size_tshirt() throws Exception {
		System.out.println("User_selects_small_size_tshirt()");
		explicitWait(15, "clickable", Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getSamll_size_choice());
//		Thread.sleep(2000);
		moveToTargetElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getSamll_size_choice());
		clickElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getSamll_size_choice());
	}
	@And("User clicks the add to cart button")
	public void User_clicks_the_add_to_cart_button() throws Exception {
		System.out.println("User_clicks_the_add_to_cart_button()");
		Thread.sleep(2000);
		moveToTargetElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getAdd_to_cart());
		clickElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getAdd_to_cart());
	}
	@And("User increase the quantity of items in cart")
	public void User_increase_the_quantity_of_items_in_cart() {
		System.out.println("User_increase_the_quantity_of_items_in_cart()");
		explicitWait(15, "clickable",Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getIncrease_quantity_menu());
		clickElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getIncrease_quantity_menu());
		dropDown(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getIncrease_quantity_menu(),"Text", "2");
	}
	@And("User cliks the buy now button")
	public void User_cliks_the_buy_now_button() {
		System.out.println("User_cliks_the_buy_now_button()");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		moveToTargetElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getBuy_now());
		clickElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getBuy_now());
	}
	
	@And("User selects medium size tshirt")
	public void User_selects_medium_size_tshirt() {
		System.out.println("User_selects_medium_size_tshirt()");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		explicitWait(15, "clickable",Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getMedium_size_choice());
		moveToTargetElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getMedium_size_choice());
		clickElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getMedium_size_choice());
	}
	@And("User selects large size tshirt")
	public void User_selects_large_size_tshirt() {
		System.out.println("User_selects_large_size_tshirt()");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		explicitWait(15, "clickable",Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getLarge_size_choice());
		moveToTargetElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getLarge_size_choice());
		clickElement(Lime_Road_Page_Object_Manager.pageObjectManager().storedElements().getLarge_size_choice());
	}
	
	
}
