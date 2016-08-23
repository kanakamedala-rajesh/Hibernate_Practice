package com.traning.hql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.training.BookPOJO;
import com.training.util.HibernateUtil;

public class CriteriaTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(BookPOJO.class);
		List<BookPOJO> books = criteria.list();
		for (BookPOJO book : books) {
			System.out.print(book.getBookId());
			System.out.print(" | " + book.getBookName());
			System.out.println(" | " + book.getPublisher().getPubName());
		}
		session.close();
		System.exit(0);
	}

}
