package com.testprojg.testproja.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;

    public Person(String name) {
        this.name = name;
    }

    // 👇 ADD THIS FIELD
    @Transient // <-- IMPORTANT: do NOT save to DB
    private List<GrantedAuthority> authorities = List.of();

    // 👇 ADD THIS SETTER so Jackson can deserialize
    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities == null ? List.of() : authorities;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }
}

