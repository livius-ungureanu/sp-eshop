package com.lun.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationRequest {
    private Long    locationId;
    private String  name;
    private String  address;
    private String  zipCode;
}
