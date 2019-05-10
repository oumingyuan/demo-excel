package com.example.demoexcel.repository;

//import com.example.repositories.entity.Person;
//import com.example.demo1.entity.Person;
import com.example.demoexcel.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {

//    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
//    Person findByNameStartsWith(@Param("name") String name);

}
