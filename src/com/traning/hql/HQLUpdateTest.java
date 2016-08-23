package com.traning.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.PublisherPOJO;
import com.training.util.HibernateUtil;

public class HQLUpdateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Publishers List BEFORE Update:");
		System.out.println("-----------------------------------------");
		showPublishers();

		updatePublisher();

		System.out.println("--------------***************------------");
		System.out.println("Publishers List AFTER Update:");
		System.out.println("-----------------------------------------");
		showPublishers();
		System.exit(0);
	}

	private static void updatePublisher() {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("Update PublisherPOJO set pubName = :pubName where pubId = :pubId");
		query.setString("pubName", "Updated publisher");
		query.setLong("pubId", 4);
		Transaction transaction = session.beginTransaction();
		int i = query.executeUpdate();
		transaction.commit();
		System.out.println("No. of rows affected: " + i);
		session.close();
	}

	private static void showPublishers() {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from PublisherPOJO order by pub_id");
		List<PublisherPOJO> pubs = query.list();
		for (PublisherPOJO pub : pubs) {
			System.out.println(pub.getPubId() + " | " + pub.getPubName());
		}
		session.close();
	}

}
