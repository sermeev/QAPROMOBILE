import extensions.AppiumExtension;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.StartPage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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

    @AfterAll
    public void aftterall() throws IOException {
        System.out.println(System.getProperty("allure.results.directory"));
        try (Stream<Path> paths = Files.walk(Paths.get(System.getProperty("allure.results.directory")))) {
            paths
                .filter(Files::isRegularFile)
                .forEach(System.out::println);
        }
    }


}

