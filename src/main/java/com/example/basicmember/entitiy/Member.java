package com.example.basicmember.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long age;
    private String gender;

    public Member(String name, Long age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void update(String name, Long age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
