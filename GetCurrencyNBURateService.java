package TelegramBot;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import module10.JsonTask2;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static TelegramBot.Currency.EUR;
import static TelegramBot.Currency.USD;

public class GetCurrencyNBURateService implements GetCurrencyBankRateService {

    private static final String URL = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";

    private static Map<Integer, Currency > codeCur = Map.of(
            840, USD,
            978, EUR
            );
    @Override
    public List<CurrencyRateDto> getCurrencyRate() throws IOException {
        try {
            String responce = Jsoup.connect(URL).ignoreContentType(true).get().body().text();
            List<CurrencyRateNBUResponceDto> rateNBUResponceDtos = convertResponceToList(responce);
        return rateNBUResponceDtos.stream()
                .filter(item -> codeCur.containsKey(item.getR030()))
                .map(item -> new CurrencyRateDto(
                        codeCur.get(item.getR030()),
                        BankName.NBU,
                        item.getRate(),
                        item.getRate()
                ))
                .collect(Collectors.toList());
    } catch (IOException e) {
            throw new RuntimeException(e);
        }}
    private List<CurrencyRateNBUResponceDto> convertResponceToList (String responce){
        Type type = TypeToken.getParameterized(List.class, CurrencyRateNBUResponceDto.class).getType();
        Gson gson = new Gson();
        return gson.fromJson(responce, type);
    }
}
