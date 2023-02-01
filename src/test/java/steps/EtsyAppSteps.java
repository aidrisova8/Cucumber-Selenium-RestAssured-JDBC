package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EtsyAppHomePage;
import pages.EtsyAppSearchResultsPage;
import pages.EtsyTitlePages;
import utilities.Driver;
import java.util.List;


public class EtsyAppSteps {

    WebDriver driver= Driver.getDriver();
    EtsyAppHomePage etsyAppHomePage=new EtsyAppHomePage();
    EtsyAppSearchResultsPage etsyAppSearchResultsPage=new EtsyAppSearchResultsPage();
    EtsyTitlePages etsyTitlePages=new EtsyTitlePages();

    @When("user searches for {string}")
    public void user_searches_for(String item) {

        etsyAppHomePage.searchBox.sendKeys(item + Keys.ENTER);
    }




    @Then("user validates search result items name contains keyword {string}")
    public void user_validates_search_result_items_contains_keyword(String item) {

        List<WebElement> myItemsList=etsyAppSearchResultsPage.listOfItemsTitles;
        for(WebElement element:myItemsList){
            if(element.getText().contains(item)) {
                System.out.println(element.getText());

                Assert.assertTrue("Item doesn't contain sofa keyword" + element.getText(), element.getText().toLowerCase().contains(item));
            }
        }

    }

    @And("user applies price filter {string} dollars")
    public void userAppliesPriceFilterOverDollars(String filterRange) throws InterruptedException {
        etsyAppSearchResultsPage.filterButton.click();
        Thread.sleep(3000);
        if(filterRange.equals("Over 1500")){
            etsyAppSearchResultsPage.filterRadioButtonOver1500.click();
        } else if (filterRange.equals("Under 250")) {
            etsyAppSearchResultsPage.filterRadioButtonUnderr250.click();
        } else if (filterRange.equals("250 to 750")) {
            etsyAppSearchResultsPage.filterRadioButtonBetween50And500.click();
        } else if (filterRange.equals("500 to 1000")) {
            etsyAppSearchResultsPage.filterRadioButtonBetween500And1000.click();
        }
        etsyAppSearchResultsPage.applyBtn.click();
    }

