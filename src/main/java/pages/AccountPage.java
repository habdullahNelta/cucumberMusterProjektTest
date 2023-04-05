package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountPage {

    final String email="test@test.test";
    WebDriver driver;

    public AccountPage(WebDriver driver)
    {
        this.driver = driver;
    }
    public WebElement doLogOut()
    {
       return driver.findElement(By.linkText("Log out"));
    }
    public void enterEmailInSubscribeField()
    {
        driver.findElement(By.id("newsletter-email")).sendKeys(email);
    }

    public WebElement hitSubscribeButton()
    {
       return driver.findElement(By.id("newsletter-subscribe-button"));
    }

    public WebElement checkSubscribeMessage()
    {
       return driver.findElement(By.id("newsletter-result-block"));
    }

    public WebElement checkUserOnAccountPage()
    {
        return driver.findElement(By.linkText("Log out"));
    }

    public List<WebElement> getMenuBar()
    {
        List<WebElement> navBar =driver.findElements(By.cssSelector(".top-menu >li"));
        return navBar;
    }


}
