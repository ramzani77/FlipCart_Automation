package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import java.util.logging.Level;


// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Successfully Created Driver");
    }

        @Test
        public void testCase01() throws InterruptedException{
            System.out.println("Begining Test Cae 01");

            double starRating = 4.0;
            driver.get("https://www.flipkart.com/");
            Wrappers.enterTextWrapper(driver, By.xpath("//input[@title='Search for Products, Brands and More']"), "Washing Machine");
            Thread.sleep(3000);
            Wrappers.clickOnElementWrapper(driver, By.xpath("//div[contains(text(),'Popularity')]"));
            Thread.sleep(3000);

            Boolean status = Wrappers.searchStarRatingAndPrintCount(driver,By.xpath("//span[contains(@id, 'productRating')]/div"), starRating);
            Assert.assertTrue(status);

            System.out.println("Ending Test Case 01");
        }

        @Test
        public void testCase02() throws InterruptedException{
            System.out.println("Begining of Test Case 02");

            int discount = 17;
            driver.get("https://www.flipkart.com/");

            Wrappers.enterTextWrapper(driver, By.xpath("//input[@title='Search for Products, Brands and More']"), "iPhone");
            Thread.sleep(3000);
            
    
            Boolean status = Wrappers.printTitleAndDiscountIphone(driver,By.xpath("//div[contains(@class,'yKfJKb')]"), 17 );
            Assert.assertTrue(status);
        

            System.out.println("Ending Test Case 02");
        }

        @Test
        public void testCase03() throws InterruptedException{
            System.out.println("Begining of Test Case 03");

           
            driver.get("https://www.flipkart.com/");

            Wrappers.enterTextWrapper(driver, By.xpath("//input[@title='Search for Products, Brands and More']"), "Coffee Mug");
            Thread.sleep(5000);
            Wrappers.clickOnElementWrapper(driver, By.xpath("//div[contains(@title, '4')]//div[@class='XqNaEv']"));
            Thread.sleep(4000);

            Boolean status = Wrappers.printTitleAndImageUrlOfCoffeeMug(driver,By.xpath("//div[@class='slAVV4']//span[@class='Wphh3N']"));
            Assert.assertTrue(status);
        

            System.out.println("Ending Test Case 03");
        }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}