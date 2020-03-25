package com.projectjuni.projectjunidemo.models.committees;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "positions")
public class Position implements Serializable{
	
	private String name;
	private String description;
	@Id
	private UUID volunteer_id;
	@Id
	private UUID committee_id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getVolunteerId() {
		return volunteer_id;
	}

	public void setVolunteerId(UUID volunteer_id) {
		this.volunteer_id = volunteer_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UUID getCommitteeId() {
		return committee_id;
	}

	public void setCommitteeId(UUID committee_id) {
		this.committee_id = committee_id;
	}

}
