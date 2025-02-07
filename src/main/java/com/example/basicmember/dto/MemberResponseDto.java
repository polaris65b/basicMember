package com.example.basicmember.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {
    private Long id;
    private String name;
    private Long age;
    private String gender;

    public MemberResponseDto(Long id, String name, Long age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
