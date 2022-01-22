package com.kike.dtos;

import java.io.Serializable;
import java.text.NumberFormat;

public class Item implements Serializable
{
    private Product producto;
    private int cantidad;
    
    public Item() {}
    

    
    public Product getProducto() {
		return producto;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setProducto(Product producto) {
		this.producto = producto;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public double getTotal()
    { 
        double total = producto.getPrecio() * cantidad;
        return total;
    }
    
    public String getTotalCurrencyFormat()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}