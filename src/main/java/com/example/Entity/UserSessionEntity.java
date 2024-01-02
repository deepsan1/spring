package com.example.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="usersession")
public class UserSessionEntity {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id;
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "user_id", referencedColumnName = "id",nullable=false)
	 private UserEntity user;
	 @Column(nullable=false)
     private String username;
	 @Column(nullable=false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",updatable = false, insertable = false)
     private LocalDateTime requesttime;
	 @Column(nullable=false)
     private Boolean loggedin;
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}
	public LocalDateTime getRequesttime() {
		return requesttime;
	}
	public void setRequesttime(LocalDateTime requestitime) {
		this.requesttime = requestitime;
	}
	public Boolean getLoggedin() {
		return loggedin;
	}
	public void setLoggedin(Boolean loggedin) {
		this.loggedin = loggedin;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}
