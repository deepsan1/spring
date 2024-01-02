package com.example.Entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id;
	 @Column(nullable=false)
     private String name;
	 @Column(nullable=false)
     private String password;
	 @OneToMany(mappedBy="user")
	 private Set<UserSessionEntity> usersessions;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<UserSessionEntity> getUsersessions() {
		return usersessions;
	}
	public void setUsersessions(Set<UserSessionEntity> usersessions) {
		this.usersessions = usersessions;
	}
}
