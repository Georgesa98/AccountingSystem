/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accountingsystem.controllers;

import com.mycompany.accountingsystem.models.Database.DbInterface;
import com.mycompany.accountingsystem.models.Database.Dbutils;
import com.mycompany.accountingsystem.models.Product.Product;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author georgesalebe
 */
public class ProductDao implements DbInterface<Product> {

    private final EntityManager em = Dbutils.getEntityManager();

    @Override
    public void Save(Product entity) {
        try {

            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product Find(int id) {
        return em.find(Product.class, id);
    }

    @Override
    public void Update(int id, Product entity) {
        try {
            Product product = Find(id);
            em.getTransaction().begin();
            product.setName(entity.getName());
            product.setCompanyName(entity.getCompanyName());
            product.setQuantity(entity.getQuantity());
            product.setPrice(entity.getPrice());
            product.setExpiryDate(entity.getExpiryDate());
            product.setBarcode(entity.getBarcode());
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        try {
            Product product = Find(id);
            em.getTransaction().begin();
            em.remove(product);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> All() {
        return em.createQuery("from Product").getResultList();
    }

}
