package cz.unicorncollege.lec_09.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Room
 *
 */
@Entity
public class Room {

	@ManyToOne(fetch=FetchType.EAGER)
	private Castle castle;

	@Id
	@GeneratedValue
	private long id;

	private int bedCount;
	private String number;

	public Room() {
		super();
	}

	public String toString() {
		return number + "(" + bedCount + " luzek)";
	}

	public Castle getCastle() {
		return this.castle;
	}

	public void setCastle(Castle castle) {
		this.castle = castle;
		if (!castle.getRooms().contains(this))
			castle.getRooms().add(this);
	}

	public long getId() {
		return this.id;
	}

	public int getBedCount() {
		return this.bedCount;
	}

	public void setBedCount(int bedCount) {
		this.bedCount = bedCount;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
