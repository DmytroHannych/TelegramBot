package TelegramBot;

import java.math.BigDecimal;

public class CurrencyRateMonobankResponceDto {
    private Integer currencyCodeA;
    private Integer currencyCodeB;
    private BigDecimal rateBuy;
    private BigDecimal rateSell;

    public Integer getCurrencyCodeA() {
        return currencyCodeA;
    }

    public void setCurrencyCodeA(Integer currencyCodeA) {
        this.currencyCodeA = currencyCodeA;
    }

    public Integer getCurrencyCodeB() {
        return currencyCodeB;
    }

    public void setCurrencyCodeB(Integer currencyCodeB) {
        this.currencyCodeB = currencyCodeB;
    }

    public BigDecimal getRateBuy() {
        return rateBuy;
    }

    public void setRateBuy(BigDecimal rateBuy) {
        this.rateBuy = rateBuy;
    }

    public BigDecimal getRateSell() {
        return rateSell;
    }

    public void setRateSell(BigDecimal rateSell) {
        this.rateSell = rateSell;
    }

    @Override
    public String toString() {
        return "МоноБанк курс " +
                " валюта " + currencyCodeB +
                ", продаж =" + rateBuy +
                ", купівля =" + rateSell;
    }
}

