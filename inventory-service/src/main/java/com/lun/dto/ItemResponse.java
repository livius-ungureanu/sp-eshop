package com.lun.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ItemResponse {
    private Long itemId;
    private String  sku;
    private String  name;
    private String  model;
}
