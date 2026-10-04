package chudo.skins.skinstradetable.dto;

import java.math.BigDecimal;

public class WalletCreateDto {
    private String walletName;

    private String walletDescription;

    private BigDecimal walletTotalAmount;

    // геттеры/сеттеры
    public String getWalletName() {
        return walletName;
    }

    public void setWalletName(String walletName) {
        this.walletName = walletName;
    }

    public String getWalletDescription() {
        return walletDescription;
    }

    public void setWalletDescription(String walletDescription) {
        this.walletDescription = walletDescription;
    }

    public BigDecimal getWalletTotalAmount() {
        return walletTotalAmount;
    }

    public void setWalletTotalAmount(BigDecimal walletTotalAmount) {
        this.walletTotalAmount = walletTotalAmount;
    }
}
