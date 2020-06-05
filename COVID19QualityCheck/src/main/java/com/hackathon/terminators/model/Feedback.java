package com.hackathon.terminators.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="APP_USER")
public class Feedback implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name="ORGNAME", nullable=false)
	private String orgName;
	
	@NotEmpty
	@Column(name="NAME", nullable=false)
	private String name;
	
	
	@Column(name="Q1", nullable=false)
	private Integer q1;
	
	@Column(name="Q2", nullable=false)
	private Integer q2;
	
	@Column(name="Q3", nullable=false)
	private Integer q3;
	
	@Column(name="Q4", nullable=false)
	private Integer q4;
	
	@Column(name="Q5", nullable=false)
	private Integer q5;
	
	@Column(name="Q6", nullable=false)
	private Integer q6;
	
	@Column(name="Q7", nullable=false)
	private Integer q7;
	
	@Column(name="Q8", nullable=false)
	private Integer q8;
	
	@Column(name="Q9", nullable=false)
	private Integer q9;
	
	@Column(name="Q10", nullable=false)
	private Integer q10;
	
	@Column(name="Q11", nullable=false)
	private Integer q11;
	
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		orgName = orgName;
	}

	public Integer getQ1() {
		return q1;
	}

	public void setQ1(Integer q1) {
		this.q1 = q1;
	}

	public Integer getQ2() {
		return q2;
	}

	public void setQ2(Integer q2) {
		this.q2 = q2;
	}

	public Integer getQ3() {
		return q3;
	}

	public void setQ3(Integer q3) {
		this.q3 = q3;
	}

	public Integer getQ4() {
		return q4;
	}

	public void setQ4(Integer q4) {
		this.q4 = q4;
	}

	public Integer getQ5() {
		return q5;
	}

	public void setQ5(Integer q5) {
		this.q5 = q5;
	}

	public Integer getQ6() {
		return q6;
	}

	public void setQ6(Integer q6) {
		this.q6 = q6;
	}

	public Integer getQ7() {
		return q7;
	}

	public void setQ7(Integer q7) {
		this.q7 = q7;
	}

	public Integer getQ8() {
		return q8;
	}

	public void setQ8(Integer q8) {
		this.q8 = q8;
	}

	public Integer getQ9() {
		return q9;
	}

	public void setQ9(Integer q9) {
		this.q9 = q9;
	}

	public Integer getQ10() {
		return q10;
	}

	public void setQ10(Integer q10) {
		this.q10 = q10;
	}

	public Integer getQ11() {
		return q11;
	}

	public void setQ11(Integer q11) {
		this.q11 = q11;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Feedback feedback = (Feedback) o;

		if (Double.compare(feedback.q1, q1) != 0) return false;
		if (id != null ? !id.equals(feedback.id) : feedback.id != null) return false;
		if (orgName != null ? !orgName.equals(feedback.orgName) : feedback.orgName != null) return false;
		return q1 != null ? q1.equals(feedback.q1) : feedback.q1 == null;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = id != null ? id.hashCode() : 0;
		result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
		result = 31 * result + (q1 != null ? q1.hashCode() : 0);
		temp = Double.doubleToLongBits(q3);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", name=" + orgName + ", q1=" + q1
				+ ", q2=" + q2 + "]";
	}


}
