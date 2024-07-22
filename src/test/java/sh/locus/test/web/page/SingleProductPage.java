package sh.locus.test.web.page;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import sh.locus.test.web.map.SingleProductMap;
import sh.locus.test.web.util.PageUtil;

@AllArgsConstructor
public class SingleProductPage extends PageUtil {
    private static final SingleProductMap singleProductMap = new SingleProductMap();

    private WebDriverWait wait;

    public void assertionWithAddCartAndBuyButtons(){
        WebElement addToCartBtn = getClickableWebElement(singleProductMap.addToCartBtn(), wait);
        WebElement buyNowBtn = getClickableWebElement(singleProductMap.buyNowBtn(), wait);
        String addToCartBtnValue = addToCartBtn.getText();
        String buyNowBtnValue = buyNowBtn.getText();
        Assert.assertEquals(addToCartBtnValue, "ADD TO CART");
        Assert.assertEquals(buyNowBtnValue, "BUY NOW");
    }

}
