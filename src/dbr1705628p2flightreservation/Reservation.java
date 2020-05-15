/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbr1705628p2flightreservation;
import java.util.Date;

/**
 *
 * @author Raghad
 */
public class Reservation {
    // attributs
    private String pnrNO;
    private java.util.Date resevationDate;
    private Flight flight;
    private Passenger[] passenger;
    private static int indexReservation;

    public Reservation(String pnrNO, Date resevationDate, int totalPassenger) {
        this.pnrNO = pnrNO;
        this.resevationDate = resevationDate;
        
    }

    public Reservation(int siz) {
        passenger = new Passenger[siz];
        resevationDate =new Date();   
    }
    
    public String getPnrNO() {
        return pnrNO;
    }

    public void setPnrNO(String pnrNO) {
        this.pnrNO = pnrNO;
    }

    public Date getResevationDate() {
        return resevationDate;
    }

    public void setResevationDate(Date resevationDate) {
        this.resevationDate = resevationDate;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger[] getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger,int index) {
        this.passenger[index] = passenger;
    }

    public static int getIndexReservation() {
        return indexReservation;
    }

    public static void incIndexReservation() {
        indexReservation++;
        
    }
    
}
