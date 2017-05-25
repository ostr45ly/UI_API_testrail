package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.RemoteDriverManager;

public class HeaderPage extends BasePage {

    By systemDashboardLocator = By.cssSelector("div.aui-page-header-main>h1");
    By createLocator = By.id("create-menu");
    By searchLocator = By.id("quickSearchInput");


    public HeaderPage() {
        this.driver = RemoteDriverManager.getDriver();
    }

    public HeaderPage search(String searchWord) {

        WebElement element = driver.findElement(searchLocator);
        element.sendKeys(searchWord);
        element.submit();
        return this;
    }

}