package cz.unicorncollege.lec_09.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Dragon")
public class Dragon implements Serializable {

	@Id	@Column(name = "dragon_name")
	private String name;

	@Column(name = "head_count")
	private Integer headCount;

	@Temporal(TemporalType.DATE)
	private Date birthDate;

	private Double agressionNumber;

	private static final long serialVersionUID = 1L;

	public Dragon() {
		super();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHeadCount() {
		return this.headCount;
	}

	public void setHeadCount(Integer headCount) {
		this.headCount = headCount;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Double getAgressionNumber() {
		return this.agressionNumber;
	}

	public void setAgressionNumber(Double agressionNumber) {
		this.agressionNumber = agressionNumber;
	}

	public void slashDragonsHead() {
		this.headCount--;
	}

}
