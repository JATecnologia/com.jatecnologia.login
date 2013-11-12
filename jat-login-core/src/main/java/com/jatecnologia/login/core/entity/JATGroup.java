package com.jatecnologia.login.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the jat_group database table.
 * 
 */
@Entity
@Table(name="jat_group")
@NamedQuery(name="JATGroup.findAll", query="SELECT j FROM JATGroup j")
public class JATGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String email;

	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to JATUserGroup
	@OneToMany(mappedBy="jatGroup")
	private Set<JATUserGroup> jatUserGroups;

	public JATGroup() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set<JATUserGroup> getJatUserGroups() {
		return this.jatUserGroups;
	}

	public void setJatUserGroups(Set<JATUserGroup> jatUserGroups) {
		this.jatUserGroups = jatUserGroups;
	}

	public JATUserGroup addJatUserGroup(JATUserGroup jatUserGroup) {
		getJatUserGroups().add(jatUserGroup);
		jatUserGroup.setJatGroup(this);

		return jatUserGroup;
	}

	public JATUserGroup removeJatUserGroup(JATUserGroup jatUserGroup) {
		getJatUserGroups().remove(jatUserGroup);
		jatUserGroup.setJatGroup(null);

		return jatUserGroup;
	}

}