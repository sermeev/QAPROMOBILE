package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.ABasePage;
import org.openqa.selenium.By;
import java.util.ArrayList;

public class StartPage extends ABasePage<StartPage> {
    private SelenideElement skipButton = $("[text='Skip >']");
    private SelenideElement nextButton = $("[text='Next']");

    private ArrayList<String> startTextList = new ArrayList() {{
            add("Chat to improve your English");
            add("Learn new words and grammar");
            add("7 days FREE");
        }};

    private SelenideElement shouldBeMainPage =$(By.xpath("//android.view.View[@selected='true']"));
    private SelenideElement okButton = $("[text='OK']");

    public StartPage clickNextButton() {
        $(nextButton).click();
        return this;
    }
    public StartPage skipButtonPresent(){
        skipButton.shouldBe(Condition.visible);
        return this;
    }
    public StartPage nextButtonPresent(){
        nextButton.shouldBe(Condition.visible);
        return this;
    }
    public StartPage clickSkipButton() {
        skipButton.click();
        return this;
    }

    public StartPage clickStartPages(){
        startTextList.stream().forEach(text->{
            $("[text='"+text+"']").shouldBe(Condition.visible);
            if(startTextList.indexOf(text)!=(startTextList.size()-1))
                clickNextButton();
            else
                clickSkipButton();
        });
        return this;
    };

    public StartPage clickOkButton() {
        $(okButton).click();
        return this;
    }
    public ChatPage openingChatPage(){
        shouldBeMainPage.should(Condition.visible);
        return new ChatPage();
    }


}
