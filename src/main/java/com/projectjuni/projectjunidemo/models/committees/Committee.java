package com.projectjuni.projectjunidemo.models.committees;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "committees")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "shortname", discriminatorType = DiscriminatorType.STRING)
public abstract class Committee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID committee_id;
	private String name;
	@Column(name="shortname", insertable = false, updatable = false)
	private String shortName;
	private String description;

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
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Committee committee = (Committee) o;
        return name.equals(committee.getName()) &&
        		shortName.equals(committee.getShortName()) &&
        		description.equals(committee.getDescription());
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(name, shortName, description);
    }

}
