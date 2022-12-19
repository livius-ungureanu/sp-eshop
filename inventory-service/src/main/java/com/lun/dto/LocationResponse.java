package com.lun.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class LocationResponse {
    private Long locationId;
    private String  name;
    private String  address;
    private String  zipCode;
}
