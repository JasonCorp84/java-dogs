package com.lambdaschool.dogs.demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long>{

}
