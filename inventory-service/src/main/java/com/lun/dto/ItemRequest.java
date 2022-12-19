package com.lun.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemRequest {
    private String  sku;
    private String  name;
    private String  model;
}
