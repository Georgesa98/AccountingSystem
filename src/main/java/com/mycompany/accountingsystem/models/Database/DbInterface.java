/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.accountingsystem.models.Database;

import java.util.List;

/**
 *
 * @author georgesalebe
 */
public interface DbInterface<T> {
    void Save(T entity);
    T Find(int id);
    void Update(int id, T entity);
    void Delete(int id);
    List<T> All();
}
