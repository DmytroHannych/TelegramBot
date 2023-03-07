package TelegramBot;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;


public class GetCurrencyPrivateRateService implements GetCurrencyBankRateService {

 private static final String URL = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=11";
    @Override
    public List<CurrencyRateDto> getCurrencyRate() {
        try {
            String responce = Jsoup.connect(URL)
                    .ignoreContentType(true)
                    .get()
                    .body()
                    .text();
            List<CurrencyRatePrivateResponceDto> responceDtos = convertResponceToList(responce);
            return responceDtos.stream()
                    .map(dto -> new CurrencyRateDto(dto.getCcy(),BankName.PRIVATEBANK, dto.getBuy(), dto.getSale()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private List<CurrencyRatePrivateResponceDto> convertResponceToList(String responce){
        Type type = TypeToken.getParameterized(List.class, CurrencyRatePrivateResponceDto.class).getType();
        Gson gson = new Gson();
        return gson.fromJson(responce, type);
    }
}
