package TelegramBot;

import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

public class TestBot {
    public static void main(String[] args) throws IOException {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new CurrencyTelegramBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


}
