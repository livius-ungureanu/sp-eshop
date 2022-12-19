package com.lun.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Separate the data transfer object from the Model
// because the data transfer object is used to transfer data between
// the client and the server
// and the Model is used to store data in the database

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItemRequest {
    private Long itemId;
    private Long locationId;
    private Integer quantity;
}

