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
    private int price;

    @Column(name="stock_amount")
    private int stockNumber;        // 재고수량

    @Lob
    private String itemDetail;

    @Enumerated(EnumType.STRING)
    private ItemSellStatus status;

    private LocalDateTime regTime;          // 등록시간
    private LocalDateTime updateTime;
}
