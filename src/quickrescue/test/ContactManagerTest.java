package quickrescue.test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import quickrescue.manager.DatabaseManager;
import quickrescue.model.Account;
import quickrescue.model.Contact;
import quickrescue.manager.ContactManager;

class ContactManagerTest {

	@Test
	void testAdd_Contact() 
	{
		DatabaseManager.setup();
		Account account = new Account();
		ContactManager contactManager = new ContactManager();

		account.setAccountName("GR");
		account.setCity("Islamabad");
		account.setEmail("info@gr.com");
	
		Contact contact = new Contact();
		contact.setAccount(account);
		contact.setGender(Contact.FEMALE);
		contact.setStatus(Contact.ACTIVE);
		contact.setFirstName("Fatimah");
		contact.setLastName("Zahra");
		contact.setEmail("fati@gr.com");
		contact.setPhoneNumber(8803706);
		
		assertEquals(true, contactManager.addContact(contact));
		DatabaseManager.exit();
	}

	@Test
	void testView_Contact() 
	{
		DatabaseManager.setup();
		ContactManager contactManager = new ContactManager();
		int accountId = 4;
		assertEquals(4, contactManager.viewContact(accountId));
		DatabaseManager.exit();
	}

	@Test
	void testUpdate_Contact() 
	{
		DatabaseManager.setup();
		ContactManager contactManager = new ContactManager();
		
		Contact contact = new Contact();
		contact.setContactId(2);
		contact.setStatus(Contact.INACTIVE);
		
		assertEquals(contact, contactManager.updateContact(contact));
		DatabaseManager.exit();
	}

	@Test
	void testDelete_Contact() 
	{
		DatabaseManager.setup();
		ContactManager contactManager = new ContactManager();
		int contactId = 4;
		assertEquals(true, contactManager.deleteContact(contactId));
		DatabaseManager.exit();
	}
}
