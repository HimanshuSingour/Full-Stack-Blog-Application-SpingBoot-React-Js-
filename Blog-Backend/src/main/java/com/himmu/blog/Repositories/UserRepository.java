package com.himmu.blog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.himmu.blog.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	
	 
}
