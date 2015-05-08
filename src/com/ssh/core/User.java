package com.ssh.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "sshtest", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String agname;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public User(String username, String password, String agname) {
		this.username = username;
		this.password = password;
		this.agname = agname;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", unique = true, nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "agname", length = 50)
	public String getAgname() {
		return this.agname;
	}

	public void setAgname(String agname) {
		this.agname = agname;
	}

}