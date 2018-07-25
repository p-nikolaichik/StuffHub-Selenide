import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Admin2 on 24.07.2018.
 */
public class CompanyPage {

    private static SelenideElement loginDropdown = $("#dropdownBasic1");

    public CompanyPage() {
        $("div h1").shouldBe(visible);
    }

    public static SearchPage openSearchPage() {
        loginDropdown.click();
        $(by("routerlink", "/company/search")).click();
        return new SearchPage();
    }

    public static MyCompanyPage openMyCompanyPage() {
        loginDropdown.click();
        $(by("routerlink", "/company/cabinet/mycompany")).click();
        return new MyCompanyPage();
    }

    public static MyVacanciesPage openVacanciesPage() {
        loginDropdown.click();
        $(by("routerlink", "/company/cabinet/vacancies")).click();
        return new MyVacanciesPage();
    }

    public static MyCandidatesPage openCandidatePate() {
        loginDropdown.click();
        $(by("routerlink", "/company/cabinet/candidates")).click();
        return new MyCandidatesPage();
    }

    public static DocumentsPage openDocumentsPage() {
        loginDropdown.click();
        $(by("routerlink", "/company/cabinet/docs")).click();
        return new DocumentsPage();
    }
}
