package com.lun.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItemResponse {
    private String itemName;
    private String model;
    private String sku;
    private Integer quantity;
}