    @Then("user validates that item prices are {string} dollars")
    public void userValidatesThatItemPricesAreOverDollars(String filterRange) throws InterruptedException {
        if (filterRange.equals("over 1500")) {
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultsPage.listOfItemsPrices;
            for (WebElement element : prices) {
                System.out.println(element.getText());
                //String = "2,299.00" --> double = 2299.00
                String priceStr = element.getText().replace(",", ""); //"1920.00"
                double actualPriceDbl = Double.parseDouble(priceStr);//1920.00
                System.out.println(actualPriceDbl);
                String expectedPrice = filterRange.substring(filterRange.indexOf(" ") + 1);
                double expectedPriceDbl = Double.parseDouble(expectedPrice);

                Assert.assertTrue(actualPriceDbl >= expectedPriceDbl); //1920.00 >= 1500.00
            }
        } else if (filterRange.equals("under 250")) {
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultsPage.listOfItemsPrices;
            for (WebElement element : prices) {
                System.out.println(element.getText());
                //String = "2,299.00" --> double = 2299.00
                String priceStr = element.getText().replace(",", ""); //"1920.00"
                double actualPriceDbl = Double.parseDouble(priceStr);//1920.00
                System.out.println(actualPriceDbl);
                String expectedPrice = filterRange.substring(filterRange.indexOf(" ") + 1);
                double expectedPriceDbl = Double.parseDouble(expectedPrice);
                Assert.assertTrue(actualPriceDbl < expectedPriceDbl); //1920.00 >= 250.00
            }

        } else if(filterRange.equals("250 to 750")){
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultsPage.listOfItemsPrices;
            for (WebElement element : prices) {
                System.out.println(element.getText());
                //String = "2,299.00" --> double = 2299.00
                String priceStr = element.getText().replace(",", ""); //"1920.00"
                double actualPriceDbl = Double.parseDouble(priceStr);//1920.00
                System.out.println(actualPriceDbl);
                String expectedPrice1 = filterRange.substring(0,filterRange.indexOf(" "));//250
                double expectedPriceDbl1 = Double.parseDouble(expectedPrice1);
                String expectedPrice2 = filterRange.substring(filterRange.lastIndexOf(" ")+1);//750
                double expectedPriceDbl2 = Double.parseDouble(expectedPrice2);
                Assert.assertTrue(actualPriceDbl >= expectedPriceDbl1 && actualPriceDbl<=expectedPriceDbl2); //1920.00 >= 250.00
            }
        } else if(filterRange.equals("500 to 1000")){
            Thread.sleep(3000);
            List<WebElement> prices = etsyAppSearchResultsPage.listOfItemsPrices;
            for (WebElement element : prices) {
                System.out.println(element.getText());
                //String = "2,299.00" --> double = 2299.00
                String priceStr = element.getText().replace(",", ""); //"1920.00"
                double actualPriceDbl = Double.parseDouble(priceStr);//1920.00
                System.out.println(actualPriceDbl);
                String expectedPrice1 = filterRange.substring(0,filterRange.indexOf(" "));//250
                double expectedPriceDbl1 = Double.parseDouble(expectedPrice1);
                String expectedPrice2 = filterRange.substring(filterRange.lastIndexOf(" ")+1);//750
                double expectedPriceDbl2 = Double.parseDouble(expectedPrice2);
                Assert.assertTrue(actualPriceDbl >= expectedPriceDbl1 && actualPriceDbl<=expectedPriceDbl2); //1920.00 >= 250.00
        }
    }
    }
    @When("user clicks on {string} section")
    public void user_clicks_on_section(String section) {

        if (section.equals("Jewelry & Accessories")) {
            etsyAppHomePage.jewelryAndAccessories.click();
        } else if (section.equals("Clothing & Shoes")) {
            etsyAppHomePage.clothingAndShoes.click();
        } else if (section.equals("Home & Living")) {
            etsyAppHomePage.homeAndLiving.click();
        } else if (section.equals("Wedding & Party")) {
            etsyAppHomePage.weddingAndParty.click();
        } else if (section.equals("Toys & Entertainment")) {
            etsyAppHomePage.toysAndEnt.click();
        } else if (section.equals("Art & Collectibles")) {
            etsyAppHomePage.artAndColl.click();
        } else if (section.equals("Craft Supplies")) {
            etsyAppHomePage.craftAndSupp.click();
        } else if (section.equals("Gifts & Gift Cards")) {
            etsyAppHomePage.giftsAndCards.click();
        }
    }


    @Then("user validates the title is {string} and the header is {string}")
    public void user_validates_the_title_is_and_the_header_is(String title, String header) {

        String actualHeader = "";
        String actualTitle = "";
        if (header.equals("Jewelry & Accessories")){
            actualHeader = etsyTitlePages.jaHeader.getText();
            actualTitle = driver.getTitle();
        }else if(header.equals("Clothing & Shoes")){
            actualHeader = etsyTitlePages.csHeader.getText();
            actualTitle = driver.getTitle();
        }else if(header.equals("Home & Living")){
            actualHeader = etsyTitlePages.hlHeader.getText();
            actualTitle = driver.getTitle();
        }else if(header.equals("Wedding & Party")){
            actualHeader = etsyTitlePages.wpHeader.getText();
            actualTitle = driver.getTitle();
        }else if(header.equals("Toys & Entertainment")){
            actualHeader = etsyTitlePages.teHeader.getText();
            actualTitle = driver.getTitle();
        }else if(header.equals("Art & Collectibles")){
            actualHeader = etsyTitlePages.acHeader.getText();
            actualTitle = driver.getTitle();
        }else if(header.equals("Craft Supplies & Tools")){
            actualHeader = etsyTitlePages.cstHeader.getText();
            actualTitle = driver.getTitle();
        }else if(header.equals("The Etsy Gift Guide")){
            actualHeader = etsyTitlePages.ggHeader.getText();
            actualTitle = driver.getTitle();
        }

        Assert.assertEquals(title,actualTitle);
        Assert.assertEquals(header,actualHeader);
    }



