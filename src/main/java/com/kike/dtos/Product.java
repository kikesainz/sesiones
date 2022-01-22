package com.kike.dtos;

import java.io.Serializable;
import java.text.NumberFormat;

public class Product implements Serializable {
	private String codigo;
	private String descripcion;
	private double precio;

	public Product() {
		codigo = "";
		descripcion = "";
		precio = 0;
	}



	public String getCodigo() {
		return codigo;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public double getPrecio() {
		return precio;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public String getPriceCurrencyFormat() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(precio);
	}
}