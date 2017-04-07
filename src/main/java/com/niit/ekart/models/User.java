package com.niit.ekart.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	    private int id;
	    private String firstName;
	    private String lastName;
	    private String mailId;
	    private String phoneNumber;
	    private String password;
	    
	    public User(String firstName, String lastName, String mailId, String phoneNumber, String password) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.mailId = mailId;
	        this.phoneNumber = phoneNumber;
	        this.password = password;
	    }

	    public User(int id) {
	        this.id = id;
	    }

	    public User(String mailId, String password) {
	        this.mailId = mailId;
	        this.password = password;
	    }

	    public User() {
	    }
	    
	    
	    
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
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

	    public String getMailId() {
	        return mailId;
	    }

	    public void setMailId(String mailId) {
	        this.mailId = mailId;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPassword(String password) {
			this.password = password;
		}

		public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public String getPassword() {
	        return password;
	    }

	
}
