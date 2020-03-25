package com.projectjuni.projectjunidemo.models.committees;

import java.util.List;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
// @Inheritance(strategy = InheritanceType.JOINED)
public abstract class Committee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID committee_id;
	private String name;
	private String shortname;
	private String description;

//	abstract List<Position> getPositions();

//	abstract List<Item> getItems();

	public UUID getCommittee_id() {
		return committee_id;
	}

	public void setCommittee_id(UUID committee_id) {
		this.committee_id = committee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortname;
	}

	public void setShortName(String shortName) {
		this.shortname = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// public void setPositions(List<Position> positions) {
	// this.positions = positions;
	// }

	// public void setItems(List<Item> items) {
	// this.items = items;
	// }

}
