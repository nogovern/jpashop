package me.jangddol.jpashop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.jangddol.jpashop.constant.ItemSellStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String itemNm;

    @Column(nullable = false)
    private int price;              // 가격

    @Column(name="stock_amount")
    private int stockNumber;        // 재고수량

    @Lob
    private String itemDetail;      // 상세설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;  // 판매살태

    private LocalDateTime regTime;          // 등록시간
    private LocalDateTime updateTime;       // 수정시간
}
