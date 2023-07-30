package me.jangddol.jpashop.entity;

import javax.persistence.*;

@Entity
@Table(name = "item_img")
public class ItemImg extends BaseTimeEntity{

    @Id
    @Column(name = "item_img_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imgName;

    private String origImgName;

    private String imgUrl;

    private String repimgYn;        // 대표 이미지 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    public void updateItemImg(String origImgName, String imgName, String imgUrl) {
        this.origImgName = origImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }

}
