package chudo.skins.skinstradetable.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
