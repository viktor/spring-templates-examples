package com.example;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
    List<Spot> spots = new ArrayList<>();
    HashMap<Integer, Vehicle> assigments = new HashMap<>();

    public List<Spot> addSpot(Integer number, SpotType spotType){
        spots.add(new Spot(number, spotType));
        return spots;
    }

    public void assign(Integer spotNumber, Vehicle vehicle){
        Long regulars = spots.stream().filter(s -> s.getType().equals(SpotType.REGULAR)).count();
        Long compacts = spots.stream().filter(s -> s.getType().equals(SpotType.COMPACT)).count();
        boolean spotsAvailable = regulars != 0 && compacts != 0;

        // any motorcycle / car should be able to park
        if(spotsAvailable){
            if(vehicle.getClass() == Car.class || vehicle.getClass() == Motorcycle.class){
                assigments.put(findAnySpotNumber(vehicle, regulars.intValue(), compacts.intValue()), vehicle);
            }else if(vehicle.getClass() == Van.class){
                List<Integer> vanSpotNos = findVanSpotNumbers(vehicle, regulars.intValue());
                for (Integer spotNo: vanSpotNos){
                    assigments.put(spotNo, vehicle);
                }
            }
        }
    }

    public void removeAssignedVehicle(Integer spotNumber){
        Set<Integer> assignedSpotNumbers = assigments.keySet();
        boolean exists = assignedSpotNumbers.stream().filter(
                s -> s.equals(spotNumber)).findAny().isPresent();

        if(exists){
            assigments.remove(spotNumber);
        }
    }

    public HashMap<Integer, Vehicle> getAssigments() {
        return assigments;
    }

    private Integer findAnySpotNumber(Vehicle vehicle, Integer regulars, Integer compacts) {
        Integer spotNumber = null;
        Set<Integer> assignedSpotNumbers = assigments.keySet();

        if(vehicle.getClass() == Car.class || vehicle.getClass() == Motorcycle.class){
            if(compacts > 0){
                Optional<Spot> spot = findSpot(assignedSpotNumbers, SpotType.COMPACT);
                return spot.isPresent() ? spot.get().getNumber() : null;
            }else if(regulars > 0){
                Optional<Spot> spot = findSpot(assignedSpotNumbers, SpotType.REGULAR);
                return spot.isPresent() ? spot.get().getNumber() : null;
            }
        }

        return spotNumber;
    }

    private Optional<Spot> findSpot(Set<Integer> assignedSpotNumbers, SpotType spotType) {
        try{
            return spots.stream().filter(s ->
                    assignedSpotNumbers.stream().filter(assigned ->
                            !assigned.equals(s) && s.getType().equals(spotType)).findAny().isPresent()
            ).findAny();
        }catch (Exception e){
            System.out.println("No spots available " + e.getMessage());
            return Optional.empty();
        }
    }

    private List<Integer> findVanSpotNumbers(Vehicle vehicle, Integer regulars){
        List<Integer> spotNumber = new ArrayList<>();
        Set<Integer> assignedSpotNumbers = assigments.keySet();

        if (vehicle.getClass() == Van.class && regulars > 2){
            List<Integer> vanSpots = findVanSpots(assignedSpotNumbers);

            return spotNumber;
        }

        return spotNumber;
    }

    private List<Integer> findVanSpots(Set<Integer> assignedSpotNumbers) {
        List<Integer> vanSpots = new ArrayList<>();

        try{
            for (Spot spot: spots) {
                if(spot.getType().equals(SpotType.REGULAR)){
                    boolean isAssigned = assignedSpotNumbers.stream().filter(s ->
                            spot.getNumber().equals(s)).findAny().isPresent();
                    if(!isAssigned){
                        vanSpots.add(spot.getNumber());
                    }
                }
            }

            return vanSpots;
        }catch (Exception e){
            System.out.println("No spots available " + e.getMessage());
            return vanSpots;
        }
    }



    public static class Car extends Vehicle{
        public Car(String vin, String model) {
            super(vin, model);
        }
    }

    public static class Motorcycle extends Vehicle {
        public Motorcycle(String vin, String model) {
            super(vin, model);
        }
    }

    public static class Van extends  Vehicle {
        public Van(String vin, String model) {
            super(vin, model);
        }
    }

    public static class Spot{
        private Integer number;
        private SpotType type;

        public Spot() { }

        public Spot(Integer number, SpotType type) {
            this.number = number;
            this.type = type;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public SpotType getType() {
            return type;
        }

        public void setType(SpotType type) {
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Spot spot = (Spot) o;
            return Objects.equals(number, spot.number) &&
                    type == spot.type;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }

    public static class Vehicle{
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
