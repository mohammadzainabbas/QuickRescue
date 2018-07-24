package quickrescue.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "contact")
public class Contact 
{
	public static final String MALE = "male";
	public static final String FEMALE = "female";
	public static final String ACTIVE = "active";
	public static final String INACTIVE = "inactive";
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "contactId")
	private int contactId;
	//@JoinColumn (name = "accountId")
	@ManyToOne
	private Account account;
	@Column (name = "firstName")
	private String firstName;
	@Column (name = "lastName")
	private String lastName;
	@Column (name = "email")
	private String email;
	@Column (name = "gender")
	private String gender;
	@Column (name = "phoneNumber")
	private int phoneNumber;
	@Column (name = "contactStatus")
	private String status;
	
	public Contact()
	{	
		this.account = null;
		this.phoneNumber = 0;
		this.gender = MALE;
		this.status = ACTIVE;
		this.email = "";
		this.firstName = "";
		this.lastName = "";
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Contact ID: " + String.valueOf(getContactId()) + " Account ID: " + String.valueOf(account.getAccountId()) + " Name " + getFirstName() + getLastName() + " Email: " + getEmail()
+ " Gender: " + getGender() + " Phone No.: " + getPhoneNumber() + " Status: " + getStatus()	;
	}
	
/*	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	 
*/}
