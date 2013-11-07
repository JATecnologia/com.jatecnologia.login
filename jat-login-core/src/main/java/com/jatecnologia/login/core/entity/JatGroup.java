package com.jatecnologia.login.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the jat_group database table.
 * 
 */
@Entity
@Table(name="jat_group")
@NamedQuery(name="JatGroup.findAll", query="SELECT j FROM JatGroup j")
public class JatGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private String name;

	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to JatUserGroup
	@OneToMany(mappedBy="jatGroup")
	private List<JatUserGroup> jatUserGroups;

	public JatGroup() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public List<JatUserGroup> getJatUserGroups() {
		return this.jatUserGroups;
	}

	public void setJatUserGroups(List<JatUserGroup> jatUserGroups) {
		this.jatUserGroups = jatUserGroups;
	}

	public JatUserGroup addJatUserGroup(JatUserGroup jatUserGroup) {
		getJatUserGroups().add(jatUserGroup);
		jatUserGroup.setJatGroup(this);

		return jatUserGroup;
	}

	public JatUserGroup removeJatUserGroup(JatUserGroup jatUserGroup) {
		getJatUserGroups().remove(jatUserGroup);
		jatUserGroup.setJatGroup(null);

		return jatUserGroup;
	}

}