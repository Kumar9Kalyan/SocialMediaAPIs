package com.springboot.socialmedia.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class SocialGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	@JoinTable(name="social_user_group",joinColumns = @JoinColumn(name="group_id"),inverseJoinColumns = @JoinColumn(name ="user_id" ))
	@JsonIgnore
	private Set<SocialUser> socialUsers = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<SocialUser> getSocialUsers() {
		return socialUsers;
	}

	public void setSocialUsers(SocialUser socialUser) {
		this.socialUsers.add(socialUser);
	}
	
	
}
