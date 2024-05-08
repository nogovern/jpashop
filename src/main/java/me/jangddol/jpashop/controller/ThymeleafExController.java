package me.jangddol.jpashop.controller;

import me.jangddol.jpashop.dto.ItemDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="thymeleaf")
public class ThymeleafExController {

    @GetMapping(value = "/")
    public String thymeleafIndex(Model model) {

        // home
        return "redirect:/";
    }

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

    @GetMapping(value = "/ex03")
    public String thymeleafEx03(Model model) {

        List<ItemDto> items = new ArrayList<>();

        for (int i=1; i < 10; i++) {
            ItemDto itemDto = new ItemDto();
            itemDto.setItemDetail("상품 상세 설명" + i);
            itemDto.setItemNm("테스트 상품 " + i);
            itemDto.setPrice(10000 * i);
            itemDto.setRegTime(LocalDateTime.now());

            items.add(itemDto);
        }

        model.addAttribute("items", items);
        return "thymeleafEx/thymeEx03";
    }

    @GetMapping(value="/ex07")
    public String thymeleafExLayout(Model model) {

        return "thymeleafEx/thymeEx07";
    }
}
