package com.codingdojo.budgeit.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message="Please enter your first name!")
	private String firstName;
	
	@NotBlank(message="Please enter your last name!")
	private String lastName;
    
	@NotBlank(message="Please enter your email")
    @Email(message="Email must be valid")
    private String email;
   
    @Size(min=8, message="Password must be greater than 8 characters")
    private String password;
    
    @Transient
    private String passwordConfirmation;
    
    @Column(updatable=false)
    private Date createdAt;
	private Date updatedAt;
    
    //_______________RELATIONSHIPS______________________
    
    
    //One person has One budget
    @OneToOne(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Budget budget;
    

    
    //_________________CONSTRUCTORS_____________________
    
    
    
	public User() {
	}
	
//	public User(Long id, String firstName, String lastName, String email, String password, String passwordConfirmation) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.password = password;
//		this.passwordConfirmation = passwordConfirmation;
//	}

    public User(Long id, @NotBlank(message = "Please enter your first name!") String firstName,
			@NotBlank(message = "Please enter your last name!") String lastName,
			@NotBlank(message = "Please enter your email") @Email(message = "Email must be valid") String email,
			@Size(min = 8, message = "Password must be greater than 8 characters") String password,
			String passwordConfirmation, Date createdAt, Date updatedAt, Budget budget) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.budget = budget;
	}

	//_______________GETTERS & SETTERS______________________
	

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	
	

	
}