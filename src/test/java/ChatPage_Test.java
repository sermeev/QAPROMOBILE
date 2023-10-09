import extensions.AppiumExtension;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.StartPage;

@Epic("ChatPage")
@ExtendWith(AppiumExtension.class)
public class ChatPage_Test {

    @Test
    @DisplayName("При входе в чате отображается сообщение с приветствием")
    public void checkHelloTest(){
        new StartPage()
                .open()
                .clickStartPages()
                .clickOkButton()
                .openingChatPage()
                .checkHelloMessage();
    }
    @Test
    @DisplayName("При нажатии нa вкладке 'Chat'  кнопки 'Upgrade To Pro', открывается соответствующая страница ")
    public void openUpgradeToProPageTest(){
        new StartPage()
                .open()
                .clickStartPages()
                .clickOkButton()
                .openingChatPage()
                .clickUnlockPremium();
        System.out.println(System.getProperty("allure.results.directory"));
    }

    @Test
    @DisplayName("При вводе приветственного сообщения в чат, приходит ответ с именем")
    public void sendMessageHelloTest(){
        new StartPage()
                .open()
                .clickStartPages()
                .clickOkButton()
                .openingChatPage()
                .inputMessage("Hello")
                .clickSendMessageButton()
                .checkResponseMessage("Andy");
    }


}

