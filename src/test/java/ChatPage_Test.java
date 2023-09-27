import extensions.AppiumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.StartPage;

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
    @DisplayName("При нажатии нв вкладке 'Chat'  кнопки 'Upgrade To Pro', открывается соответствующая страница ")
    public void openUpgradeToProPageTest(){
        new StartPage()
                .open()
                .clickStartPages()
                .clickOkButton()
                .openingChatPage()
                .clickUnlockPremium();
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

