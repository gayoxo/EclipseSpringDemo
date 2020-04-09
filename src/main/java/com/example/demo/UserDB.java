package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserDB {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false, unique = true)
    private String username;
 
    private String password;
    
    private String enabled;

    public UserDB() {
	}
    
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
     
	public String getEnabled() {
		return enabled;
	}
	
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
}
