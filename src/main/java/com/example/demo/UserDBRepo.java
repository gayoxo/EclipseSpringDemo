package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDBRepo extends JpaRepository<UserDB, Long>{

	UserDB findByUsername(String username);

}
