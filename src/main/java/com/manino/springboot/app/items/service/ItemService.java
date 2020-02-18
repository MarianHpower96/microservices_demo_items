package com.manino.springboot.app.items.service;

import com.manino.springboot.app.items.models.Item;

import java.util.List;

public interface ItemService {

    public List<Item> findAll();

    public Item findById(Long i, int cantidad);
}
