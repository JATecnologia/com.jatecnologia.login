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
@NamedQuery(name="JATUserGroup.findAll", query="SELECT j FROM JATUserGroup j")
public class JATUserGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JATUserGroupPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to JATUser
	@ManyToOne
	@JoinColumn(name="user_id", insertable = false, updatable = false)
	private JATUser jatUser;

	//bi-directional many-to-one association to JATGroup
	@ManyToOne
	@JoinColumn(name="group_id", insertable = false, updatable = false)	
	private JATGroup jatGroup;

	public JATUserGroup() {
	}

	public JATUserGroupPK getId() {
		return this.id;
	}

	public void setId(JATUserGroupPK id) {
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

	public JATUser getJatUser() {
		return this.jatUser;
	}

	public void setJatUser(JATUser jatUser) {
		this.jatUser = jatUser;
	}

	public JATGroup getJatGroup() {
		return this.jatGroup;
	}

	public void setJatGroup(JATGroup jatGroup) {
		this.jatGroup = jatGroup;
	}

}