package selenidetest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class Selenide1 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {

        //открыть главную страницу
        open("https://github.com");
        //ввести в поиск селенид и нажать энтер
        ($(".header-search-input")).setValue("selenide").pressEnter();

        //кликнуть на первый репозиторий из списка найденных
        $$("ul.repo-list li").first().$("a").click();

        $("nav.js-repo-nav").$("ul li").sibling(4).click();

        $("[placeholder='Find a page…']").setValue("SoftAssertions");

        $(byText("SoftAssertions")).click();

        // cоздаем многострочный литерал

        String JUnit5Example = """
                @ExtendWith({SoftAssertsExtension.class})
                        class Tests {
                            @Test
                            void test() {
                                Configuration.assertionMode = SOFT;
                                open("page.html");

                                $("#first").should(visible).click();
                                $("#second").should(visible).click();
                            }
                        }
                        """;
//проверка: кусок кода о JUnit 5 содержит текст из литерала

        $("#user-content-3-using-junit5-extend-test-class").parent().sibling(0).shouldHave(text(JUnit5Example));
    }
}
