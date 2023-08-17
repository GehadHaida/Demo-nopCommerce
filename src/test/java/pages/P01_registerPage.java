package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import stepDefinition.Hooks;

public class P01_registerPage {

    public WebElement registerLink(){
        return Hooks.driver.findElement(By.className("ico-register"));
    }

    public WebElement chooseGender(){
        return Hooks.driver.findElement(By.id("gender-male"));
    }

    public WebElement firstName(){
        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement lastName(){
        return Hooks.driver.findElement(By.id("LastName"));
    }

    public void birthDay(){
        Select select = new Select(Hooks.driver.findElement(By.name("DateOfBirthDay")));
        select.selectByIndex(10);
    }

    public void birthMonth(){
        Select select = new Select(Hooks.driver.findElement(By.name("DateOfBirthMonth")));
        select.selectByIndex(1);
    }

    public void birthYear(){
        Select select = new Select(Hooks.driver.findElement(By.name("DateOfBirthYear")));
        select.selectByValue("1999");
    }

    public WebElement email(){
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement pass(){
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement conPass()
    {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement clickRegister(){
        return Hooks.driver.findElement(By.id("register-button"));
    }

    public void registerAssertion()
    {
        boolean successful = Hooks.driver.findElement(By.className("result")).isDisplayed();
        WebElement errorMessageColor = Hooks.driver.findElement(By.className("result"));
        String actualColor = errorMessageColor.getCssValue("color");
        String expectedColor = "rgba(76, 177, 124, 1)";

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(successful);
        softAssert.assertEquals(expectedColor, actualColor, "Error message color is not red!");

        softAssert.assertAll();
    }
}
