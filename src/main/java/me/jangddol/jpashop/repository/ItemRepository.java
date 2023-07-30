package me.jangddol.jpashop.repository;

import me.jangddol.jpashop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
