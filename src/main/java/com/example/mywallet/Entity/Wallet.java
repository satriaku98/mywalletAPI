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
@Table(name = "mst_wallet")
public class Wallet {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "wallet_id")
    private String id;
    private String user_id;
    private Integer balance;

    public Wallet(String id, String user_id, Integer balance) {
        this.id = id;
        this.user_id = user_id;
        this.balance = balance;
    }
}