    @When("user1 applies price filter {string} dollars")
    public void user_applies_price_filter_dollars(String price) throws InterruptedException {
                etsyAppSearchResultsPage.filterButton.click();
        Thread.sleep(3000);
        if(price.equals("Over 1500")){
            etsyAppSearchResultsPage.filterRadioButtonOver1500.click();
        } else if (price.equals("Under 250")) {
            etsyAppSearchResultsPage.filterRadioButtonUnder250.click();
        } else if (price.equals("50 to 500")) {
            etsyAppSearchResultsPage.filterRadioButtonBetween50And500.click();
        } else if (price.equals("500 to 1000")) {
            etsyAppSearchResultsPage.filterRadioButtonBetween500And1000.click();
        }
        etsyAppSearchResultsPage.applyBtn.click();
    }


    @Then("user1 validates that item prices are {string} dollars")
    public void user_validates_that_item_prices_are_dollars(String price) throws InterruptedException {
        String expectedPriceStr1500 = "";
        String expectedPriceStr250 = "";
        String expectedPriceStr50 = "";
        String expectedPriceStr500 = "";
        String expectedPriceStr1000 = "";
        int expectedPriceInt1500 = 0;
        int expectedPriceInt250 = 0;
        int expectedPriceInt50 = 0;
        int expectedPriceInt500 = 0;
        int expectedPriceInt1000 = 0;

        if (price.equals("Over 1500")) {
            expectedPriceStr1500 = price.substring(price.indexOf(" ") + 1);
            expectedPriceInt1500 = Integer.parseInt(expectedPriceStr1500);
        } else if (price.equals("Under 250")) {
            expectedPriceStr250 = price.substring(price.indexOf(" ") + 1);
            expectedPriceInt250 = Integer.parseInt(expectedPriceStr250);
        } else if (price.equals("50 to 500")) {
            expectedPriceStr500 = price.substring(price.lastIndexOf(" ") + 1);
            expectedPriceInt500 = Integer.parseInt(expectedPriceStr500);
            expectedPriceStr50 = price.substring(0, price.indexOf(" ") - 1);
            expectedPriceInt50 = Integer.parseInt(expectedPriceStr50);
        } else if (price.equals("500 to 1000")) {
            expectedPriceStr1000 = price.substring(price.lastIndexOf(" ") + 1);
            expectedPriceInt1000 = Integer.parseInt(expectedPriceStr1000);
        }

        Thread.sleep(3000);
        List<WebElement> prices = etsyAppSearchResultsPage.listOfItemsPrices;

        for (WebElement element : prices) {
             //System.out.println(element.getText());
            String priceStr = element.getText().replace(",", "");//"1920.00"
            double priceDbl = Double.parseDouble(priceStr);
            System.out.println(priceDbl);

            if (price.equals("Over 1500")) {
                Assert.assertTrue(priceDbl >= expectedPriceInt1500);
            } else if (price.equals("Under 250")) {
                Assert.assertTrue(priceDbl <= expectedPriceInt250);
            } else if (price.equals("50 to 500")) {
                Assert.assertTrue(priceDbl >= expectedPriceInt50 && priceDbl <= expectedPriceInt500);
            } else if (price.equals("500 to 1000")) {
                Assert.assertTrue(priceDbl >= expectedPriceInt500 && priceDbl <= expectedPriceInt1000);
            }

        }
    }
}




