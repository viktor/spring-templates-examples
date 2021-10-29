package com.example;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParkingLotTest {

    @Autowired ParkingLot parkingLot;

    @BeforeClass
    public static void setUp() { }

    @Before
    public void dataSetUp(){
        parkingLot.addSpot(1, ParkingLot.SpotType.COMPACT);
        parkingLot.addSpot(2, ParkingLot.SpotType.COMPACT);
        parkingLot.addSpot(3, ParkingLot.SpotType.COMPACT);
        parkingLot.addSpot(4, ParkingLot.SpotType.COMPACT);
        parkingLot.addSpot(5, ParkingLot.SpotType.COMPACT);
        parkingLot.addSpot(6, ParkingLot.SpotType.REGULAR);
        parkingLot.addSpot(7, ParkingLot.SpotType.REGULAR);
        parkingLot.addSpot(8, ParkingLot.SpotType.REGULAR);
        parkingLot.addSpot(9, ParkingLot.SpotType.REGULAR);
        parkingLot.addSpot(10, ParkingLot.SpotType.REGULAR);
    }

    @Test
    public void findSpots(){
        log("assigments : " + parkingLot.getAssigments());
        parkingLot.assign(1, new ParkingLot.Car("asdasd", "TOYOTA"));
        log("assigments : " + parkingLot.getAssigments());
    }

    void log(String msg){
        System.out.println(msg);
    }

}
