package com.manino.springboot.app.items.service;

import com.manino.springboot.app.items.models.Item;
import com.manino.springboot.app.items.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        List <Producto> productos = Arrays.asList(clienteRest.getForObject("http//localhost:8001/listar", Producto[].class));
        return productos.stream().map(p -> new Item (p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, int cantidad) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
       Producto prod = clienteRest.getForObject("http//localhost:8001/ver/{id}", Producto.class);
        return new Item(prod,cantidad);
    }
}
