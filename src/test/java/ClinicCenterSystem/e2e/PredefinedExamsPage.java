package ClinicCenterSystem.e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PredefinedExamsPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"table-predefined-exams\"]")
    private WebElement tablePredefinedExams;



    public PredefinedExamsPage() {
    }

    public PredefinedExamsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ensureIsDisplayedPredefinedExams() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(tablePredefinedExams));
    }


    public WebElement getTablePredefinedExams() {
        return tablePredefinedExams;
    }


}
