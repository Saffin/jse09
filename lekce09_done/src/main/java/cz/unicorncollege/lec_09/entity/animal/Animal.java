package cz.unicorncollege.lec_09.entity.animal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Entity implementation class for Entity: Animal
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Animal {

	@Id
	@GeneratedValue
	private long id;
	private int age;

	public Animal() {
		super();
	}

	public long getId() {
		return this.id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Zvire [id=" + id + ", vek=" + age + "]";
	}

}
