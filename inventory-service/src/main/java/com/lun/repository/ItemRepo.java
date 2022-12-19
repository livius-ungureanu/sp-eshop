package com.lun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lun.model.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {

}
