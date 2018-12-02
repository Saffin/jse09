package cz.unicorncollege.lec_09.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Hero
 *
 */
@Entity
@Table(name = "Hero")
public class Hero implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	
	private String nickName;

	private Boolean hasHorse;

	private Integer killedDragonsCount;

	private static final long serialVersionUID = 1L;

	public Hero() {
		super();
	}

	public Hero(String nickName, Integer killedDragonsCOunt, Boolean hasHorse) {
		super();
		this.nickName = nickName;
		this.killedDragonsCount = killedDragonsCOunt;
		this.hasHorse = hasHorse;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Boolean getHasHorse() {
		return this.hasHorse;
	}

	public void setHasHorse(Boolean hasHorse) {
		this.hasHorse = hasHorse;
	}

	public Integer getKilledDragonsCount() {
		return this.killedDragonsCount;
	}

	public void setKilledDragonsCount(Integer killedDragonsCount) {
		this.killedDragonsCount = killedDragonsCount;
	}
}
