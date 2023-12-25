package com.example.assignment3;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vendor_table")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vendorId;

    private String name;

    private Double latitude;

    private Double longitude;

    private Boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_wallet_id")
    private Wallet storeWallet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_wallet_id")
    private Wallet personalWallet;

}
