package com.kike.datos;

import java.io.*;
import java.util.*;

import com.kike.dtos.*;

public class ProductIO {


	public static Product getProduct(String code, String filepath) {
		try {
			File file = new File(filepath);
			BufferedReader in = new BufferedReader(new FileReader(file));

			String line = in.readLine();
			while (line != null) {
				StringTokenizer t = new StringTokenizer(line, "-");
				String productCode = t.nextToken();
				if (code.equalsIgnoreCase(productCode)) {
					String description = t.nextToken();
					double price = Double.parseDouble(t.nextToken());
					Product p = new Product();
					p.setCodigo(code);
					p.setDescripcion(description);
					p.setPrecio(price);
					in.close();
					return p;
				}
				line = in.readLine();
			}
			in.close();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}