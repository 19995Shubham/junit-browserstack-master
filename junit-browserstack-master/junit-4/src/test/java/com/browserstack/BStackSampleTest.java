package com.browserstack;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class BStackSampleTest extends BrowserStackJUnitTest {

    @Test
    public void test() {
        driver.get("https://bstackdemo.com/");
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("StackDemo"));
        String product_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='1']/p"))).getText();
        WebElement cart_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='1']/div[4]")));
        cart_btn.click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("float-cart__conten")));
        }
        catch (Exception e ){
            System.out.println("exception occurred" + e);
        }
        final String product_in_cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='__next']/div/div/div[2]/div[2]/div[2]/div/div[3]/p[1]"))).getText();
        System.out.println("print me please");

        assertTrue("Product add to the cart - Failed!", product_name.matches(product_in_cart));
    }
}
