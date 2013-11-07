package com.jatecnologia.login.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the jat_user database table.
 * 
 */
@Entity
@Table(name="jat_user")
@NamedQuery(name="JatUser.findAll", query="SELECT j FROM JatUser j")
public class JatUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private String login;

	private String email;

	private String password;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to JatUserGroup
	@OneToMany(mappedBy="jatUser")
	private List<JatUserGroup> jatUserGroups;

	public JatUser() {
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<JatUserGroup> getJatUserGroups() {
		return this.jatUserGroups;
	}

	public void setJatUserGroups(List<JatUserGroup> jatUserGroups) {
		this.jatUserGroups = jatUserGroups;
	}

	public JatUserGroup addJatUserGroup(JatUserGroup jatUserGroup) {
		getJatUserGroups().add(jatUserGroup);
		jatUserGroup.setJatUser(this);

		return jatUserGroup;
	}

	public JatUserGroup removeJatUserGroup(JatUserGroup jatUserGroup) {
		getJatUserGroups().remove(jatUserGroup);
		jatUserGroup.setJatUser(null);

		return jatUserGroup;
	}

}