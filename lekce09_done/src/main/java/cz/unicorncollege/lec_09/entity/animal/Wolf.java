package cz.unicorncollege.lec_09.entity.animal;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Wolf
 *
 */
@Entity
public class Wolf extends Animal {

	private Integer killedGMCount;

	public Wolf() {
		super();
	}

	public Integer getKilledGMCount() {
		return this.killedGMCount;
	}

	public void setKilledGMCount(Integer killedGMCount) {
		this.killedGMCount = killedGMCount;
	}

	@Override
	public String toString() {
		return "Vlk [babicek=" + killedGMCount + ", id=" + getId() + ", vek=" + getAge() + "]";
	}

}
