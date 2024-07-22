package sh.locus.test.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sh.locus.test.web.page.HomePage;
import sh.locus.test.web.page.ProductListPage;
import sh.locus.test.web.page.SingleProductPage;
import sh.locus.test.web.util.Constant;
import java.time.Duration;

public class FlipkartTestRunner {
    private static final Logger logger = LogManager.getLogger(FlipkartTestRunner.class);

    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    static HomePage homePage;
    static ProductListPage productListPage;
    static SingleProductPage singleProductPage;

    @BeforeTest
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.TIMEOUT_SEC));
        actions = new Actions(driver);

        // creating pages with same instance: singleton
        homePage = new HomePage(wait);
        productListPage = new ProductListPage(wait);
        singleProductPage = new SingleProductPage(wait);
    }

    @Test
    void testSearchFeature() {
        final String SHOES = "shoes";
        final String FOOTWEAR = "Footwear";
        driver.get(Constant.BASE_WEB_ADDRESS);
        homePage.searchItem(SHOES);
        productListPage.assertionByCategory(FOOTWEAR);
        productListPage.clickOnFirstItem();
    }

    @Test
    void testProductDetailPage() {
        driver.get(Constant.WEB_ADDRESS_FOR_SINGLE_ITEM);
        singleProductPage.assertionWithAddCartAndBuyButtons();
    }

    @AfterClass
    void tearDown() {
        driver.quit();
        logger.info("tear down");
    }

}