package com.traning.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.training.util.HibernateUtil;

public class HQLGroupbyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();

		String queryString = "SELECT B.publisher.pubName, COUNT(B.bookId) FROM BookPOJO B GROUP BY B.publisher.pubName";

		Query query = session.createQuery(queryString);
		List<?> books = query.list();

		Iterator<?> iterator = books.iterator();
		while (iterator.hasNext()) {
			Object[] row = (Object[]) iterator.next();
			System.out.print("Publisher: " + row[0]);
			System.out.println(" | Number of Books: " + row[1]);
		}
		session.close();
		System.exit(0);
	}

}
