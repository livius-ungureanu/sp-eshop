package com.lun.controller;

import com.lun.dto.InventoryItemResponse;
import com.lun.dto.LocationRequest;
import com.lun.dto.LocationResponse;
import com.lun.service.LocationService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    public ResponseEntity<HttpStatus> createLocation(@RequestBody LocationRequest locationRequest) {
        locationService.createLocation(locationRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LocationResponse>> getLocations() {
        
        List<LocationResponse> locResponses = locationService.getLocations()
            .stream()
            .map(location -> 
                LocationResponse.builder()
                .locationId(location.getId())
                .name(location.getName())
                .address(location.getAddress())
                .zipCode(location.getZipCode())
                .build())
            .collect(Collectors.toList());

        return new ResponseEntity<>(locResponses, HttpStatus.OK);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<InventoryItemResponse> getLocation(@PathVariable Long locationId) {
        return null;
        // return inventoryService.getInventoryItem(sku)
        //       .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
        //       .orElseThrow(() -> new InventoryNotFoundException(sku));
    }
}
