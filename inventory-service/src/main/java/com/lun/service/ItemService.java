package com.lun.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lun.dto.ItemRequest;
import com.lun.model.Item;
import com.lun.repository.ItemRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepo itemRepository;

    public void createItem(ItemRequest itemRequest) {
        itemRepository
            .save(Item.builder()
                    .name(itemRequest.getName())
                    .sku(itemRequest.getSku())
                    .model(itemRequest.getModel())
                    .build());
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }
}
