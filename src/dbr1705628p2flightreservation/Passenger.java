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
public class Passenger {
    // attributs
     private String name;
    private int age;
    private char gender;
    private String phone;
    private static int indexPassenger;

    public Passenger(String name, int age, char gender, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        indexPassenger++;
    }

    public Passenger() {
        indexPassenger++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static int getIndexPassenger() {
        return indexPassenger;
    }

    public static void setIndexPassenger(int indexPassenger) {
        Passenger.indexPassenger = indexPassenger;
    }
    
}
