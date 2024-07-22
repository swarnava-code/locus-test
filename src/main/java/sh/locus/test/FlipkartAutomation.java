package sh.locus.test;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class FlipkartAutomation {

    static WebDriver driver;
    static final String BASE_URL = "https://www.flipkart.com";

    public static void main(String[] args) {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriverManager.chromedriver().driverVersion("97.0.4692.71").setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open Flipkart
        driver.get("https://www.flipkart.com");

        // Close the login popup
        WebElement closeButton = driver.findElement(By.xpath("//button[contains(text(), '✕')]"));
        closeButton.click();

        // Perform search for 'shoes'
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("shoes");
        searchBox.submit();

        // Verify search results
        assert driver.getTitle().contains("shoes");

        // Apply filters
        applyFilters(driver);

        // Open product detail page
        openProductDetailPage(driver);

        // Close the browser
        driver.quit();
    }

    private static void applyFilters(WebDriver driver) {
        // Apply price filter
        WebElement priceFilter = driver.findElement(By.xpath("//div[contains(text(), 'Price')]"));
        priceFilter.click();
        WebElement priceRange = driver.findElement(By.xpath("//div[contains(text(), '₹500 - ₹1000')]"));
        priceRange.click();

        // Apply brand filter
        WebElement brandFilter = driver.findElement(By.xpath("//div[contains(text(), 'Brand')]"));
        brandFilter.click();
        WebElement brandName = driver.findElement(By.xpath("//div[contains(text(), 'Puma')]"));
        brandName.click();

        // Verify filters
        assert driver.getPageSource().contains("₹500 - ₹1000");
        assert driver.getPageSource().contains("Puma");
    }

    private static void openProductDetailPage(WebDriver driver) {
        // Open the first product detail page
        WebElement firstProduct = driver.findElement(By.xpath("//a[@class='_1fQZEK']"));
        firstProduct.click();

        // Switch to the new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Select size
        WebElement sizeOption = driver.findElement(By.xpath("//a[contains(text(), '7')]"));
        sizeOption.click();

        // Click 'Buy Now'
        WebElement buyNowButton = driver.findElement(By.xpath("//button[contains(text(), 'BUY NOW')]"));
        buyNowButton.click();

        // Verify login page
        assert driver.getTitle().contains("Login");
    }
}
