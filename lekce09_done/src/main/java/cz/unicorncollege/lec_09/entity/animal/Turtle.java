package cz.unicorncollege.lec_09.entity.animal;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Turtle
 *
 */
@Entity
public class Turtle extends Pet {

	private Boolean livesInWater;

	public Turtle() {
		super();
	}

	public Turtle(String name, Boolean livesInWater) {
		super();
		this.livesInWater = livesInWater;
		setName(name);
	}

	public Boolean getLivesInWater() {
		return this.livesInWater;
	}

	public void setLivesInWater(Boolean livesInWater) {
		this.livesInWater = livesInWater;
	}

	@Override
	public String toString() {
		return "Zelva [vodni=" + livesInWater + ", jmeno()=" + getName() + ", id=" + getId() + ", vek=" + getAge()
				+ "]";
	}

}
