package TelegramBot;

import java.math.BigDecimal;

public class CurrencyRateDto {
   private Currency currency;
   private BankName bankName;
   private BigDecimal buyRate;
   private BigDecimal saleRate;

   public CurrencyRateDto() {
   }

   public CurrencyRateDto(Currency currency, BankName bankName, BigDecimal buyRate, BigDecimal saleRate) {
      this.currency = currency;
      this.bankName = bankName;
      this.buyRate = buyRate;
      this.saleRate = saleRate;
   }

   public Currency getCurrency() {
      return currency;
   }

   public void setCurrency(Currency currency) {
      this.currency = currency;
   }

   public BankName getBankName() {
      return bankName;
   }

   public void setBankName(BankName bankName) {
      this.bankName = bankName;
   }

   public BigDecimal getBuyRate() {
      return buyRate;
   }

   public void setBuyRate(BigDecimal buyRate) {
      this.buyRate = buyRate;
   }

   public BigDecimal getSaleRate() {
      return saleRate;
   }

   public void setSaleRate(BigDecimal saleRate) {
      this.saleRate = saleRate;
   }

   @Override
   public String toString() {
      return "CurrencyRateDto{" +
              "currency=" + currency +
              ", bankName=" + bankName +
              ", buyRate=" + buyRate +
              ", saleRate=" + saleRate +
              '}';
   }
}
