package sh.locus.test.web.page;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import sh.locus.test.web.map.HomeMap;
import sh.locus.test.web.util.PageUtil;

@AllArgsConstructor
public class HomePage extends PageUtil {
    private WebDriverWait wait;

    private static final HomeMap homeMap = new HomeMap();

    public void searchItem(String keyword) {
        WebElement searchBox = getClickableWebElement(homeMap.searchBox(), wait);
        searchBox.sendKeys(keyword);
        searchBox = null;

        WebElement searchBtn = getClickableWebElement(homeMap.searchBtn(), wait);
        searchBtn.click();
        searchBtn = null;
    }

}
