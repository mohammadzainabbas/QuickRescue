package quickrescue.manager;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import quickrescue.model.Contact;

public class ContactManager 
{
	public ContactManager() 
	{
	}

	public boolean addContact(Contact contact) 
	{
		try 
		{
			Session session = startTransaction();
			session.save(contact);
			closeTransaction(session);
			return true;
		} 
		catch (RuntimeException e) 
		{
			e.printStackTrace();
			throw e;
		}
	}
	 
	@SuppressWarnings("unchecked")
	public int viewContact(int accountId) 
	{
		int entryCount = 0;
		Session session = startTransaction();
		try 
		{
			List<Contact> contacts = session.createQuery("From Contact").list();
			entryCount = contacts.size();
			for (Contact contact : contacts) 
			{
				System.out.println(contact);
			}
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			closeTransaction(session);
		}
		System.out.println(entryCount);
		return entryCount;
	}

	public Contact updateContact(Contact contact) 
	{
		Contact con = null;
		try 
		{
			Session session = startTransaction();
			session.update(contact);
			con = session.get(Contact.class, contact.getContactId());
			closeTransaction(session);
		} 
		catch (RuntimeException e) 
		{
			e.printStackTrace();
			throw e;
		}
		return con;
	}
	 
	public boolean deleteContact(int contactId) 
	{
		try 
		{
			Session session = startTransaction();
			Contact con = session.get(Contact.class, contactId);
			if (con != null) 
			{
				session.delete(con);
			}
			closeTransaction(session);
			return true;
		} 
		catch (RuntimeException e) 
		{
			e.printStackTrace();
			throw e;
		}
	}
	  
		private void closeTransaction(Session session) {
			session.getTransaction().commit();
			session.close();
		}

		private Session startTransaction() {
			Session session = DatabaseManager.getSession();
			session.beginTransaction();
			return session;
		}

}
