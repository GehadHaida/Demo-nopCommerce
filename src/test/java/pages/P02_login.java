package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import stepDefinition.Hooks;

public class P02_login {

    public WebElement enterMail(){
        return Hooks.driver.findElement(By.id("Email"));

    }
    public WebElement enterPass(){
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement loginClickBtn(){
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
    }

    public void lgnAssertion(){
        boolean registered = Hooks.driver.findElement(By.className("ico-account")).isDisplayed();
        String url = Hooks.driver.getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(registered);
        softAssert.assertEquals(url,"https://demo.nopcommerce.com/");
        softAssert.assertAll();

    }

    public void notLogged(){
        String unsuccessful = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]")).getText();
        WebElement errorMessageElement = Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]"));
        String actualColor = errorMessageElement.getCssValue("color");
        String expectedColor = "rgba(228, 67, 75, 1)";

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(unsuccessful.contains("Login was unsuccessful."));
        softAssert.assertEquals(expectedColor, actualColor, "Error message color is not red!");

        softAssert.assertAll();
    }
}
