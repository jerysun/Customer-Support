package com.jsun.site.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.security.Principal;

@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "UserPrincipal_Username", columnNames = "Username")
})
public class UserPrincipal implements Principal, Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	
	private static final String SESSION_ATTRIBUTE_KEY = "com.jsun.user.principal";
	
	private long id;
	
	private String username;
	
	private byte[] password;

	@Id
	@Column(name = "UserId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	@Transient
	public String getName()
	{
		return this.username;
	}

	@Basic
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Basic
	@Column(name = "HashedPassword")
	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}
	
	@Override
	public int hashCode()
	{
		return this.username.hashCode();
	}
	
	@Override
	public boolean equals(Object other)
	{
		return other instanceof UserPrincipal &&
				((UserPrincipal)other).username.equals(this.username);
	}
	
	@Override
	protected UserPrincipal clone()
	{
		try {
			return (UserPrincipal)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e); // not possible
		}
	}
	
	@Override
	public String toString()
	{
		return this.username;
	}
	
	
	public static Principal getPrincipal(HttpSession session)
	{
		return session == null ? null :
			(Principal)session.getAttribute(SESSION_ATTRIBUTE_KEY);
	}
	
	public static void setPrincipal(HttpSession session, Principal principal)
	{
		session.setAttribute(SESSION_ATTRIBUTE_KEY, principal);
	}
}
