package me.jangddol.jpashop.service;

import me.jangddol.jpashop.dto.MemberFormDto;
import me.jangddol.jpashop.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createMember() {
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setEmail("test@email.com");
        memberFormDto.setName("홍길동");
        memberFormDto.setAddress("서울시 강남구 수서 123");
        memberFormDto.setPassword("1234");

        return Member.createMember(memberFormDto, passwordEncoder);
    }

    @Test
    @DisplayName("회원 가입 테스트")
    public void saveMemberTest() {

        Member member = createMember();
        Member savedMember = memberService.saveMember(member);

        assertThat(savedMember.getEmail()).isEqualTo("test@email.com");
        assertThat(savedMember.getName()).isEqualTo(member.getName());
    }

    @Test
    @DisplayName("중복 회원 가입 테스트")
    public void saveDuplicateMemberTest() {
        Member member1 = createMember();
        Member member2 = createMember();
        memberService.saveMember(member1);      // save to db

        Throwable e = assertThrows(IllegalStateException.class, () -> {
           memberService.saveMember(member2);
        });

        assertThat(e.getMessage()).isEqualTo("이미 가입된 회원입니다");

    }

}