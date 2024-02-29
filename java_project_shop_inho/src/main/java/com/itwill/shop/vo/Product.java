package com.itwill.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
	private int pNo;
	private String pName;
	private int pPrice;
	private String pImage;
	private String pDesc;
	private int pClickCount;
}
