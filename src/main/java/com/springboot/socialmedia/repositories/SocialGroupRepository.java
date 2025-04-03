package com.springboot.socialmedia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.socialmedia.models.SocialGroup;

@Repository
public interface SocialGroupRepository extends JpaRepository<SocialGroup, Long> {

}
