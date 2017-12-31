package com.jsun.site.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "TicketComment")
public class TicketCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	
	private long ticketId;
	
	private long userId;
	
	private String body;
	
	private Timestamp dateCreated;

	@Id
	@Column(name = "CommentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	public long getTicketId() {
		return ticketId;
	}

	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	@Basic
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Basic
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Basic
	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
}
