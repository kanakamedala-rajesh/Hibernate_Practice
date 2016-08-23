package com.traning.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.training.util.HibernateUtil;

public class HQLJoinTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();

		String queryString = "Select B.bookId, B.bookName, P.pubId, P.pubName "
				+ " from BookPOJO B, PublisherPOJO P where B.publisher = P.pubId";

		Query query = session.createQuery(queryString);
		List<?> list = query.list();
		
		Iterator<?> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			for (int i = 0; i < obj.length; i++) {
				System.out.print(obj[i] + " | ");
			}
			System.out.println();
		}

		session.close();
		System.exit(0);

	}

}
