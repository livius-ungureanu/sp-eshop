package com.lun.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lun.dto.InventoryItemResponse;
import com.lun.model.Item;
import com.lun.model.StockItem;
import com.lun.repository.ItemRepo;
import com.lun.repository.StockItemRepo;

import lombok.RequiredArgsConstructor;

import com.lun.dto.InventoryItemRequest;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final StockItemRepo stockItemRepo;
    private final ItemRepo itemRepo;

    public void createInventoryItem(InventoryItemRequest inventoryRequest) {

        StockItem stockItem = new StockItem();
        stockItem.setItemId(inventoryRequest.getItemId());
        stockItem.setLocationId(inventoryRequest.getLocationId());
        stockItem.setQuantity(inventoryRequest.getQuantity());

        stockItemRepo.save(stockItem);
    }

    // @@@: improve: retrieve only in one query
    public List<InventoryItemResponse> getInventoryItems() {
        List<StockItem> stockItems = stockItemRepo.findAll();
        List<InventoryItemResponse> inventoryItemResponses =    
        stockItems.stream()
            .map(stockItem -> {
                InventoryItemResponse inventoryItemResponse = new InventoryItemResponse();
                
                // improve: treat the case when item is not found
                // though there is a foreign key constraint in place!
                Item item = itemRepo.findById(stockItem.getItemId()).get();

                inventoryItemResponse.setSku(item.getSku());
                inventoryItemResponse.setItemName(item.getName());
                inventoryItemResponse.setModel(item.getModel());
                inventoryItemResponse.setQuantity(stockItem.getQuantity());

                return inventoryItemResponse;
            })
            .collect(Collectors.toList());
        
        return inventoryItemResponses;
    }
    
    public  Optional<InventoryItemResponse>  getInventoryItem(String sku) {
        Optional<InventoryItemResponse> itemResponseOpt = 
        getInventoryItems()
            .stream()
            .filter(item -> item.getSku().equals(sku))
            .findFirst();
            
        return itemResponseOpt;
    }
}
