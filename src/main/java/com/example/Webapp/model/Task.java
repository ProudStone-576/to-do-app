package com.example.Webapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @Size(max = 255, message = "Description can't be longer than 255 characters")
    private String description;

    private boolean completed;

    // Constructors, Getters, and Setters
    // (Keep the same as previously defined)
    
    //constructors
    public Task(){
    	
    }
    public Task(String title, String description, boolean completed) {
    	this.title = title;
    	this.description = description;
    	this.completed = completed;
    }
    
    public Long getId(){
    	return id;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}
