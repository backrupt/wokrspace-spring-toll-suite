package com.itwill.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
	private int cartNo;
	/*********FK*********/
	private User  user;
	/*********FK*********/
	private Product product;
	private int cartQty;
}
