/**
 * 
 */
package com.training;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.util.HibernateUtil;

public class ContactCRUD {
	public static Session session = HibernateUtil.getSessionFactory().openSession();

	public static void main(String[] args) {

		// Integer contactId = insertContact();
		// getAllContacts();
		// getContact(2);
		// updateContact(2, "Mohammed Arshad");
		// getContact(2);

		getContact(1);
		deleteContact(1);
		getContact(1);

		session.close();
		System.exit(0);
	}

	/**
	 * @param i
	 */
	private static void deleteContact(int contactId) {
		// TODO Auto-generated method stub3
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			ContactPojo contact = (ContactPojo) session.get(ContactPojo.class, contactId);
			session.delete(contact);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	private static void updateContact(int contactId, String firstName) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			ContactPojo contact = (ContactPojo) session.get(ContactPojo.class, contactId);
			contact.setFirstName(firstName);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	private static void getContact(int i) {
		// TODO Auto-generated method stub
		ContactPojo contact = (ContactPojo) session.get(ContactPojo.class, i);
		if (contact != null) {
			System.out.println(contact.toString());
		} else {
			System.out.println("No contact exists with ID: " + i);
		}
	}

	private static Integer insertContact() {

		Integer contactId = null;
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			ContactPojo contact = new ContactPojo();
			contact.setFirstName("Afsar");
			contact.setLastName("Basha");
			contact.setDob(new Date("08/16/2008"));
			contact.setEmail("amzad.basha@gmail.com");
			contact.setMobile("+91-9391001339");
			contactId = (Integer) session.save(contact);
			transaction.commit();
		} catch (HibernateException ex) {
			if (transaction != null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		return contactId;
	}

	private static void getAllContacts() {
		// TODO Auto-generated method stub
		List<ContactPojo> contacts = session.createQuery("from ContactPojo").list();
		for (ContactPojo contactPojo : contacts) {
			System.out.println(contactPojo.toString());
		}

	}

}
