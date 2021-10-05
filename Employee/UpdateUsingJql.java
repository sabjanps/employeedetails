package com.te.hibernatedemo.bean.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.hibernatedemo.HibernareDemoTy.Employee;

public class UpdateUsingJql {
		public int update(Employee e)
		{
			EntityManagerFactory factory = null;
			EntityManager manager = null;
			EntityTransaction transction = null;
			int result = 0;
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transction = manager.getTransaction();
			transction.begin();
			String updateQuery = "update Employee set name='Sumit' where id=4";
			Query query = manager.createQuery(updateQuery);
			 result = query.executeUpdate();
			transction.commit();
			System.out.println("Rows affected :"+result);
			
		} catch (Exception e1) {
			e1.printStackTrace();

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
			return result;
		}
		

	}
	}


