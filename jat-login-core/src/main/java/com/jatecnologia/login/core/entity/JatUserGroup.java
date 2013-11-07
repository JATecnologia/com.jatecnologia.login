package com.jatecnologia.login.core.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the jat_user_group database table.
 * 
 */
@Entity
@Table(name="jat_user_group")
@NamedQuery(name="JatUserGroup.findAll", query="SELECT j FROM JatUserGroup j")
public class JatUserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JatUserGroupPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to JatGroup
	@ManyToOne
	@JoinColumn(name="name_group")
	private JatGroup jatGroup;

	//bi-directional many-to-one association to JatUser
	@ManyToOne
	@JoinColumn(name="user_login")
	private JatUser jatUser;

	public JatUserGroup() {
	}

	public JatUserGroupPK getId() {
		return this.id;
	}

	public void setId(JatUserGroupPK id) {
		this.id = id;
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

	public JatGroup getJatGroup() {
		return this.jatGroup;
	}

	public void setJatGroup(JatGroup jatGroup) {
		this.jatGroup = jatGroup;
	}

	public JatUser getJatUser() {
		return this.jatUser;
	}

	public void setJatUser(JatUser jatUser) {
		this.jatUser = jatUser;
	}

}