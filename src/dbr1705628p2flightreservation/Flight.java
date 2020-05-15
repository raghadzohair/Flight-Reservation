/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbr1705628p2flightreservation;

/**
 *
 * @author Raghad
 */
public class Flight {
    // attributs
    private String flightCode;
    private String cityFrom;
    private String cityTo;
    private int totalSeats;
    private int remSeat;
    private double price;
    private static int indexFlight;
    
    // Constructor with argument
    public Flight(String flightCode, String cityFrom, String cityTo, int totalSeats, int remSeat, double price) {
        this.flightCode = flightCode;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.totalSeats = totalSeats;
        this.remSeat = remSeat;
        this.price = price;
        indexFlight++;
    }
    // Constructor with no arg
    public Flight() {       
        indexFlight++;
    }
    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getRemSeat() {
        return remSeat;
    }

    public void setRemSeat(int remSeat) {
        
        this.remSeat = remSeat;
        
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int getIndexFlight() {
        return indexFlight;
    }
    
    public static void incIndexFlight(int indexFlight) {
        Flight.indexFlight = indexFlight;
    }
    
}
