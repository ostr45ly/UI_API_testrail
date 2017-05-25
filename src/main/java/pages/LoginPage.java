package pages;

import org.openqa.selenium.By;
import utils.RemoteDriverManager;

public class LoginPage extends BasePage {

    private By usernameLocator = By.id("login-form-username");
    private By passwordLocator = By.id("login-form-password");
    private By loginButtonLocator = By.id("login-form-submit");
    private By loginForm = By.id("login-form");


    public LoginPage() {
        this.driver = RemoteDriverManager.getDriver();
    }

    public void open() {
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
        waitToBePresent(loginForm);
    }

    public void enterUsername() {
        driver.findElement(usernameLocator).sendKeys("gubernatorova.sn");
    }

    public void enterPassword() {
        driver.findElement(passwordLocator).sendKeys("11111111");
    }

    public void clickLogin() {

        driver.findElement(loginButtonLocator).submit();
        waitToBePresent(By.xpath("//*[contains(text(),'System Dashboard')]"));

    }

}