package quickrescue.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "address")
public class Address 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "addressId")
	private int addressId;
	@JoinColumn (name = "contactId")
	@OneToOne (cascade = CascadeType.ALL)
	private Contact contact;
	@Column (name = "streetAddress")
	private String streetAddress;
	@Column (name = "city")
	private String city;
	@Column (name = "province")
	private String province;
	@Column (name = "country")
	private String country;
	
	public Address() 
	{
		this.contact = null;
		this.city = "";
		this.streetAddress = "";
		this.province = "";
		this.country = "";
	}
	@Override
	public String toString() 
	{
		return "Address ID: " + String.valueOf(getAddressId()) + " Contact ID: " + String.valueOf(contact.getContactId())
		+ " Street: " + getStreetAddress() + " City: " + getCity() + " Province: " + getProvince() + " Country: " + getCountry();
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	public Contact getContact() {
		return contact;
	}
	
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	/*public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}*/
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
