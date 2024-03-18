/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accountingsystem.controllers;

import com.mycompany.accountingsystem.models.Database.DbInterface;
import com.mycompany.accountingsystem.models.Database.Dbutils;
import com.mycompany.accountingsystem.models.Product.Price;
import com.mycompany.accountingsystem.models.Product.Product;
import jakarta.persistence.EntityManager;
import java.util.List;
import com.mycompany.accountingsystem.models.Record.Record;
import java.util.Set;

/**
 *
 * @author georgesalebe
 */
public class RecordDao implements DbInterface<Record> {

    private final EntityManager em = Dbutils.getEntityManager();

    @Override
    public void Save(Record entity) {
        try {
            em.getTransaction().begin();
            Set<Product> products = entity.getProducts();
            double total = 0;
            for (Product product : products) {
                Price price = product.getPrice();
                total += price.getConsumablePrice();
            }
            entity.setBill_amount(total);
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Record Find(int id) {
        return em.find(Record.class, id);
    }

    @Override
    public void Update(int id, Record entity) {
        try {
            Record record = Find(id);
            em.getTransaction().begin();
            record.setMoney_recived(entity.getMoney_recived());
            record.setProducts(entity.getProducts());
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        try {
            Record record = Find(id);
            em.getTransaction().begin();
            em.remove(record);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Record> All() {
        return em.createQuery("from Record").getResultList();
    }

}
