/*
 	This class is not used at this point, it is designed for the further implementation, such as consider the DB design
 */
package com.ebay.validshipping.model;

import java.util.ArrayList;
import java.util.List;

public class ShippingProgramItem {

	private String title;
	private String seller;
	private Integer category;
	private double price;

	public ShippingProgramItem(String title, String seller, Integer category, double price) {

		this.title = title;
		this.seller = seller;
		this.category = category;
		this.price = price;
	}

}
