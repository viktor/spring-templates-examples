package com.example;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**

 Design a parking lot using object-oriented principles

 Goals:
 - Your solution should be in Java - if you would like to use another language, please let the interviewer know.
 - Boilerplate is provided. Feel free to change the code as you see fit

 Assumptions:
 - The parking lot can hold motorcycles, cars and vans
 - The parking lot has motorcycle spots, car spots and large spots
 - A motorcycle can park in any spot
 - A car can park in a single compact spot, or a regular spot
 - A van can park, but it will take up 3 regular spots
 - These are just a few assumptions. Feel free to ask your interviewer about more assumptions as needed

 Here are a few methods that you should be able to run:
 - Tell us how many spots are remaining
 - Tell us how many total spots are in the parking lot
 - Tell us when the parking lot is full
 - Tell us when the parking lot is empty
 - Tell us when certain spots are full e.g. when all motorcycle spots are taken
 - Tell us how many spots vans are taking up

 Hey candidate! Welcome to your interview. I'll start off by giving you a Solution class. To run the code at any time, please hit the run button located in the top left corner.

 */
@Service
public class ParkingLot {
    private List<Spot> spots;
    private List<Vehicle> vehicles;

    


    public class Car extends Vehicle{
        public Car(String vin, String model) {
            super(vin, model);
        }
    }

    public class Motorcycle extends Vehicle {
        public Motorcycle(String vin, String model) {
            super(vin, model);
        }
    }

    public class Van extends  Vehicle {
        public Van(String vin, String model) {
            super(vin, model);
        }
    }

    public class Spot{
        private Integer number;
        private SpotType type;
    }

    public class Vehicle{
        private String vin;
        private String model;

        public Vehicle(String vin, String model) {
            if(vin == null || model == null)
                throw new NullPointerException("vin/model can't be null");

            this.vin = vin;
            this.model = model;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vehicle vehicle = (Vehicle) o;
            return Objects.equals(vin, vehicle.vin) &&
                    Objects.equals(model, vehicle.model);
        }

        public String getVin() {
            return vin;
        }

        public void setVin(String vin) {
            this.vin = vin;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
    }

    public enum SpotType {
        REGULAR, COMPACT
    }

}
