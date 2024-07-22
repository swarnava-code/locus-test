package sh.locus.test.web.map;

import org.openqa.selenium.By;

public class HomeMap {

    public By searchBox() {
        return By.cssSelector("input[placeholder='Search for Products, Brands and More']");
    }

    public By searchBtn() {
        return By.cssSelector("button[type='submit']");
    }

}
