package com.lun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lun.model.StockItem;


public interface StockItemRepo  extends JpaRepository<StockItem, Long> {

}
