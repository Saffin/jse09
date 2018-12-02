package cz.unicorncollege.lec_09.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: TreasureBox
 *
 */
@Entity
public class TreasureBox {

	@Id
	@GeneratedValue
	private long id;
	
	private String number;
	private String validity;
	
	@OneToOne(mappedBy="treasureBox")
	private Customer customer;

	public TreasureBox() {
		super();
	}

	public long getId() {
		return this.id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getValidity() {
		return this.validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

}
