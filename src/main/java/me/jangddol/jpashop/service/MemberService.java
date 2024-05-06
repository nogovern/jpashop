package me.jangddol.jpashop.service;

import lombok.RequiredArgsConstructor;
import me.jangddol.jpashop.entity.Member;
import me.jangddol.jpashop.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 신규 저장
    public Member saveMember(Member member) {
        validDuplicateMember(member);
        return memberRepository.save(member);
    }

    // 가입된 회원인지 검증
    private void validDuplicateMember(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다");
        }
    }
}
