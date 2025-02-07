package com.example.basicmember.controller;

import com.example.basicmember.dto.MemberRequestDto;
import com.example.basicmember.dto.MemberResponseDto;
import com.example.basicmember.serivce.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // Create
    @PostMapping("/members")
    public ResponseEntity<MemberResponseDto> save(@RequestBody MemberRequestDto dto){
        return ResponseEntity.ok(memberService.save(dto));
    }

    // Read
    // 전체 조회
    @GetMapping("/members")
    public ResponseEntity<List<MemberResponseDto>> findAll(){
        return ResponseEntity.ok(memberService.findAll());
    }
    // 선택 조회
    @GetMapping("/members/{id}")
    public ResponseEntity<MemberResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(memberService.findById(id));
    }

    // Update
    @PutMapping("/members/{id}")
    public ResponseEntity<MemberResponseDto> update(
            @PathVariable Long id,
            @RequestBody MemberRequestDto dto
    ){
        return ResponseEntity.ok(memberService.update(id, dto));
    }

    // Delete
    @DeleteMapping("/members/{id}")
    public void delete(@PathVariable Long id){
        memberService.delete(id);
    }
}
