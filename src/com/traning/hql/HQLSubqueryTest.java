package com.traning.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.training.BookPOJO;
import com.training.util.HibernateUtil;

public class HQLSubqueryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuilder queryString = new StringBuilder("FROM BookPOJO B ");
		queryString.append("WHERE B.publisher = ");
		queryString.append("(SELECT pubId FROM PublisherPOJO where pubId = :pubId)");

		Query query = session.createQuery(queryString.toString());
		query.setInteger("pubId", 40);
		List<BookPOJO> books = query.list();

		if (books.size() == 0) {
			System.out.println("No Books available.");
		} else {
			for (BookPOJO book : books) {
				System.out.print(book.getBookId());
				System.out.print(" | " + book.getBookName());
				System.out.println(" | " + book.getPublisher().getPubName());
			}
		}
		
		session.close();
		System.exit(0);

	}

}
