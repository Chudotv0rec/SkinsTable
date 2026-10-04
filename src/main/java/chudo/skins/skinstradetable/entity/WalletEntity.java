package chudo.skins.skinstradetable.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "wallets")
@Getter
@Setter
public class WalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String walletName;

    private String walletDescription;

    private double walletTotalAmount;

    @OneToMany
    private List<TransactionEntity> transactionsList;

    @Override
    public String toString() {
        return "WalletEntity [id=" + id + ", walletName=" + walletName + ", transactionsList=" + transactionsList + "\n";
    }
}
