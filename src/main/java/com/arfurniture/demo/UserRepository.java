package com.arfurniture.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    User findByName(String Name);    
    User findById(Long id);
    User findByEmail(String email);
    void deleteById(Long id);
    User save(User user);
}
