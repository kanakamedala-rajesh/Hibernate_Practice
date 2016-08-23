package com.traning.hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.training.util.HibernateUtil;

public class NamedQueryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.getNamedQuery("showBookPrice");
		query.setParameter("pubId", 5);
		List list = query.list();
		Iterator iterator = list.iterator();
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
