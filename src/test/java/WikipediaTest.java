import com.codeborne.selenide.Configuration;
import data.Lang;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Tag("Web")
public class WikipediaTest {
    @BeforeAll
    void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
    }
    @EnumSource(Lang.class)
    @ParameterizedTest
    void mainPageHasCorrectWelcomeInscription() {
        open("https://wikipedia.org");
        $$(".central-featured-lang a").find(text(Lang.name)).click();
        $("#main-page-header-title").shouldHave(text(Lang.description));


    }
}
