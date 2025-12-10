package com.testprojg.testproja.Repository;

import com.testprojg.testproja.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Person, Long> {

    @Query(
            value = "SELECT * FROM GRS_INHOUSE.PERSON WHERE NAME = ?1", nativeQuery = true
    )
    Optional<Person> findByName(String name);
}
