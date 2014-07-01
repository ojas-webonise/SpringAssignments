package com.sample.hibernate;

import org.hibernate.Session;

public class DbOperation {

	public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
 
        session.beginTransaction();
        Stock stock = new Stock();
 
        stock.setStockCode("2354");
        stock.setStockName("KJDS");
 
        session.save(stock);
        session.getTransaction().commit();
	}
}
