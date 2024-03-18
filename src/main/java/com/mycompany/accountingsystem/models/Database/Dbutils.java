/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accountingsystem.models.Database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author georgesalebe
 */
public class Dbutils {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
