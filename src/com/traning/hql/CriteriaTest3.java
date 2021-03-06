package com.traning.hql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.training.BookPOJO;
import com.training.util.HibernateUtil;

public class CriteriaTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(BookPOJO.class);
		//criteria.add(Restrictions.like("bookName", "%Action%"));
		criteria.addOrder(Order.asc("bookName"));
		
		List<BookPOJO> books = criteria.list();
		for (BookPOJO book : books) {
			System.out.print(book.getBookId());
			System.out.print(" | " + book.getBookName());
			System.out.print(" | " + book.getPublisher().getPubName());
			System.out.println(" | " + book.getPrice());
		}
		session.close();
		System.exit(0);
	}

}
