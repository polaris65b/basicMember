package com.example.basicmember.repository;

import com.example.basicmember.entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Member, Long> {
}
