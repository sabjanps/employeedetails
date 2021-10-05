package com.te.hibernatedemo.bean.Employee;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.hibernatedemo.HibernareDemoTy.Employee;

public class FindAllJpqlImpl {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager = factory.createEntityManager();
		String findAll = "from Employee";
		Query query = manager.createQuery(findAll);
		List<Employee> list = query.getResultList();
		System.out.println(list);
		System.out.println("--------------------------------------");
		for (Employee employee : list) {
			System.out.println(employee);
		}

	}

	public void getbyId(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
		EntityManager manager = factory.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id");
		int id1 = sc.nextInt();

		String findOne = "from Employee where id =id1";
		Query query = manager.createQuery(findOne);
		List<Employee> list = query.getResultList();
		System.out.println(list);
		System.out.println("--------------------------------------");
		for (Employee employee : list) {
			System.out.println(employee);
		}

	}

}
