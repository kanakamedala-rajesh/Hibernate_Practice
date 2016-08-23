package com.traning.hql;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.BookPOJO;
import com.training.util.HibernateUtil;

public class HQLDeleteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("\nDelete Operation Test");
		System.out.println("-----------------------------------------");
		System.out.println("Enter book id to delete");
		Scanner scanner = new Scanner(System.in);
		int book_id = scanner.nextInt();
		deleteBook(book_id);
	}

	private static void deleteBook(int book_id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("delete from BookPOJO where book_id = :BookId");
		query.setInteger("BookId", book_id);
		Transaction transaction = session.beginTransaction();
		int i = query.executeUpdate();
		transaction.commit();
		if (i == 0) {
			query = session.createQuery("from BookPOJO");
			List<BookPOJO> list = query.list();
			System.out.println("\n\n\nGiven BookId not available in table");
			System.out.println("Select one value among");
			for (BookPOJO book : list) {
				System.out.print(book.getBookId()+"\t");
			}
			main(null);

		} else {
			System.out.println("Row with bookId: "+book_id+" deleted sucessfully");
		}
		session.close();
	}

}
