import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


@DisplayName("Parametrized Tests")
@Tag("Web")
public class ChloeTingTests{
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
    }

    @ValueSource(strings = {
            "2023 Hourglass Challenge", "2023 Summer Shred Challenge", "2023 1 Min Challenge"}
    )
    @ParameterizedTest(name = "Training set {0} contains blocks with video")
    @Tag("Blocker")
    void chloeTingTrainingSetsCointainVideos(String trainingSetName) {
        open("https://chloeting.com/");
        $(byText(trainingSetName)).click();
        $$(".dVbrf").shouldHave(CollectionCondition.sizeGreaterThan(1));
    }
    @Disabled
    @Test
    @DisplayName("Main page has SignIn button")
    void successfulSearchJUnitTest() {
        open("https://chloeting.com/");
        $("header").shouldHave(text("Sign Up"));
    }


}

