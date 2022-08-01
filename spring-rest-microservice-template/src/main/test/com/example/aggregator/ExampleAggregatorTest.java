package com.example.aggregator;

import com.example.dto.TransactionDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static com.example.util.SimpleLogger.info;



public class ExampleAggregatorTest extends Mockito {

    @Mock
    private RestTemplate rest;
    @InjectMocks
    private ExampleAggregator aggregator;

    @Before
    public void setup(){
        ResponseEntity<Object> resp = new ResponseEntity(HttpStatus.OK);
        MockitoAnnotations.initMocks(this);
        when(rest.postForEntity(anyString(), any(), any(), anyInt())).thenReturn(resp);
    }

    @Test
    public void transaction(){
        String amount = null;
        TransactionDto dto = aggregator.transaction(amount, "username");
        info("dto %s ", dto);
    }

}
