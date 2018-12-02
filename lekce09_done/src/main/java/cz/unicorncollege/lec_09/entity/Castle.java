package cz.unicorncollege.lec_09.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Castle {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="castle")
	private Set<Room> rooms;

	public Castle() {
		super();
		rooms = new HashSet<Room>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void addRooms(Room room) {
		rooms.add(room);
		room.setCastle(this);
	}

}
