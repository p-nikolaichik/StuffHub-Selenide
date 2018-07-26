package io.stuffhub.test.company;

import javax.xml.stream.events.Attribute;
import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DocumentsPage {

    public DocumentsPage() {
        $(byXpath("//div[@class='txt-caption']")).shouldBe(visible);
    }

    public void saveDocument() {
        File file = null;
        try {
            file = $(byXpath("//button[count(@disabled)=0 and (@class=\"ctrl ctrl--green\")]")).download();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        file.getAbsolutePath();
        file.exists();
    }

}
