package com.codingdojo.budgeit.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="expenses")
public class Expense {
	
    //____________ATTRIBUTES_________________________
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    private String expenseType;
    
    @NotEmpty
    private double expenseAmount;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
  
    
    //________________RELATIONSHIPS_____________________
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="creator_id")
    private User creator;
    
    //__________________CONSTRUCTORS____________________
    
	public Expense() {
	}
	
	public Expense(Long id, @NotEmpty String expenseType, @NotEmpty double expenseAmount, Date createdAt,
			Date updatedAt, User creator) {
		super();
		this.id = id;
		this.expenseType = expenseType;
		this.expenseAmount = expenseAmount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.creator = creator;
	}
	
    //__________________GETTERS & SETTERS____________________
	
	

	public Long getId() {
		return id;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public double getExpenseAmount() {
		return expenseAmount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public User getCreator() {
		return creator;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public void setExpenseAmount(double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}


}
