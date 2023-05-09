package com.example.personalbankingservices.Entity;

import com.example.personalbankingservices.Enum.CustomerTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_phone", nullable = false)
    private String customerPhone;

    @Column(name = "customer_email", nullable = false)
    private String customerEmail;

    @Column(name = "date_became_customer", nullable = false)
    private Date dateBecameCustomer;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "other_details")
    private String otherDetails;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_types_code", nullable = false)
    private CustomerTypes customerTypesCode;

}
