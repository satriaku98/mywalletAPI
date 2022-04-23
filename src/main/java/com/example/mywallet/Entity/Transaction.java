package com.example.mywallet.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "trx_transaction")
public class Transaction {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "transaction_id")
    private String id;
    private String wallet_id;
    private String user_id;
    private String target;
    private Integer amount;

    public Transaction(String id, String wallet_id,String user_id, String target, Integer balance) {
        this.id = id;
        this.wallet_id = wallet_id;
        this.user_id = user_id;
        this.target = target;
        this.amount = amount;
    }
}
