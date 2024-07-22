package sh.locus.test.web.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtil {

    protected WebElement getClickableWebElement(By by, WebDriverWait wait) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

}
