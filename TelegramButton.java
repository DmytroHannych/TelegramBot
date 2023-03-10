package TelegramBot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class TelegramButton {
  private static final InlineKeyboardButton GET_INFO_BUTTON = new InlineKeyboardButton("Отримати Інфо");
  private static final InlineKeyboardButton GET_SETTINGS_BUTTON = new InlineKeyboardButton("Налаштування");
  private static final InlineKeyboardButton COUNT_BUTTON = new InlineKeyboardButton("Кільеість з-ків після ,");
  private static final InlineKeyboardButton BANKS_BUTTON  = new InlineKeyboardButton("Банк");
  private static final InlineKeyboardButton CURRENCY_BUTTON = new InlineKeyboardButton("Валюта");
  private static final InlineKeyboardButton TIME_BUTTON = new InlineKeyboardButton("Час сповіщення");
  private static final InlineKeyboardButton BUTTON_2 = new InlineKeyboardButton("2");
  private static final InlineKeyboardButton BUTTON_3 = new InlineKeyboardButton("3");
  private static final InlineKeyboardButton BUTTON_4 = new InlineKeyboardButton("4");
  public static final InlineKeyboardButton MONO_BUTTOM = new InlineKeyboardButton("Монобанк");
  private static final InlineKeyboardButton PRIVATE_BUTTON = new InlineKeyboardButton("Приват банк");
  private static final InlineKeyboardButton NBU_BUTTON = new InlineKeyboardButton("НБУ");
  private static final InlineKeyboardButton EUR_BUTTON = new InlineKeyboardButton("EUR");
  private static final InlineKeyboardButton USD_BUTTON = new InlineKeyboardButton("USD");

  public static void initKeyboard(){
      GET_INFO_BUTTON.setCallbackData("Отримати Інфо");
      GET_SETTINGS_BUTTON.setCallbackData("Налаштування");
      COUNT_BUTTON.setCallbackData("Кільеість з-ків після ,");
      BANKS_BUTTON.setCallbackData("Банк");
      CURRENCY_BUTTON.setCallbackData("Валюта");
      TIME_BUTTON.setCallbackData("Час сповіщення");
      BUTTON_2.setCallbackData("2");
      BUTTON_3.setCallbackData("3");
      BUTTON_4.setCallbackData("4");
      MONO_BUTTOM.setCallbackData("Монобанк");
      PRIVATE_BUTTON.setCallbackData("Приват банк");
      NBU_BUTTON.setCallbackData("НБУ");
      EUR_BUTTON.setCallbackData("EUR");
      USD_BUTTON.setCallbackData("USD");
  }

   public static InlineKeyboardMarkup startMarkUp(){
       List<InlineKeyboardButton> starts = List.of(GET_INFO_BUTTON);
       List<InlineKeyboardButton> settings = List.of(GET_SETTINGS_BUTTON);
     List<List<InlineKeyboardButton>> rowLine = List.of(starts,settings);
       InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
       markupInline.setKeyboard(rowLine);
       return markupInline;
   }

   public static InlineKeyboardMarkup settingsMarkUp(){
    List<InlineKeyboardButton> count = List.of(COUNT_BUTTON);
    List<InlineKeyboardButton> currency = List.of(CURRENCY_BUTTON);
    List<InlineKeyboardButton> bank = List.of(BANKS_BUTTON);
    List<InlineKeyboardButton> timeOut = List.of(TIME_BUTTON);
    List<List<InlineKeyboardButton>> rowLine = List.of(count, currency, bank, timeOut);
       InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
       markupInline.setKeyboard(rowLine);
       return markupInline;
  }

  public static InlineKeyboardMarkup setFloatPoint(){
      List<InlineKeyboardButton> two = List.of(BUTTON_2);
      List<InlineKeyboardButton> three = List.of(BUTTON_3);
      List<InlineKeyboardButton> four = List.of(BUTTON_4);
      List<List<InlineKeyboardButton>> rowLine = List.of(two, three, four);
      InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
      markupInline.setKeyboard(rowLine);
      return  markupInline;
  }
  public static InlineKeyboardMarkup setBank(){
      List<InlineKeyboardButton> nbu = List.of(NBU_BUTTON);
      List<InlineKeyboardButton> monoBank = List.of(MONO_BUTTOM);
      List<InlineKeyboardButton> privateBank = List.of(PRIVATE_BUTTON);
      List<List<InlineKeyboardButton>> rowLine = List.of(nbu, monoBank, privateBank);
      InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
      markupInline.setKeyboard(rowLine);
      return  markupInline;
  }

public static InlineKeyboardMarkup setCurrency(){
      List<InlineKeyboardButton> uero = List.of(EUR_BUTTON);
      List<InlineKeyboardButton> usd = List.of(USD_BUTTON);
    List<List<InlineKeyboardButton>> rowLine = List.of(uero, usd);
    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
    markupInline.setKeyboard(rowLine);
    return  markupInline;
  }

  public static ReplyKeyboardMarkup timeOut(){
      ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();;

      replyKeyboardMarkup.setResizeKeyboard(true);
      replyKeyboardMarkup.setOneTimeKeyboard(true);

      ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();

      KeyboardRow firstRow = new KeyboardRow();
      KeyboardRow secondRow = new KeyboardRow();
      KeyboardRow thirdRow = new KeyboardRow();
      KeyboardRow lastRow = new KeyboardRow();
      keyboardRows.add(firstRow);
      keyboardRows.add(secondRow);
      keyboardRows.add(thirdRow);
      keyboardRows.add(lastRow);

      firstRow.add(new KeyboardButton("9"));
      firstRow.add(new KeyboardButton("10"));
      firstRow.add(new KeyboardButton("11"));
      secondRow.add(new KeyboardButton("12"));
      secondRow.add(new KeyboardButton("13"));
      secondRow.add(new KeyboardButton("14"));
      thirdRow.add(new KeyboardButton("15"));
      thirdRow.add(new KeyboardButton("16"));
      thirdRow.add(new KeyboardButton("17"));
      thirdRow.add(new KeyboardButton("18"));
      thirdRow.add(new KeyboardButton("сповіщення вимкнено"));
      replyKeyboardMarkup.setKeyboard(keyboardRows);
      return replyKeyboardMarkup;
  }
}
