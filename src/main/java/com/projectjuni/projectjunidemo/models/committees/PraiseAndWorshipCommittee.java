package com.projectjuni.projectjunidemo.models.committees;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.projectjuni.projectjunidemo.models.Item;
import com.projectjuni.projectjunidemo.models.Volunteer;

@Entity
@DiscriminatorValue(value = "p & w")
public class PraiseAndWorshipCommittee extends Committee {

	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "committee_volunteers",
            joinColumns = @JoinColumn(name = "committee_id"),
            inverseJoinColumns = @JoinColumn(name = "volunteer_id")
    )
//	@Where(clause = "committees.committee_name = '" + CommitteeType.P_AND_W + "' ")
	private List<Volunteer> volunteers;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "committee_id")
	private List<Item> items;

	public List<Volunteer> getVolunteers() {
		return volunteers;
	}

	public void setVolunteers(List<Volunteer> volunteers) {
		this.volunteers = volunteers;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}



}
