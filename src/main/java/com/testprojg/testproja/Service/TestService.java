package com.testprojg.testproja.Service;

import com.testprojg.testproja.Entity.Person;
import com.testprojg.testproja.Repository.TestRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    // -------------------- GET BY ID (cached) --------------------
    @Cacheable(value = "personCache", key = "#id")
    public Optional<Person> getPersonById(Long id) {
        System.out.println("Fetching Person from DB by ID...");
        return testRepository.findById(id);
    }

    // -------------------- GET BY NAME (cached separately) --------------------
    @Cacheable(value = "personNameCache", key = "#name")
    public Person getPersonByName(String name) {
        System.out.println("Fetching Person from DB by Name...");
         Optional<Person> person = testRepository.findByName(name);
         return person.isPresent()? person.get() : null;
    }

    // -------------------- SAVE PERSON (update ID-based & Name-based cache) --------------------
    @Caching(
            put = {
                    @CachePut(value = "personCache", key = "#result.id"),
                    @CachePut(value = "personNameCache", key = "#result.name")
            }
    )
    public Person savePerson(Person person) {
        System.out.println("Saving Person in DB...");
        return testRepository.save(person);
    }

    // -------------------- DELETE PERSON (remove from both caches) --------------------
    @Caching(
            evict = {
                    @CacheEvict(value = "personCache", key = "#id"),
                    @CacheEvict(value = "personNameCache", key = "#name")
            }
    )
    public void deletePerson(Long id, String name) {

        System.out.println("Deleting Person from DB & Cache...");
        Person p = testRepository.findById(id).orElse(null);

        if (p != null) {
            testRepository.delete(p);
        }
    }

    // -------------------- SIMPLE METHOD --------------------
    public int addNumbers(int a, int b) {
        return a + b;
    }
}
