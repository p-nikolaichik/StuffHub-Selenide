package io.stuffhub.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.stuffhub.test.company.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.FileDownloadMode.PROXY;

public class TestClass {

    HomePage homePage;
    CompanyPage companyPage;
    SearchPage searchPage;
    MyCompanyPage myCompanyPage;
    DocumentsPage documentsPage;

    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.baseUrl = "http://staffhub.pstlabs.by/";
        Configuration.fileDownload = PROXY;
        ChromeDriverManager.getInstance().setup();
        WebDriverRunner.getAndCheckWebDriver().manage().window().maximize();
    }

    @BeforeClass
    public void loginTest() {
        companyPage = new HomePage().openLoginPage().login("eugene.astashevich@gmail.com", "pass");
    }

    @Test(dataProvider = "searchTests")
    public void testSearch(String skill) {
        searchPage = CompanyPage.openSearchPage();
        Assert.assertTrue(searchPage.addSkill(skill).searchProfile().checkResultOfSearching());
    }


    @Test(dataProvider = "arrayWithCompanyInfo")
    public void editCompanyInfoTest(String companyInfo) {
        myCompanyPage = CompanyPage.openMyCompanyPage();
        String[] info = companyInfo.split("/");
        myCompanyPage.openEditCompanyPage().setCompanyInfo(info);
    }

    @Test
    public void savePDF() {
        documentsPage = CompanyPage.openDocumentsPage();
        documentsPage.saveDocument();
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

    @DataProvider(name = "arrayWithCompanyInfo")
    public Object[][] createDataCompanyInfo() {
        return new Object[][] {
                {"Adhoc/adhoc.by/irina.chakur@adhoc.by/(+375) 25 123-45-67/г.  " +
                        "Минск, ул. Ленина 50/2013/20/18/IT сфера/Разработка програмного обеспечения под заказ"},
        };
    }




















}
