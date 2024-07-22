package sh.locus.test.web.map;

import org.openqa.selenium.By;

public class SingleProductMap {

    public By buyNowBtn(){
        return By.xpath("//button[text()='Buy Now']");
    }

    public By addToCartBtn(){
        return By.xpath("//button[text()='Add to cart']");
    }

}
