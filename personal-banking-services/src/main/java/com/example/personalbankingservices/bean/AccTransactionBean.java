package com.example.personalbankingservices.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccTransactionBean {

    private Integer sourceAccountId;
    private Integer destAccountId;
    private Double amount;


}
