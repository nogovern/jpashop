package me.jangddol.jpashop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDto {

    private String name;

    private String password;

    private String email;

    private String address;     // 추후 enumarble 로 변경하자!

}
