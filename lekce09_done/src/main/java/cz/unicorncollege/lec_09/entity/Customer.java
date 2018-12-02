package cz.unicorncollege.lec_09.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
public class Customer {

	@Id
	@GeneratedValue
	private long id;
	
	private String firstName;
	private String surName;
	
	@OneToOne
	private TreasureBox treasureBox;
	
	@ManyToMany(mappedBy="customerList")
	private Set<Trip> trips;

	public Customer() {
		super();
		trips = new HashSet<Trip>();
	}

	public long getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return this.surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public TreasureBox getTreasureBox() {
		return this.treasureBox;
	}

	public void setTreasureBox(TreasureBox treasureBox) {
		this.treasureBox = treasureBox;
	}

	public Set<Trip> getTrips() {
		return trips;
	}

}
