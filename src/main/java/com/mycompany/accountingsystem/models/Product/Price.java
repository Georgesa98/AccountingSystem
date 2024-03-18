/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accountingsystem.models.Product;

import jakarta.persistence.Embeddable;

/**
 *
 * @author georgesalebe
 */
@Embeddable
public class Price {
    private double price;
    private double consumablePrice;

    public Price(double price, double consumablePrice) {
        this.price = price;
        this.consumablePrice = consumablePrice;
    }

    public Price() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getConsumablePrice() {
        return consumablePrice;
    }

    public void setConsumablePrice(double consumablePrice) {
        this.consumablePrice = consumablePrice;
    }
    
    
}
