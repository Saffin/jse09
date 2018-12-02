package cz.unicorncollege.lec_09.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Trip
 *
 */
@Entity
public class Trip implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToMany
	private Set<Customer> customerList;
	
	String type;

	public Trip() {
		super();
		customerList = new HashSet<Customer>();
	}

	public long getId() {
		return this.id;
	}

	public Set<Customer> getCustomerList() {
		return this.customerList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
