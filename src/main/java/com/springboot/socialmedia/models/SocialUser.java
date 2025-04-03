package com.springboot.socialmedia.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class SocialUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy = "socialUser",cascade = { CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private SocialProfile socialProfile;
	
	@OneToMany(mappedBy = "user",cascade ={ CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<Post> posts = new ArrayList<>();
	
	@ManyToMany(mappedBy = "socialUsers",cascade = { CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private Set<SocialGroup> socialGroups = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SocialProfile getSocialProfile() {
		return socialProfile;
	}

	public void setSocialProfile(SocialProfile socialProfile) {
		
		this.socialProfile = socialProfile;
		socialProfile.setSocialUser(this);
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(Post post) {
		this.posts.add(post);
	}

	public Set<SocialGroup> getSocialGroups() {
		return socialGroups;
	}

	public void setSocialGroups(SocialGroup socialGroup) {
		this.socialGroups.add(socialGroup);
	} 
}
