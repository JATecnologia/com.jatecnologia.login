package com.jatecnologia.login.core.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the jat_user_group database table.
 * 
 */
@Embeddable
public class JatUserGroupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="name_group", insertable=false, updatable=false)
	private String nameGroup;

	@Column(name="user_login", insertable=false, updatable=false)
	private String userLogin;

	public JatUserGroupPK() {
	}
	public String getNameGroup() {
		return this.nameGroup;
	}
	public void setNameGroup(String nameGroup) {
		this.nameGroup = nameGroup;
	}
	public String getUserLogin() {
		return this.userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof JatUserGroupPK)) {
			return false;
		}
		JatUserGroupPK castOther = (JatUserGroupPK)other;
		return 
			this.nameGroup.equals(castOther.nameGroup)
			&& this.userLogin.equals(castOther.userLogin);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.nameGroup.hashCode();
		hash = hash * prime + this.userLogin.hashCode();
		
		return hash;
	}
}