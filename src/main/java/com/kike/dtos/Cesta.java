package com.kike.dtos;

import java.io.Serializable;
import java.util.ArrayList;

public class Cesta implements Serializable {
	private ArrayList<Item> items;

	public Cesta() {
		items = new ArrayList<Item>();
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public int getCount() {
		return items.size();
	}

	/**
	 * Añade un item a la cesta de la compra Si el item ya está en la cesta suma uno
	 * a la cantidad
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		String code = item.getProducto().getCodigo();
		int quantity = item.getCantidad();
		for (int i = 0; i < items.size(); i++) {
			Item lineItem = items.get(i);
			//Compruebo si el producto está en la cesta, si está le seteo la cantidad
			if (lineItem.getProducto().getCodigo().equals(code)) {
				lineItem.setCantidad(quantity);
				return;
			}
		}
		//Si no está en la cesta, simplemente lo añado
		items.add(item);
	}

	public void eliminarItem(Item item) {
		String code = item.getProducto().getCodigo();
		for (int i = 0; i < items.size(); i++) {
			Item lineItem = items.get(i);
			if (lineItem.getProducto().getCodigo().equals(code)) {
				items.remove(i);
				return;
			}
		}
	}
}