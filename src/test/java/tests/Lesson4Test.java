package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Lesson4Test {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void SelenideGitTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".wiki-rightbar").$(byText("Show 3 more pages…")).click();
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
        $(".wiki-rightbar").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("""
        @ExtendWith({SoftAssertsExtension.class})
        class Tests {
            @Test
            void test() {
                Configuration.assertionMode = SOFT;
                open("page.html");

                $("#first").should(visible).click();
                $("#second").should(visible).click();
            }
        }"""));

    }

}
