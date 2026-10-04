package chudo.skins.skinstradetable.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WalletDto {
    private int id;

    private String walletName;

    private String walletDescription;

    private double walletTotalAmount;

    public WalletDto(
            int id,
            String walletName,
            String walletDescription,
            double walletTotalAmount) {
        this.id = id;
        this.walletName = walletName;
        this.walletDescription = walletDescription;
        this.walletTotalAmount = walletTotalAmount;
    }
}
