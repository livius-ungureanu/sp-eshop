package com.lun.controller;

import com.lun.dto.InventoryItemResponse;
import com.lun.dto.ItemRequest;
import com.lun.dto.ItemResponse;
import com.lun.service.ItemService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<HttpStatus> createItem(@RequestBody ItemRequest itemRequest) {
        itemService.createItem(itemRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ItemResponse>> getItems() {

       List<ItemResponse> itemResps = itemService.getItems()
            .stream()
            .map(item -> 
                ItemResponse.builder()
                .itemId(item.getId())
                .sku(item.getSku())
                .name(item.getName())
                .model(item.getModel())
                .build())
            .collect(Collectors.toList());

        return new ResponseEntity<>(itemResps, HttpStatus.OK);
    }

    @GetMapping("/{sku}")
    public ResponseEntity<InventoryItemResponse> getItem(@PathVariable Long itemId) {
        return null;
        // return inventoryService.getInventoryItem(sku)
        //       .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
        //       .orElseThrow(() -> new InventoryNotFoundException(sku));
    }
}
