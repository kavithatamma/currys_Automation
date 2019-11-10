package currys_sel;

import currys_sel.page_elements.LocatorHelper;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RegressionSuite extends Hooks {
    private LocatorHelper helper = new LocatorHelper();
    @Test
    public void searchTest()
    {
        String searchTerm = "laptops";
        helper.search(searchTerm);
        String actualTitle = helper.getPageTitle();
        String actualThumbNail = helper.getThumbNail();
        String actualCurrentUrl = helper.getCurrentUrl();

        assertThat(actualTitle,is(equalToIgnoringCase(searchTerm)));
        assertThat(actualThumbNail,is(equalToIgnoringCase(searchTerm)));
        assertThat(actualCurrentUrl,containsString(searchTerm));
    }

    @Test

    public void addProductToBasketTest() {
        helper.search("laptop");
        String expected = helper.selectAnyProduct();
        helper.addProductToBasket();
        String actual = helper.getproductInBasket();
        assertThat(actual, is(equalToIgnoringCase(expected)));
    }
    public void filterPrice(){
        //expted
        String priceRange = "£299.00 - £499.00";
        List<String> expectedList = Arrays.asList(priceRange.replace("£", "").split("-"));
        Double min = Double.parseDouble(expectedList.get(0));
        Double max = Double.parseDouble(expectedList.get(1));


        //actions
        helper.search("laptop");
        //helper.selectPrice(priceRange);
        //List<Double> actualPriceList = helper.getAllProductPrices();

        //follow any below one appraoch
        // verify
       // assertThat(actualPriceList,
           //     both(everyItem(is(greaterThanOrEqualTo(min)))).and(everyItem(is(lessThanOrEqualTo(max)))));

//        assertThat(actualPriceList,everyItem(is(greaterThanOrEqualTo(min))));
//        assertThat(actualPriceList,everyItem(is(lessThanOrEqualTo(max))));
    }
}
