package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import elements.ABasePage;
import org.openqa.selenium.By;

public class ChatPage extends ABasePage<ChatPage> {

    private SelenideElement unblockPremiumButton =$(By.xpath("//android.widget.TextView[contains(@text,'Unlock Premium')]"));
    private SelenideElement openUpgradeToProPage =$("[text='Upgrade To Pro']");
    private SelenideElement messageHello = $("[text='Hello\uD83D\uDE03']");
    private SelenideElement editText = $("[text='Type a message...']");

    private SelenideElement sendButton = $("[content-desc='send']");

    private  String text = "";
    public UpgradeToProPage clickUnlockPremium(){
        unblockPremiumButton.shouldBe(Condition.enabled);
        unblockPremiumButton.click();
        openUpgradeToProPage.shouldBe(Condition.visible);
        return new UpgradeToProPage();
    }
    public ChatPage checkHelloMessage(){
        messageHello.shouldBe(Condition.visible);
        return this;
    }
    public ChatPage inputMessage(String text){
        this.text = text;
        editText.shouldBe(Condition.enabled);
        editText.sendKeys(text);
        return this;
    }
    public ChatPage clickSendMessageButton(){
        sendButton.shouldBe(Condition.enabled);
        sendButton.click();
        $("[text='"+text+"']").shouldBe(Condition.visible);
        return this;
    }
    public ChatPage checkResponseMessage(String text){
        $(By.xpath("//android.widget.TextView[contains(@text,'"+text+"')]")).shouldBe(Condition.visible);
        return this;
    }
}
