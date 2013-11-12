package com.jatecnologia.login.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the jat_user database table.
 * 
 */
@Entity
@Table(name="jat_user")
@NamedQuery(name="JATUser.findAll", query="SELECT j FROM JATUser j")
public class JATUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String email;

	private String login;

	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to JATUserGroup
	@OneToMany(mappedBy="jatUser")
	private Set<JATUserGroup> jatUserGroups;

	public JATUser() {
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

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		jatUserGroup.setJatUser(this);

		return jatUserGroup;
	}

	public JATUserGroup removeJatUserGroup(JATUserGroup jatUserGroup) {
		getJatUserGroups().remove(jatUserGroup);
		jatUserGroup.setJatUser(null);

		return jatUserGroup;
	}

}