package com.kike.controladores;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kike.datos.ProductIO;
import com.kike.dtos.Cesta;
import com.kike.dtos.Item;
import com.kike.dtos.Product;

/**
 * Servlet implementation class ControladorUno
 */

@WebServlet("/carrito")
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarritoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productCode = request.getParameter("productCode");
		String quantityAsString = request.getParameter("quantity");

		HttpSession session = request.getSession();

		// Obtenemos la cesta guardada en la sesión, si no existe creamos el atributo cesta
		Cesta cesta = (Cesta) session.getAttribute("cesta");
		if (cesta == null) {
			cesta = new Cesta();
			session.setAttribute("cesta", cesta.getItems());
		}

		// Si el usuario introduce un -1 o un caracter inválido
		// la quantity se resetea a 1
		int quantity = 1;
		try {
			quantity = Integer.parseInt(quantityAsString);
			if (quantity < 0)
				quantity = 1;

		} catch (NumberFormatException nfe) {
			quantity = 1;
		}

		ServletContext sc = getServletContext();
		String path = sc.getRealPath("WEB-INF/products.txt");
		Product product = ProductIO.getProduct(productCode, path);

		Item lineItem = new Item();
		lineItem.setProducto(product);
		lineItem.setCantidad(quantity);

		if (quantity > 0)
			cesta.addItem(lineItem);
		if (quantity <= 0)
			cesta.eliminarItem(lineItem);

		session.setAttribute("cesta", cesta);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/cesta.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

}