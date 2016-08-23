package com.traning.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.training.BookPOJO;
import com.training.util.HibernateUtil;

public class BookPriceUpdate {

	public static void main(String[] args) {
		System.out.println("Books List BEFORE Update:");
		System.out.println("----------------------------------");
		showBooks();

		updateBooks();

		System.out.println("----------****************--------");
		System.out.println("Books List AFTER Update:");
		System.out.println("----------------------------------");
		showBooks();

		System.exit(0);
	}

	private static void updateBooks() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("Update BookPOJO set price = :bookPrice where publisher = :pubId");
		Double price[] = { 41.99, 9.99, 75.55, 89.99, 99.99 };
		int pubIds[] = { 1, 2, 3, 4, 5 };
		int update = 0;
		for (int i = 0; i < pubIds.length; i++) {
			query.setDouble("bookPrice", price[i]);
			query.setInteger("pubId", pubIds[i]);
			session.beginTransaction();
			update += query.executeUpdate();
			session.getTransaction().commit();
		}
		System.out.println("No. of rows affected: " + update);
		session.close();
	}

	private static void showBooks() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from BookPOJO");
		List<BookPOJO> books = query.list();
		for (BookPOJO book : books) {
			System.out.print(book.getBookId());
			System.out.print(" | " + book.getBookName());
			System.out.print(" | " + book.getPublisher().getPubName());
			System.out.println(" | " + book.getPrice());
		}
		session.close();
	}

}
