package sh.locus.test.web.page;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import sh.locus.test.web.map.ProductListMap;
import sh.locus.test.web.util.PageUtil;
import java.util.List;

@AllArgsConstructor
public class ProductListPage extends PageUtil {
    private static final Logger logger = LogManager.getLogger(ProductListPage.class);
    private static final ProductListMap productListMap = new ProductListMap();

    private WebDriverWait wait;

    public void assertionByCategory(String keyword) {
        WebElement category = getClickableWebElement(productListMap.category(), wait);
        Assert.assertEquals(category.getText(), keyword);
        category = null;
    }

    public void clickOnFirstItem() {
        WebElement parentRowContainer1 = wait.until(ExpectedConditions.visibilityOfElementLocated(productListMap.productsRow1()));
        List<WebElement> childElements = parentRowContainer1.findElements(By.xpath("./*"));
        WebElement product1 = childElements.get(0);
        product1.click();
        product1 = null;
        childElements = null;
        parentRowContainer1 = null;
    }

    public void applyPriceFilter() {
        // TODO: fix it
        WebElement seekbar = wait.until(ExpectedConditions.visibilityOfElementLocated(productListMap.seekbar()));
        int width = seekbar.getSize().getWidth();
        int xOffset = width / 2;
//        actions.clickAndHold(seekbar).moveByOffset(xOffset, 0).release().perform();
        seekbar = null;
    }

    public void applyBrandFilter() {
        WebElement pumaCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(productListMap.pumaCheckbox()));
        pumaCheckbox.click();
        WebElement verifyPuma = wait.until(ExpectedConditions.visibilityOfElementLocated(productListMap.verifyPuma()));
        logger.info(verifyPuma.getText());
        Assert.assertEquals(verifyPuma.getText(), "PUMA");
    }

}
