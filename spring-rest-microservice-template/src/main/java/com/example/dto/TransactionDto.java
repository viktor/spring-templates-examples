package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TransactionDto {

    private String amount;
    private String transactionType;
    private String destinationAccountId = null;

}
