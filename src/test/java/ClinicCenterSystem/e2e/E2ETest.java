package ClinicCenterSystem.e2e;

//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class E2ETest {

    public static final String BASE_URL = "http://localhost:4200";

    private WebDriver browser;

    private LoginPage loginPage;

    private HomePage homePage;

    private PredefinedExamsPage predefinedExamsPage;


    @BeforeMethod
    public void setUp() {
        // instantiate chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        browser = new ChromeDriver();

        // instantiate firefox browser
        //System.setProperty("webdriver.gecko.driver","src/test/java/resources/geckodriver");
        //FirefoxOptions firefoxOptions = new FirefoxOptions();
        //firefoxOptions.setCapability("marionette",true);


        //browser = new FirefoxDriver(firefoxOptions);

        //maximize window
        browser.navigate().to(BASE_URL + "/login");

        browser.manage().window().maximize();

        loginPage = PageFactory.initElements(browser, LoginPage.class);

        homePage = PageFactory.initElements(browser, HomePage.class);

        predefinedExamsPage = PageFactory.initElements(browser, PredefinedExamsPage.class);

    }

    @Transactional
    @Rollback(true)
    @Test
    public void testPressPredefinedExams() throws InterruptedException {

        loginPage.ensureIsDisplayedEmail();
        loginPage.getEmail().sendKeys("pa2@gmail.com");
        loginPage.getPassword().sendKeys("123123");
        loginPage.ensureIsVisibleLoginBtn();

        loginPage.getLoginBtn().click();
        loginPage.ensureIsNotVisibleLoginBtn();

        homePage.ensureIsDisplayedPredefined();
        homePage.getPredefinedExams().click();

        predefinedExamsPage.ensureIsDisplayedPredefinedExams();

        List<WebElement> tableBeforeSchedule = predefinedExamsPage.getTablePredefinedExams().findElements(By.tagName("tr"));
        browser.findElement(By.cssSelector(".trs td:last-child")).click();
        predefinedExamsPage.ensureIsDisplayedPredefinedExams();
        Thread.sleep(7000);

        List<WebElement> tableAfterSchedule = predefinedExamsPage.getTablePredefinedExams().findElements(By.tagName("tr"));

        assertEquals(tableBeforeSchedule.size() - 1, tableAfterSchedule.size());

    }

    @Transactional
    @Rollback(true)
    @Test
    public void testScheduleRoomForExam() throws InterruptedException {

        loginPage.ensureIsDisplayedEmail();
        loginPage.getEmail().sendKeys("ca@gmail.com");
        loginPage.getPassword().sendKeys("123123");
        loginPage.ensureIsVisibleLoginBtn();

        loginPage.getLoginBtn().click();
        loginPage.ensureIsNotVisibleLoginBtn();
        Thread.sleep(5000);


        homePage.ensureIsDisplayedRequests();
        homePage.getRequests().click();

        homePage.ensureIsDisplayedExamRequests();
        homePage.getExamRequests().click();

        homePage.ensureIsDisplayedRequestsExamTable();
        homePage.ensureIsScheduleBtnDisplayed();
        List<WebElement> tableBeforeSchedule = homePage.getExamRequestsTable().findElements(By.tagName("tr"));
        Thread.sleep(5000);

        browser.findElement(By.id("req6")).click();

        Thread.sleep(5000);

        browser.findElement(By.id("room2")).click();

        Thread.sleep(5000);
        homePage.ensureIsScheduleBtnVisible();
        browser.findElement(By.id("btnSchedule")).click();
        Thread.sleep(5000);

        homePage.ensureIsDisplayedRequests();
        homePage.getRequests().click();

        homePage.ensureIsDisplayedExamRequests();
        homePage.getExamRequests().click();

        List<WebElement> tableAfterSchedule = homePage.getExamRequestsTable().findElements(By.tagName("tr"));
        assertEquals(tableBeforeSchedule.size() - 1, tableAfterSchedule.size());

    }

    @AfterMethod
    public void tearDown() {
        browser.close();
    }
}
