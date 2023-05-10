package com.example.personalbankingservices.Entity;

import com.example.personalbankingservices.Enum.AccountTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {

    @Id
    @SequenceGenerator(
            name = "account_sequence",
            sequenceName = "account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "account_sequence"
    )
    @Column(name = "account_id", nullable = false)
    private Integer accountId;

    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(name = "date_opened", nullable = false)
    private Date dateOpened;

    @Column(name = "other_account_details")
    private String otherAccountDetails;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_types_code", nullable = false)
    private AccountTypes accountTypesCode;

    @Column(name = "customer_id", nullable = false, updatable = false, insertable = false)
    private Integer customerId;

    @Column(name = "balance")
    private Double balance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id", updatable = false, insertable = false)

    private Customer customer;



}
