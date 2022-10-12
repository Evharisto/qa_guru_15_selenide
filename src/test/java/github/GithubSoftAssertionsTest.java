package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GithubSoftAssertionsTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @DisplayName("Проверка наличия примера кода для JUnit5 на странице SoftAssertions")
    @Test
    public void examplesAtSoftAssertionsGithubTest() {
        open("https://github.com/");
        $(".header-search-input").setValue("selenide").submit();
        $$(".repo-list li").first().$("a").click();
        $("#wiki-tab").click();
        $("#wiki-pages-box").$(".wiki-more-pages-link").$(".js-wiki-more-pages-link").click();
        $("li.Box-row.wiki-more-pages.px-2.py-2", 1).$("div:nth-child(1)").shouldHave(text("SoftAssertions"));
        $("li.Box-row.wiki-more-pages.px-2.py-2", 1).$("div:nth-child(1)").click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));

    }
}
