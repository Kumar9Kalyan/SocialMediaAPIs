package com.springboot.socialmedia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.socialmedia.models.SocialUser;

@Repository
public interface SocialUserRepository extends JpaRepository<SocialUser, Long> {

}
