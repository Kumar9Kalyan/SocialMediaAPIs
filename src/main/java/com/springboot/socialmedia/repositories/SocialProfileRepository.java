package com.springboot.socialmedia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.socialmedia.models.SocialProfile;

@Repository
public interface SocialProfileRepository extends JpaRepository<SocialProfile, Long> {

}
