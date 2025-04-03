package com.springboot.socialmedia;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.socialmedia.models.Post;
import com.springboot.socialmedia.models.SocialGroup;
import com.springboot.socialmedia.models.SocialProfile;
import com.springboot.socialmedia.models.SocialUser;
import com.springboot.socialmedia.repositories.PostRepository;
import com.springboot.socialmedia.repositories.SocialGroupRepository;
import com.springboot.socialmedia.repositories.SocialProfileRepository;
import com.springboot.socialmedia.repositories.SocialUserRepository;

@Configuration
public class DataInitializer {

	
	private final SocialUserRepository userRepository;
	private final SocialGroupRepository groupRepository;
	private final SocialProfileRepository profileRepository;
	private final PostRepository postRepository;
	
	public DataInitializer(SocialUserRepository userRepository, SocialGroupRepository groupRepository,
			SocialProfileRepository profileRepository, PostRepository postRepository) {
		super();
		this.userRepository = userRepository;
		this.groupRepository = groupRepository;
		this.profileRepository = profileRepository;
		this.postRepository = postRepository;
	}

	@Bean
	public CommandLineRunner initializeData() {
		
		return args->{
			SocialUser user1 = new SocialUser();
			SocialUser user2 = new SocialUser();
			SocialUser user3 = new SocialUser();
			
			//Save user to the database
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			
			//Create some groups
			SocialGroup group1 = new SocialGroup();
			SocialGroup group2 = new SocialGroup();
			
			group1.setSocialUsers(user1);
			group1.setSocialUsers(user2);
			
			group2.setSocialUsers(user2);
			group2.setSocialUsers(user3);
		
			//Save groups to database			
			groupRepository.save(group1);
			groupRepository.save(group2);
			
			user1.setSocialGroups(group1);
			user2.setSocialGroups(group1);
			user2.setSocialGroups(group2);
			user3.setSocialGroups(group2);
			
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			
			//Create some posts			
			Post post1 = new Post();
			Post post2 = new Post();
			Post post3 = new Post();
		
			//Associate posts to users			
			post1.setUser(user1);
			post2.setUser(user2);
			post3.setUser(user3);
		
			//Save posts to the database
			postRepository.save(post1);
			postRepository.save(post2);
			postRepository.save(post3);
	
			//create some social profile
			SocialProfile profile1 = new SocialProfile();
			SocialProfile profile2 = new SocialProfile();
			SocialProfile profile3 = new SocialProfile();
			
			
			//Associate profiles with users
			profile1.setSocialUser(user1);
			profile2.setSocialUser(user2);
			profile3.setSocialUser(user3);
			
			//Save profiles to the database
			profileRepository.save(profile1);
			profileRepository.save(profile2);
			profileRepository.save(profile3);
			
			
		
		};
	}
	
}
