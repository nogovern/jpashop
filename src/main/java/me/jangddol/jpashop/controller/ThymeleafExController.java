package me.jangddol.jpashop.controller;

import me.jangddol.jpashop.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping(value="thymeleaf")
public class ThymeleafExController {

    @GetMapping(value="/ex01")
    public String thymeleafEx01(Model model) {
        model.addAttribute("data", "타임리프 예제입니다");
        return "thymeleafEx/thymeEx01";
    }

    @GetMapping(value="/ex02")
    public String thymeleafEx02(Model model) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setItemNm("테스트 상품1");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto", itemDto);
        return "thymeleafEx/thymeEx02";
    }

    @GetMapping(value="/ex07")
    public String thymeleafExLayout(Model model) {

        return "thymeleafEx/thymeEx07";
    }
}
