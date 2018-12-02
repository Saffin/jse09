package cz.unicorncollege.lec_09.entity.animal;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Pet
 *
 */
@Entity
public abstract class Pet extends Animal {

	private String name;

	public Pet() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
