package sh.locus.test.web.map;

import org.openqa.selenium.By;

public class ProductListMap {

    public By seekbar() {
        return By.cssSelector("div[class='iToJ4v D0puJn'] div[class='PYKUdo']");
    }

    public By category(){
        return By.xpath("//a[@class='R0cyWM'][normalize-space()='Footwear']");
    }

    public By productsRow1(){
        return By.className("_75nlfW");
    }

}
