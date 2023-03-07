package TelegramBot;

import java.io.IOException;

public class TestBot {
    public static void main(String[] args) throws IOException {
       GetCurrencyBankRateService getCurrencyBankRateService = new GetCurrencyPrivateRateService();
        System.out.println("getCurrencyBankRateService.getCurrencyRate() = " + getCurrencyBankRateService.getCurrencyRate());
    }
}
