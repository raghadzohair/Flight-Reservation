/*
 * NAME: Raghad Zohair Saudi ID:1705628 SECION: DBR .
 * Program2: FlightReservation.
 * Delivery Date and time: Sunday 18/3/2018 at 11 PM
 */
package dbr1705628p2flightreservation;
import java.io.*;
import java.util.*;

/**
 *
 * @author Raghad
 */
public class DBR1705628P2FlightReservation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws Exception {
        // create the files.
        File inputFile = new File ("input_updated.txt");
        File outputFile = new File ("output.txt");
        if(!inputFile.exists()){
            System.out.println("The File Does not Exists");
            System.exit(0);
        }
        // create object for read and write.
        Scanner inputForRead = new Scanner(inputFile);
        PrintWriter outputForWrite = new PrintWriter(outputFile);
        // inputForRead conut to pnr
        int contPnr =100;
        while(inputForRead.hasNext()){
            // for store numbers and create the objects.
            int TotalNumberOfFlight = inputForRead.nextInt();
            Flight[] flight = new Flight[TotalNumberOfFlight];
            
            int TotalNumberOfPassengers = inputForRead.nextInt();
            Passenger[] passenger = new Passenger[TotalNumberOfPassengers];
            
            int NumberOfBookingRequests = inputForRead.nextInt();
            Reservation [] reservation = new Reservation[NumberOfBookingRequests];
            
            outputForWrite.println("###########################################\r\n"
                    +"\r\n" +"***** Welcome to Flight Reservation System *****\r\n" 
                    +"\r\n" +"###########################################");
            
            while(inputForRead.hasNext()){
                String command = inputForRead.next();
                if(command.equalsIgnoreCase("Add_Flight")){
                    Add_Flight(inputForRead,flight,outputForWrite);  
                }
                else if(command.equalsIgnoreCase("Add_Passenger")){
                    Add_Passenger(inputForRead,passenger,outputForWrite);
                }
                else if(command.equalsIgnoreCase("Make_Booking")){
                    make_Booking(inputForRead,reservation,flight,passenger,contPnr,outputForWrite);
                    contPnr++;
                }
                else if(command.equalsIgnoreCase("Search_Print")){
                    Search_Print(inputForRead, reservation,outputForWrite);
                    
                }
                else if(command.equalsIgnoreCase("Flight_Status")){
                    flight_Status(inputForRead,reservation,outputForWrite);
                    
                }
                else if(command.equalsIgnoreCase("Quit")){
                    outputForWrite.println("\r\nThank you for using the flight booking System, Good Bye!\r\n\r\n");
                    outputForWrite.println("###########################################\r\n");
                    

                }      
            }  
        }
        // to close objects read and write
        inputForRead.close();
        outputForWrite.close();
    }
    
    ///////////// NETHOD TO READ DETAILS OF FLIGHT.
    public static void Add_Flight(Scanner in, Flight[] flight,PrintWriter out){
        // Check if flight details based on the total number of flights available inputForRead the system
        if(Flight.getIndexFlight()<flight.length){            
            // read details
            String code = in.next();
            String cityFrom = in.next();
            String cityTo = in.next();
            int numOfSeats = in.nextInt();
            int remindOfSeats = in.nextInt();
            double price = in.nextInt();
            flight[Flight.getIndexFlight()] = new Flight(code, cityFrom, cityTo, numOfSeats, remindOfSeats, price);
            out.println("\r\nFlight " + code + " Successfully Added");
            out.println("\r\n###########################################");  
        }   
        else{
            out.println("\r\nFlight "+in.next()+" Was not Added");
            out.println("\r\n You exced the maximum number of Flights");
            out.println("\r\n###########################################");
        }
    }
    
    ///////////// NETHOD TO READ DETAILS OF Pssenger.
    public static void Add_Passenger(Scanner in, Passenger[] passenger,PrintWriter out){
        // Check if flight details based on the total number of passenger available inputForRead the system
        if(Passenger.getIndexPassenger()<passenger.length){
            // read details
            String name = in.next();
            int age = in.nextInt();
            String gender = in.next();
            String numOfPhone = in.next();
            passenger[Passenger.getIndexPassenger()] = new Passenger(name, age, gender.charAt(0), numOfPhone);
            out.println("\r\nPssenger " + name + " Successfully Added");
            out.println("\r\n###########################################");
        }
        else{
            out.println("\r\nPassenger "+in.next()+" Was not Added");
            out.println("\r\n You exced the maximum number of Passenger");
            out.println("\r\n###########################################");
            
        }       
    }
    
    ///////////// NETHOD TO READ DETAILS OF Booking.
    public static void make_Booking(Scanner in,Reservation[] reservation, Flight[]flight, Passenger[]passenger,int contPnr,PrintWriter out){
        Date date = new Date();
        String code = in.next();
        int seats = in.nextInt();
        boolean isFindCode =false;
        boolean isFindNamePassenger =false;
        int saveIndexCode=0;
        String pnr =null;
        if(Reservation.getIndexReservation()<reservation.length){
            
            for (int i = 0; i < flight.length; i++) {
                isFindCode =false;
                if(code.equals(flight[i].getFlightCode())){
                    isFindCode =true;
                    saveIndexCode =i;
                    pnr = flight[i].getCityFrom().substring(0, 3).toUpperCase();
                    
                }
            }
            if(isFindCode =true){
                if(flight[saveIndexCode].getRemSeat()>= seats){
                    
                    for (int i = 0; i < seats; i++) {
                        
                        for (int j = 0; j < passenger.length; j++) {
                            isFindNamePassenger = false;
                            String name = in.next();
                            if (name.equals(passenger[j].getName())) {
                                isFindNamePassenger = true;   
                            }
                            break;  
                        }    
                    }        
                }
                reservation[Reservation.getIndexReservation()] = new Reservation(pnr + contPnr, date, seats);
                flight[saveIndexCode].setRemSeat(flight[saveIndexCode].getRemSeat()-seats);
                reservation[Reservation.getIndexReservation()].setFlight(flight[saveIndexCode]);
                
                out.println("\r\n" + flight[saveIndexCode].getFlightCode() + " Booked successfully for " + seats + " passengers, PRN " + contPnr);
                out.println("\r\n###########################################");
                Reservation.incIndexReservation();    
            }
            else {
                out.println("\r\nseats requested exceed the number available seats");
                out.println("\r\n###########################################");
                return;
            }
            if(isFindNamePassenger = false){
                out.println("\r\nName is not a registered passenger");
                out.println("\r\n###########################################");
                return;
            }
            
        }
        else{
            out.println("\r\nyou exceeded the number of booking requests");
            out.println("\r\n###########################################");
        }  
    }
    
    ///////////// NETHOD TO READ DETAILS OF search.
    public static void Search_Print(Scanner in,Reservation[] reservation,PrintWriter out){
        
        String pnr = in.next();       
        boolean isFindPnr = false;
        int saveIndexOfPnr=0;
        // to check if PNR Exists or not
        for (int i = 0; i <reservation.length; i++) {
            if(pnr.equalsIgnoreCase(reservation[i].getPnrNO())){
                isFindPnr =true;
                saveIndexOfPnr =i;
                break;
            }    
        }
        if(isFindPnr ==true){
            out.println("\r\nBooking Information for PNR# "+pnr+"\r\n\r\n");
            out.println("Flight "+reservation[saveIndexOfPnr].getFlight().getFlightCode() +" Information ");
            out.println("\r\n from:"+reservation[saveIndexOfPnr].getFlight().getCityFrom());
            out.println("\r\n to: "+reservation[saveIndexOfPnr].getFlight().getCityTo());
            out.println("\r\n total seats: "+reservation[saveIndexOfPnr].getFlight().getTotalSeats());
            out.println("\r\n available seats: "+reservation[saveIndexOfPnr].getFlight().getRemSeat());
            out.println("\r\n ticket price: "+reservation[saveIndexOfPnr].getFlight().getPrice());
            out.println("\r\n###########################################");
            
        }
        else{
            out.println("\r\nNo Record found with the PNR "+pnr+"\r\n\r\n");
            out.println("\r\n###########################################");
        } 
    }
    
    ///////////// NETHOD TO READ DETAILS OF Flight Status.
    public static void flight_Status(Scanner in,Reservation[] reservation,PrintWriter out){
        String code = in.next();
        
        boolean isFoundcode =false;
        int saveIndexOfcode =0;
        // to chec if CODE Exists or not
        for (int i = 0; i < reservation.length; i++) {
            if(code.equals(reservation[i].getFlight().getFlightCode())){
                isFoundcode =true;
                saveIndexOfcode =i;
            }   
        }
        if(isFoundcode ==true){
            out.println("\r\nFlight "+ code +" Information");
            out.println("\r\n from:"+reservation[saveIndexOfcode].getFlight().getCityFrom());
            out.println("\r\n to: "+reservation[saveIndexOfcode].getFlight().getCityTo());
            out.println("\r\n total seats: "+reservation[saveIndexOfcode].getFlight().getTotalSeats());
            out.println("\r\n available seats: "+reservation[saveIndexOfcode].getFlight().getRemSeat());
            out.println("\r\n ticket price: "+reservation[saveIndexOfcode].getFlight().getPrice());
            out.println("\r\nPassengers list:");

            out.println("\r\n\r\n\r\n#####################################");
        }
        else{
            out.println("\r\nNo Record found with the Flight Code "+code+"\r\n\r\n");
            out.println("\r\n###########################################");
        }
    }
}
