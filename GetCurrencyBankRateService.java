package TelegramBot;

import java.io.IOException;
import java.util.List;

public interface GetCurrencyBankRateService {
    public List<CurrencyRateDto> getCurrencyRate() throws IOException;
}
