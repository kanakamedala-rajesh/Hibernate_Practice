package com.traning.hql;

import org.hibernate.Session;

import com.training.BookPOJO;
import com.training.util.HibernateUtil;

public class SessionLoad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			int id = 55;
			BookPOJO book = (BookPOJO) session.load(BookPOJO.class, id);
			if (book != null) {
				System.out.println(book.getBookId() + " | " + book.getBookName());
			} else {
				System.out.println("No book available with ID: " + id);
			}
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		} finally {
			session.close();
			System.exit(0);
		}
	}

}
