package com.niit.ekart.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class BillingAddress implements Serializable{
	
	
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private int billingAddressId;
	    private String streetName;
	    private String apartmentNumber;
	    private String city;
	    private String state;
	    private String country;
	    private String zipCode;
	    
	    @OneToOne
		private User user;

		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public int getBillingAddressId() {
			return billingAddressId;
		}
		public void setBillingAddressId(int billingAddressId) {
			this.billingAddressId = billingAddressId;
		}
		public String getStreetName() {
			return streetName;
		}
		public void setStreetName(String streetName) {
			this.streetName = streetName;
		}
		public String getApartmentNumber() {
			return apartmentNumber;
		}
		public void setApartmentNumber(String apartmentNumber) {
			this.apartmentNumber = apartmentNumber;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getZipCode() {
			return zipCode;
		}
		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}
	    
}
