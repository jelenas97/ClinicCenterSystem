package ClinicCenterSystem.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"inputEmail\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"inputPassword\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"loginbtn\"]")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"loginForm\"]")
    private WebElement loginForm;


    public LoginPage() {
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ensureIsDisplayedEmail() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(email));
    }

    public void ensureIsNotVisibleLoginBtn() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.id("loginbtn")));
    }

    public void ensureIsVisibleLoginBtn() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(loginBtn));
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }


    public WebElement getLoginForm() {
        return loginForm;
    }



}
