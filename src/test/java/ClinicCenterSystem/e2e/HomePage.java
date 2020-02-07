package ClinicCenterSystem.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"predefinedExamsPatient\"]")
    private WebElement predefinedExams;

    @FindBy(xpath = "//*[@id=\"requests-ca\"]")
    private WebElement requests;

    @FindBy(xpath = "//*[@id=\"exam-requests-ca\"]")
    private WebElement examRequests;

    @FindBy(xpath = "//*[@id=\"exam-req-table\"]")
    private WebElement examRequestsTable;

    @FindBy(xpath = "//*[@id=\"rooms-table\"]")
    private WebElement roomsTable;

    @FindBy(xpath = "//*[@id=\"btnSchedule\"]")
    private WebElement btnSchedule;

    public HomePage() {

    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPredefinedExams() {
        return predefinedExams;
    }

    public WebElement getRequests() {
        return requests;
    }

    public WebElement getExamRequests() {
        return examRequests;
    }

    public WebElement getRoomsTable() { return roomsTable; }

    public WebElement getBtnSchedule() { return btnSchedule; }


    public WebElement getExamRequestsTable() {
        return examRequestsTable;
    }

    public void ensureIsDisplayedPredefined() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("predefinedExamsPatient")));
    }

    public void ensureIsDisplayedRequests() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("requests-ca")));
    }

    public void ensureIsDisplayedExamRequests() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("exam-requests-ca")));
    }

    public void ensureIsDisplayedRequestsExamTable() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(examRequestsTable));
    }

    public void ensureIsDisplayedRoomTable() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(roomsTable));
    }

    public void ensureIsScheduleBtnDisplayed() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".trs td:last-child")));
    }

    public void ensureIsScheduleBtnVisible() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSchedule")));
    }

}
