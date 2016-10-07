package com.audi.ssm.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="users")
public class User implements UserDetails{

	private String id;
	private String userName;
	private String passWord;
	private String role;
	
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
	@GeneratedValue(generator="idGenerator")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
		
	
	@Column(name="username")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="password")
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name="role")
	public String getRole() {
		return role;
	}


	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		GrantedAuthority authority=new SimpleGrantedAuthority(role);
		authorities.add(authority);
		return authorities;
	}


	


	@Transient
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Transient
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Transient
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Transient
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



	@Transient
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.passWord;
	}



	@Transient
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	
	

}
