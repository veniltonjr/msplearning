package com.msplearning.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The UserApp class.
 * 
 * @author Venilton Falvo Junior (veniltonjr)
 */
@Entity
@Table(name = "tb_app_user")
public class UserApp implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserAppId id;

	@Column(name = "date_request", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateRequest;

	@Column(name = "active", nullable = false)
	private boolean active;

	public UserAppId getId() {
		return this.id;
	}

	public void setId(UserAppId id) {
		this.id = id;
	}

	public Date getDateRequest() {
		return this.dateRequest;
	}

	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.active ? 1231 : 1237);
		result = prime * result + (this.dateRequest == null ? 0 : this.dateRequest.hashCode());
		result = prime * result + (this.id == null ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		UserApp other = (UserApp) obj;
		if (this.active != other.active) {
			return false;
		}
		if (this.dateRequest == null) {
			if (other.dateRequest != null) {
				return false;
			}
		} else if (!this.dateRequest.equals(other.dateRequest)) {
			return false;
		}
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}
}
