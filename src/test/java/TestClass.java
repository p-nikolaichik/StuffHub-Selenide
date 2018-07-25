import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClass {

    HomePage homePage;
    CompanyPage companyPage;
    SearchPage searchPage;

    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://staffhub.pstlabs.by/";
        ChromeDriverManager.getInstance().setup();
        WebDriverRunner.getAndCheckWebDriver().manage().window().maximize();
    }

    @BeforeClass
    public void loginTest() {
        companyPage = new HomePage().openLoginPage().login("eugene.astashevich@gmail.com", "pass");
    }

    @Test
    public void openSearchPage() {
        searchPage = CompanyPage.openSearchPage();
    }

    @DataProvider(name = "searchTests")
    public Object[][] createDataForSearch() {
        return new Object[][] {
                { "js"},
//                { " js "},
//                { "Js"},
//                { "js"},
        };
    }

    @Test(dependsOnMethods = "openSearchPage", dataProvider = "searchTests")
    public void testSearch(String skill) {
        Assert.assertTrue(searchPage.addSkill(skill).searchProfile().checkResultOfSearching());
    }





















}
