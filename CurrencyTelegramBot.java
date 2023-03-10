package TelegramBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import com.vdurmont.emoji.EmojiParser;
import java.text.DecimalFormat;
import java.util.List;

import static TelegramBot.TelegramButton.MONO_BUTTOM;


public class CurrencyTelegramBot extends TelegramLongPollingBot implements BotCommands {
    private static GetCurrencyBankRateService BANK = new GetCurrencyPrivateRateService();
    private static DecimalFormat df = new DecimalFormat();
    private static String time = "9";

    String emoji = EmojiParser.parseToUnicode("✅");

    @Override
    public String getBotUsername() {

        return "CurrencyMyTelegrambot";
    }

    @Override
    public String getBotToken() {
        return "6289137638:AAEwfPb21lilO2l7dZHOWLuW1Ce8s5qNzms";
    }


    @Override
    public void onUpdateReceived(Update update) {
        String reseive;
        long chatId = 0;
        String userName = null;
        if (update.hasMessage()) {
            chatId = update.getMessage().getChatId();
            userName = update.getMessage().getFrom().getFirstName();

            if (update.getMessage().hasText()) {
                reseive = update.getMessage().getText();
                botAnswers(reseive, chatId, userName);
            }
        } else if (update.hasCallbackQuery()) {
            chatId = update.getCallbackQuery().getMessage().getChatId();
            userName = update.getCallbackQuery().getFrom().getFirstName();
            reseive = update.getCallbackQuery().getData();
            botAnswers(reseive, chatId, userName);
        }
    }

    public CurrencyTelegramBot() {
        TelegramButton.initKeyboard();
        try {
            this.execute(new SetMyCommands(LIST_OF_COMMANDS, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void startBot(long chatId, String userName) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Привіт, " + userName + " Цей бот допоможе відслідковувати актуальні курси валют");
        message.setReplyMarkup(TelegramButton.startMarkUp());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void getInfo(long chatId, List<CurrencyRateDto> text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text.toString());
        message.setReplyMarkup(TelegramButton.startMarkUp());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void setSettings(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Налаштування");
        message.setReplyMarkup(TelegramButton.settingsMarkUp());
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void setBank(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Обери банк");
        message.setReplyMarkup(TelegramButton.setBank());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void setCurrency(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Обрери валюту");
        message.setReplyMarkup(TelegramButton.setCurrency());
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private void setFloatPoint(long chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Обери кількість знаків після ',' ");
        message.setReplyMarkup(TelegramButton.setFloatPoint());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private void returnToMenu(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("ви обрали " + text);
        message.setReplyMarkup(TelegramButton.startMarkUp());
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void setTime(long chatId, String time){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Оберіть час оповіщення:" +
                "зараз вибрано " + time);
        message.setReplyMarkup(TelegramButton.timeOut() );
        try {
            execute(message);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
    private void botAnswers(String receivedMes, long chatId, String userName) {
        switch (receivedMes) {
            case "/start":
                startBot(chatId, userName);
                break;
            case "Налаштування":
                setSettings(chatId);
                break;
            case "Банк":
                setBank(chatId);
                break;
            case "Кільеість з-ків після ,":
                setFloatPoint(chatId);
                break;
            case "Валюта":
                setCurrency(chatId);
                break;
            case "Час сповіщення":
                setTime(chatId,time);
                break;
            case "2":
                returnToMenu(chatId, "2 знаки");
                df = new DecimalFormat("#0.00");
                break;
            case "3":
                returnToMenu(chatId, "3 знаки");
                df = new DecimalFormat("#0.000");
                break;
            case "4":
                returnToMenu(chatId, "4 знаки");
                df = new DecimalFormat("#0.0000");
                break;
            case "Приват банк":
                returnToMenu(chatId, "Приват Банк");
                BANK =new GetCurrencyPrivateRateService();
                break;
            case "Монобанк":

                returnToMenu(chatId, "Монобанк");
                BANK = new GetCurrencyMonobankRateService();
                break;
            case "НБУ":
                returnToMenu(chatId, "НБУ");
                BANK = new GetCurrencyNBURateService();
                break;
            case "9":
            case "10":
            case"11":
            case"12":
            case"13":
            case"14":
            case"15":
            case"16":
            case"17":
            case"18":time = receivedMes;
                returnToMenu(chatId,time);
                break;
            case "відключити сповіщення":
                time = "сповіщення вимкнено";
                returnToMenu(chatId,time);
                break;
            case "Отримати Інфо":
                List<CurrencyRateDto> answer = BANK.getCurrencyRate("USD", df);
                getInfo(chatId, answer);
                break;
                default:
                break;
        }
    }
}
