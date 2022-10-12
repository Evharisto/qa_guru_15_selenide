package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @DisplayName("Github search selenide repository test")
    @Test
    public void selenideSearchTest() {
        open("https://github.com/");
        $(".header-search-input").setValue("selenide").submit();
        $$(".repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

     // $("[data-test-selector=nav-search-input]").setValue("selenide").submit();
        //ARRANGE - подготовка системы к состоянию, которое будет проверять
        //ACT - какие-то действия (желательно ровно одно)
        //ASSERT - сами проверки (желательно одна логическая проверка). Для селенида всегда (почти) should. AssertTrue и проч. стараться не использовать в работе с селенидом.

        //ARRANGE
        //ACT
        //ASSERT
        //ACT
        //ASSERT
        //ACT
        //ASSERT
    }

    @DisplayName("Checking that first contributor is Andrei Solntsev")
    @Test
    public void firstContributorCheckTest() {
        open("https://github.com/selenide/selenide");
        $(".Layout-sidebar").$(byText("Contributors"))
                .ancestor(".BorderGrid-cell").$$("ul li")
                .first().hover();
        $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
        //Для заморозки исчезающих элементов при просмотре кода выбрать вкладку Sources и нажать F8 + Ctrl + \ или в консоль setTimeout(function(){debugger},3000);

    }
}
