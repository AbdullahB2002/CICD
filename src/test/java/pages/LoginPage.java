package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//button[@type='submit']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Wait up to 10 seconds for elements
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    public void enterUsername(String user) {
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        userField.clear();
        userField.sendKeys(user);
    }

    public void enterPassword(String pass) {
        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        passField.clear();
        passField.sendKeys(pass);
    }

    public void clickLogin() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        btn.click();
    }

    public void loginToOrangeHRM(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
}
