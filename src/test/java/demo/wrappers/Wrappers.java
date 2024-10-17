package demo.wrappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */

    public static void enterTextWrapper(WebDriver driver, By locator, String textToEnter) {
        System.out.println("Sending Key");
        Boolean success;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement inputBox = driver.findElement(locator);
            inputBox.clear();
            inputBox.sendKeys(textToEnter);
            inputBox.sendKeys(Keys.ENTER);
            success = true;
        } catch (Exception e) {
            System.out.println("Exception Occured!" + e.getMessage());
            success = false;
        }
    }

    public static Boolean clickOnElementWrapper(WebDriver driver, By locator) {
        System.out.println("Clicking");
        Boolean success;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Thread.sleep(3000);
            WebElement clickaWebElement = driver.findElement(locator);
            clickaWebElement.click();
            success = true;
        } catch (Exception e) {
            System.out.println("Exception Occured!" + e.getMessage());
            success = false;
        }
        return success;
    }

    public static Boolean searchStarRatingAndPrintCount(WebDriver driver, By locator, double starRating) {
        int washingMachineCount = 0;
        Boolean success;
        try {
            List<WebElement> starRatingElements = driver.findElements(locator);
            for (WebElement starRatingElement : starRatingElements) {
                if (Double.parseDouble(starRatingElement.getText()) <= starRating) {
                    washingMachineCount++;
                }
            }
            System.out.println("Count of washing machine which has star rating less than or equal to" + " " + starRating
                    + ": " + washingMachineCount);
            success = true;
        } catch (Exception e) {
            System.out.println("Exception Occured!");
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    public static Boolean printTitleAndDiscountIphone(WebDriver driver, By locator, int discount) {
        Boolean success;
        try {
            List<WebElement> productRows = driver.findElements(locator);
            HashMap<String, String> iphoneTitleDiscountMap = new HashMap<>();
            for (WebElement productRow : productRows) {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement discountElement = wait.until(ExpectedConditions.visibilityOf(productRow.findElement(By.xpath("//div[@class='tUxRFH']//div[@class='UkUFwK']//span"))));
                String discountPercent = discountElement.getText();
                Thread.sleep(3000);
                int discountValue = Integer.parseInt(discountPercent.replaceAll("[^\\d]", ""));
                if (discountValue > discount) {
                    String iphoneTitle = productRow.findElement(By.xpath(".//div[@class='KzDlHZ']")).getText();
                    iphoneTitleDiscountMap.put(discountPercent, iphoneTitle);
                }
            }

            for (Map.Entry<String, String> iphoneTitleDiscounts : iphoneTitleDiscountMap.entrySet()) {
                System.out.println("IPhone discount percentage :: " + iphoneTitleDiscounts.getKey()
                        + " and its title :: " + iphoneTitleDiscounts.getValue());
            }
            success = true;
        } catch (Exception e) {
            System.out.println("Exception Occured!");
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    public static Boolean printTitleAndImageUrlOfCoffeeMug(WebDriver driver, By locator) {
        Boolean success;
        try {
            List<WebElement> userReviewElements = driver.findElements(locator);
            Set<Integer> userReviewSet = new HashSet<>();
            for (WebElement userReviewElement : userReviewElements) {
                int userReview = Integer.parseInt(userReviewElement.getText().replaceAll("[^\\d]", ""));
                userReviewSet.add(userReview);
            }
            List<Integer> userReviewCountList = new ArrayList<>(userReviewSet);
            Collections.sort(userReviewCountList, Collections.reverseOrder());
            System.out.println(userReviewCountList);
            NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
            LinkedHashMap<String, String> productDetailMap = new LinkedHashMap<>();
            for (int i = 0; i < 5; i++) {
                String formatedUserReviewCount = "(" + numberFormat.format(userReviewCountList.get(i)) + ")";
                String productTitle = driver.findElement(By.xpath("//div[@class='slAVV4']//span[contains(text(),'"
                        + formatedUserReviewCount + "')]/../../a[@class='wjcEIp']")).getText();

                Thread.sleep(3000);
                String productImgUrl = driver.findElement(By.xpath("//div[@class='slAVV4']//span[contains(text(),'"
                        + formatedUserReviewCount + "')]/../..//img[@class='DByuf4']")).getAttribute("src");

                String highestReviewCountAndProductTitle = String.valueOf(i + 1) + "highest review count: "
                        + formatedUserReviewCount + " Title: " + productTitle;
                productDetailMap.put(highestReviewCountAndProductTitle, productImgUrl);
            }
            for (Map.Entry<String, String> productDetails : productDetailMap.entrySet()) {
                System.out.println(productDetails.getKey() + " and Product image url:" + productDetails.getValue());
            }
            success = true;

        } catch (Exception e) {
            System.out.println("Exception Occured!");
            e.printStackTrace();
            success = false;
        }
        return success;
    }
}
