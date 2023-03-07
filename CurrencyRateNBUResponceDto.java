package TelegramBot;

import java.math.BigDecimal;

public class CurrencyRateNBUResponceDto {
  private Integer r030;
  private String cc;
  private BigDecimal rate;

    public Integer getR030() {
        return r030;
    }

    public void setR030(Integer r030) {
        this.r030 = r030;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
