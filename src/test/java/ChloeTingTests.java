import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    void chloeTingTrainingSetsCointainVideosTest(String trainingSetName) {
        open("https://chloeting.com/");
        $(byText(trainingSetName)).click();
        $$(".dVbrf").shouldHave(CollectionCondition.sizeGreaterThan(1));
    }

    @CsvSource (value = {
            "2023 Hourglass Challenge | Full Body, Abs & Core, Booty, Arms, Resistance",
            "2023 Summer Shred Challenge | Weight Loss, Full Body",
            "2023 1 Min Challenge | Full Body, Weight Loss, Abs & Core"},
            delimiter = '|'

    )
    @ParameterizedTest(name = "1st Day of training set {0} has description {1}")
    void chloeTingTrainingSetsCointainCorrectVideosTest(String trainingSet, String expectedValue) {
        open("https://chloeting.com/");
        $(byText(trainingSet)).click();
        $(".icon-zap").sibling(0).shouldHave(text(expectedValue));
    }

    @Disabled
    @Test
    @DisplayName("Main page has SignIn button")
    void SignInButtonTest() {
        open("https://chloeting.com/");
        $("header").shouldHave(text("Sign Up"));
    }


}

