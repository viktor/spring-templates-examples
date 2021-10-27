package com.example.aggregator;

import com.example.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Victor
 * Calls transaction service to add the initial balance to account.
 *
 */
@Service
public class ExampleAggregator {
    @Autowired
    private RestTemplate rest;
    private final String endpoint = "http://localhost:9000/api/account/{username}/transaction";

    public TransactionDto transaction(String amount, String username){
        TransactionDto dto = new TransactionDto(amount, "DEPOSIT", null);
        ResponseEntity<TransactionDto> resp = rest.postForEntity(endpoint, dto, TransactionDto.class, username);
        return resp.getBody();
    }

}
