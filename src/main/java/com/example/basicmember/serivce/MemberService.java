package com.example.basicmember.serivce;

import com.example.basicmember.dto.MemberRequestDto;
import com.example.basicmember.dto.MemberResponseDto;
import com.example.basicmember.entitiy.Member;
import com.example.basicmember.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemoRepository memberRepository;

    // Create
    @Transactional
    public MemberResponseDto save(MemberRequestDto dto){
        Member member = new Member(
                dto.getName(),
                dto.getAge(),
                dto.getGender()
        );
        Member savedMember = memberRepository.save(member);
        return new MemberResponseDto(
                savedMember.getId(),
                savedMember.getName(),
                savedMember.getAge(),
                savedMember.getGender()
        );
    }

    // Read
    // 다건 조회
    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAll(){
        List<Member> members = memberRepository.findAll();

        List<MemberResponseDto> dtos = new ArrayList<>();
        for (Member member : members) {
            dtos.add(new MemberResponseDto(
                    member.getId(),
                    member.getName(),
                    member.getAge(),
                    member.getGender()
            ));
        }
        return dtos;
    }
    // 단건 조회
    @Transactional(readOnly = true)
    public MemberResponseDto findById(Long id){
        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 사람이 습니다.")
        );
        return new MemberResponseDto(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getGender()
        );
    }

    // Update
    @Transactional
    public MemberResponseDto update(Long id, MemberRequestDto dto){
        Member member = memberRepository.findById(id).orElseThrow(
              () -> new IllegalArgumentException("해당 id에 맞는 사람이 없습니다.")
        );
        member.update(dto.getName(), dto.getAge(), dto.getGender());
        return new MemberResponseDto(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getGender()
        );
    }

    // Delete
    @Transactional
    public void delete(Long id){
        if(!memberRepository.existsById(id)){
            throw new IllegalArgumentException("해당 id에 맞는 사람이 없습니다.");
        }
        memberRepository.deleteById(id);
    }
}
