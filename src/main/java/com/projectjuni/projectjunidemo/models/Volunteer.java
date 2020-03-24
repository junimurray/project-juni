package com.projectjuni.projectjunidemo.models;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "volunteers")
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID volunteer_id;
    private String first_name;
    private String last_name;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "child",
            joinColumns = @JoinColumn(name = "volunteer_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id")
    )
    private List<Volunteer> child;

	public UUID getVolunteer_id() {
		return volunteer_id;
	}

	public void setVolunteerId(UUID volunteer_id) {
		this.volunteer_id = volunteer_id;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public List<Volunteer> getChild() {
		return child;
	}

	public void setChild(List<Volunteer> child) {
		this.child = child;
	}

}
