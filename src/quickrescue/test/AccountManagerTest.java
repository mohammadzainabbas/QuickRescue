package quickrescue.test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import quickrescue.manager.AccountManager;
import quickrescue.manager.DatabaseManager;
import quickrescue.model.Account;

class AccountManagerTest {
	
	@Test
	void testAdd_Account() 
	{
		DatabaseManager.setup();
		AccountManager accountManager = new AccountManager();

		Account account = new Account();
		account.setAccountName("CEME");
		account.setCity("Islamabad");
		account.setEmail("info@ceme.edu.pk");
	
		assertEquals(true, accountManager.addAccount(account));
		DatabaseManager.exit();
	}

	@Test
	void testView_Account() 
	{
		DatabaseManager.setup();
		AccountManager accountManager = new AccountManager();
		assertEquals(4, accountManager.viewAccount());
		DatabaseManager.exit();
	}

	@Test
	void testUpdate_Account() 
	{
		DatabaseManager.setup();
		AccountManager accountManager = new AccountManager();
		Account account = new Account();
		account.setAccountId(5);
		account.setAccountName("CEME, NUST");
		account.setCity("Rawalpindi");
		account.setEmail("info@ceme.edu.pk");
		assertEquals(account, accountManager.updateAccount(account));
		DatabaseManager.exit();
	}

	@Test
	void testDelete_Account() 
	{
		DatabaseManager.setup();
		AccountManager accountManager = new AccountManager();
		assertEquals(true, accountManager.deleteAccount(26));
		DatabaseManager.exit();
	}

}
