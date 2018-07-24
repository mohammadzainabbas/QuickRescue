package quickrescue.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "accountId")
	private int accountId;
	@Column(name = "accountName")
	private String accountName;
	@Column(name = "email")
	private String email;
	@Column(name = "city")
	private String city;
	
	@OneToMany(mappedBy="account")
	private List<Contact> contacts= new ArrayList<>();

	public Account() 
	{
		this.accountName = "";
		this.email = "";
		this.city = "";
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Account ID: " + String.valueOf(getAccountId()) + " Account Name: " + getAccountName()
				+ " Email Domain: " + getEmail() + " Time Zone City: " + getCity();
	}

}
