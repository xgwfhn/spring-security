package com.audi.ssm.repository;

import org.springframework.data.repository.CrudRepository;
import com.audi.ssm.model.User;

public interface UserRepository extends  CrudRepository<User,String> {
	public User findByUserName(String userName);
}
