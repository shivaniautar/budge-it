package com.codingdojo.budgeit.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="budgets")
public class Budget {
    //__________________ATTRIBUTES____________________
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    private double budgetAmount;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    //__________________RELATIONSHIPS____________________
    
    //One budget per user
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    
    //__________________CONSTRUCTORS____________________
    
	public Budget() {
	}


	public Budget(Long id, @NotEmpty double budgetAmount, Date createdAt, Date updatedAt, User user) {
		super();
		this.id = id;
		this.budgetAmount = budgetAmount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}
	
    
    //__________________GETTERS & SETTERS____________________


	public Long getId() {
		return id;
	}


	public double getBudgetAmount() {
		return budgetAmount;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public User getUser() {
		return user;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setBudgetAmount(double budgetAmount) {
		this.budgetAmount = budgetAmount;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
    
}
