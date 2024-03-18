/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.accountingsystem;

import com.mycompany.accountingsystem.controllers.ProductDao;
import com.mycompany.accountingsystem.controllers.RecordDao;
import com.mycompany.accountingsystem.models.Product.Price;
import com.mycompany.accountingsystem.models.Product.Product;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.h2.tools.Server;
import com.mycompany.accountingsystem.models.Record.Record;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author georgesalebe
 */
public class AccountingSystem {

    public static void main(String[] args) {
        try {
            ProductDao pd = new ProductDao();
            List<Product> products = pd.All();
            Set<Product> products1 = new HashSet<>();
            products1.addAll(products);
            Record record = new Record(products1, 1000);
            RecordDao recordDao = new RecordDao();
            recordDao.Save(record);
            Server server = Server.createWebServer();
            server.start();
            Thread.sleep(5 * 60 * 1000);
        } catch (Exception ex) {
            Logger.getLogger(AccountingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
