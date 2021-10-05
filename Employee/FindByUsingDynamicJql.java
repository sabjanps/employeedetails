package com.te.hibernatedemo.bean.Employee;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.hibernatedemo.HibernareDemoTy.Employee;

public class FindByUsingDynamicJql {

	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transction = null;
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transction = manager.getTransaction();
			System.out.println("Enter The id");
			transction.begin();
			String findById = "from Employee where id = :id";
			Query query = manager.createQuery(findById);
		    int result = query.executeUpdate();
			query.setParameter("id", Integer.parseInt(args[0]));
			Employee employee = (Employee) query.getSingleResult();
			System.out.println(employee);
			transction.commit();

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
