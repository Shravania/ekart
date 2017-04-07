package com.niit.ekart.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@OneToOne
	private User roleId;
	@NotEmpty
	private String roleName;
	private String userName;
	
	public UserRole() {
		// TODO Auto-generated constructor stub
	}
	
	public UserRole(int userId, String user) {
	}
	public User getRoleId() {
		return roleId;
	}
	public void setRoleId(User roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getUserName(){
		return userName;
		}
	public void setUserName(String userName){
		this.userName=userName;
	}
}

