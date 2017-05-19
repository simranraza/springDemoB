/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springdemob.dao;

/**
 *
 * @author zion
 */


import com.springdemob.model.Users;
import com.springdemob.persistence.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

@Component
public class UsersDaoImpl implements UsersDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Users findByUserName(String user_name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Users user = (Users) session.createQuery("from Users").list().get(0);
        session.close();
        return user;
    }
    
    
}
