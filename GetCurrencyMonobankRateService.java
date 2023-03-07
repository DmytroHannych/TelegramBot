package TelegramBot;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static TelegramBot.Currency.*;

public class GetCurrencyMonobankRateService implements GetCurrencyBankRateService {
    private static final String URL = "https://api.monobank.ua/bank/currency";
    private static Map<Integer, Currency> codeCurr = Map.of(
            980, UAH,
            840, USD,
            978, EUR
    );

    @Override
    public List<CurrencyRateDto> getCurrencyRate() throws IOException {
        try {
            String responce = Jsoup.connect(URL).ignoreContentType(true).get().body().text();
            List<CurrencyRateMonobankResponceDto> monobankResponceDtos = convertResponceToList(responce);
            return monobankResponceDtos.stream()
                    .filter(item -> codeCurr.containsKey(item.getCurrencyCodeA())
                            && codeCurr.containsKey(item.getCurrencyCodeB())
                            && item.getCurrencyCodeB().equals(980)
                    )
                    .map(item -> new CurrencyRateDto(
                            codeCurr.get(item.getCurrencyCodeA()),
                            BankName.MONOBANK,
                            item.getRateBuy(),
                            item.getRateSell()
                    ))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }}

        private List<CurrencyRateMonobankResponceDto> convertResponceToList (String responce){
            Type type = TypeToken.getParameterized(List.class, CurrencyRateMonobankResponceDto.class).getType();
            Gson gson = new Gson();
            return gson.fromJson(responce, type);
        }
    }

