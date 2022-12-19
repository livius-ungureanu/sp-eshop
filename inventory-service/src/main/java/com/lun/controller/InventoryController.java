package com.lun.controller;

import com.lun.dto.InventoryItemResponse;
import com.lun.dto.InventoryItemRequest;
import com.lun.exceptions.InventoryNotFoundException;
import com.lun.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<HttpStatus> addInventoryItem(@RequestBody InventoryItemRequest inventoryRequest) {
        inventoryService.createInventoryItem(inventoryRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<InventoryItemResponse>> getInventoryItems() {
        return new ResponseEntity<>(inventoryService.getInventoryItems(), HttpStatus.OK);
    }

    @GetMapping("/{sku}")
    public ResponseEntity<InventoryItemResponse> getInventoryItem(@PathVariable String sku) {
        return inventoryService.getInventoryItem(sku)
              .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
              .orElseThrow(() -> new InventoryNotFoundException(sku));
    }
}
