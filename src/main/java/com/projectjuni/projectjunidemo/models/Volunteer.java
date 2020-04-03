package com.projectjuni.projectjunidemo.models;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.projectjuni.projectjunidemo.models.committees.PraiseAndWorshipCommittee;

@Entity(name = "volunteers")
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "volunteer_id")
    private UUID volunteerId;
    private String first_name;
    private String last_name;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "committee_volunteers",
            joinColumns = @JoinColumn(name = "volunteer_id"),
            inverseJoinColumns = @JoinColumn(name = "committee_id")
    )
    private List<PraiseAndWorshipCommittee> committees;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "child",
            joinColumns = @JoinColumn(name = "volunteer_id"),
            inverseJoinColumns = @JoinColumn(name = "child_id")
    )
    private List<Volunteer> members;
    
    
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "volunteer_id")
    private List<Position> positions;

	public UUID getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(UUID volunteer_id) {
		this.volunteerId = volunteer_id;
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

	public List<Volunteer> getMembers() {
		return members;
	}

	public void setMembers(List<Volunteer> members) {
		this.members = members;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

}
