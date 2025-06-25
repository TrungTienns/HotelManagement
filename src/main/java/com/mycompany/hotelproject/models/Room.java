/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelproject.models;

/**
 *
 * @author hieun
 */public class Room {
    private String roomNumber;
    private String roomType;
    private String status;
    private double pricePerHour;
    private double pricePerDay;
    private String note;
    
    // Constructor
    public Room() {}
    
    public Room(String roomNumber, String roomType, String status, 
                double pricePerHour, double pricePerDay, String note) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.note = note;
    }
    
    // Getters and Setters
    public String getRoomNumber() {
        return roomNumber;
    }
    
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    public String getRoomType() {
        return roomType;
    }
    
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public double getPricePerHour() {
        return pricePerHour;
    }
    
    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
    
    public double getPricePerDay() {
        return pricePerDay;
    }
    
    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
   @Override
    public String toString() {
    return roomNumber + " - " + roomType + " - " + status;
    }
}   