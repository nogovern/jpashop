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

    public Member saveMember(Member member) {

        return memberRepository.save(member);
    }

    private void validDuplicateMember(Member member) {
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다");
        }
    }
}
