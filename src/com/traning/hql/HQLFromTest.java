package com.traning.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.training.BookPOJO;
import com.training.util.HibernateUtil;

public class HQLFromTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from BookPOJO");
		List<BookPOJO> books = query.list();
		for (BookPOJO book : books) {
			System.out.print(book.getBookId());
			System.out.print(" | " + book.getBookName());
			System.out.println(" | " + book.getPublisher().getPubName());
		}
		session.close();
		System.exit(0);
	}

}
