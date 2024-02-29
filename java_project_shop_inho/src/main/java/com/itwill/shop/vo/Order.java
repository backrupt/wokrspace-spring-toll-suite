package com.itwill.shop.vo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {
	private int oNo; //PK
	private String o_desc;
	private Date oDate;
	private int oPrice; 
	private User userId; //FK
	
	/*
	 *  Order 1 : OrderItem N
	 *  
	 */
	private List<OrderItem> orderItemList;
}
