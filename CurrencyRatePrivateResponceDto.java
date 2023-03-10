package TelegramBot;

import java.math.BigDecimal;
import java.security.DigestException;

public class CurrencyRatePrivateResponceDto {
    private Currency ccy;
    private Currency base_ccy;
    private BigDecimal buy;
    private BigDecimal sale;

    @Override
    public String toString() {
        return "Приват банк курс" +
                "валюта " + ccy +
                ", продаж = " + buy +
                ", купівля =" + sale;
    }

    public Currency getCcy() {
        return ccy;
    }

    public void setCcy(Currency ccy) {
        this.ccy = ccy;
    }

    public Currency getBase_ccy() {
        return base_ccy;
    }

    public void setBase_ccy(Currency base_ccy) {
        this.base_ccy = base_ccy;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getSale() {
        return sale;
    }

    public void setSale(BigDecimal sale) {
        this.sale = sale;
    }
}
