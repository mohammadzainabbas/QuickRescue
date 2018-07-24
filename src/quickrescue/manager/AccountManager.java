package quickrescue.manager;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import quickrescue.model.Account;

public class AccountManager 
{
	public AccountManager() 
	{	
	}

	public boolean addAccount(Account account) 
	{
		try 
		{
			Session session = startTransaction();
			session.save(account);
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
	public int viewAccount() 
	{
		int entryCount = 0;
		Session session = startTransaction();
		try 
		{
			List<Account> accounts = session.createQuery("From Account").list();
			entryCount = accounts.size();
			for (Account account : accounts) 
			{
				System.out.println(account);
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

	public Account updateAccount(Account account) 
	{
		Account acc = null;
		try 
		{
			Session session = startTransaction();
			session.update(account);
			acc = session.get(Account.class, account.getAccountId());
			closeTransaction(session);
		} 
		catch (RuntimeException e) 
		{
			e.printStackTrace();
			throw e;
		}
		return acc;
	}

	public boolean deleteAccount(int accountId) 
	{
		try 
		{
			Session session = startTransaction();
			Account acc = session.get(Account.class, accountId);
			if (acc != null) 
			{
				session.delete(acc);
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

	private void closeTransaction(Session session) 
	{
		session.getTransaction().commit();
		session.close();
	}

	private Session startTransaction() 
	{
		Session session = DatabaseManager.getSession();
		session.beginTransaction();
		return session;
	}
}
