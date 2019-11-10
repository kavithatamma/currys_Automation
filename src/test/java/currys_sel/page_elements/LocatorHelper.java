package currys_sel.page_elements;

import currys_sel.Hooks;
import currys_sel.util.RandomNumberHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocatorHelper extends Hooks{
            private String searchitem;

             public void search(String item){
             driver.findElement(By.id("search")).sendKeys(item);
             driver.findElement(By.cssSelector(".dc-search-fieldset__submit-button")).click();
        }

        public String getPageTitle(){ return driver.findElement(By.className("pageTitle")).getText();}

        public String getThumbNail(){return driver.findElement(By.className("current")).getText();}

        public String getCurrentUrl(){ return driver.getCurrentUrl();}

        public String selectAnyProduct(){
                 List<WebElement> productWebElements = driver.findElements(By.className("productTitle"));
            if (productWebElements.size() == 0) {
                throw new RuntimeException("you have 0 product for search term: "+searchitem);
                //fail("you have 0 product for search term: " + searchitem);
            }
                 int productCount = productWebElements.size();
                 int randomNumber = new RandomNumberHelper().generateRandomNumber(productCount);
                 String productSelected = productWebElements.get(randomNumber).getText();
                 productWebElements.get(randomNumber).click();

                 return productSelected;
        }
        public void addProductToBasket(){
            driver.findElement(By.cssSelector("#product-actions .channels .space-b.space-b center.Button-hYXUXp fIBPaH")).click();

        }
        public String getproductInBasket(){ return driver.findElement(By.cssSelector(".productTitle")).getText();}

    }

