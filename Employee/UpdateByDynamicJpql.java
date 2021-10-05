package com.te.hibernatedemo.bean.Employee;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class UpdateByDynamicJpql {

	public static void main(String[] args) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transction = null;
		
		try
		{
		factory = Persistence.createEntityManagerFactory("emp");
		manager=factory.createEntityManager();
		transction = manager.getTransaction();
		transction.begin();
		String update = "update Employee set name =:name,designation =: desig where id=: id";
		Query query = manager.createQuery(update);
		query.setParameter("name", args[1]);
		query.setParameter("desig", args[2]);
		query.setParameter("id", Integer.parseInt(args[0]));
		int result=query.executeUpdate();
		transction.commit();
		}
		catch (Exception e) {
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


