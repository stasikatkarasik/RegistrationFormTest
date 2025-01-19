package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Alla");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("email@email.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("7981759062");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("2001");
        $(by("aria-label","Choose Monday, January 15th, 2001")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("photo_1.png");
        $("#currentAddress").setValue("Moscow, Some-street, 19");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();



        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("Alla Test"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("email@email.co"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("Female"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("7981759062"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("15 January,2001"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("English"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("Music"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("photo_1.png"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("Moscow, Some-street, 19"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("Haryana Karnal"));


    }




}