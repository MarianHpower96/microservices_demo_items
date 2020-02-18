package com.manino.springboot.app.items.models;

public class Item {

    Producto producto;
    Double cantidad;



    public Item(Producto producto, Double cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal(){
        return producto.getPrecio() * cantidad;
    }
}
