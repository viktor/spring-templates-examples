package com.example.aggregator;

import com.example.dto.TransactionDto;
import com.bank.util.BankLogger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExampleAggregatorTest extends Mockito {

    @Mock
    private RestTemplate rest;
    @Mock
    private ResponseEntity resp;
    @InjectMocks
    private ExampleAggregator aggregator;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        when(rest.postForEntity(anyString(), any(), any(), anyInt())).thenReturn(resp);
        when(resp.getBody()).thenReturn(new TransactionDto("100","DEPOSIT", null));
    }

    @Test
    public void transaction(){
        String amount = null;
        TransactionDto dto = aggregator.transaction(amount, "username");
        BankLogger.info("dto %s ", dto);
    }

}
