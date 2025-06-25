/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hotelproject.models;

/**
 *
 * @author hieun
 */
public class Service {
    private String serviceName;
    private double price;
    private String note;

    public Service() {}

    public Service(String serviceName, double price, String note) {
        this.serviceName = serviceName;
        this.price = price;
        this.note = note;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return serviceName + " (" + price + " VND)";
    }
}