package com.te.hibernatedemo.bean.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteUsingjql {

	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transction = null;
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transction = manager.getTransaction();
			transction.begin();
			String update = "delete from Employee  where id=:id";
			Query query = manager.createQuery(update);
			int result = query.executeUpdate();
			transction.commit();
			System.out.println("Rows affected :"+result);
			
		} catch (Exception e) {
			e.printStackTrace();

			if (transction != null) {
				transction.rollback();
			}
		} finally {

			if (manager != null) {
				manager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}

	}

	}


