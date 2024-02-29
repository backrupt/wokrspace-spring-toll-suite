package com.itwill.shop;

import java.util.List;

import com.itwill.shop.dao.CartDao;
import com.itwill.shop.vo.Cart;
import com.itwill.shop.vo.Product;
import com.itwill.shop.vo.User;

public class CartDaoTestMain {

	public static void main(String[] args) throws Exception {
		CartDao cartDao=new CartDao();
		System.out.println("1.add(insert)");
//		cartDao.insert(Cart.builder()
//				.user(User.builder().userId("dlsgh2").build())
//				.product(Product.builder().pNo(7).build())
//				.cartQty(7)
//				.build());
		System.out.println(">>> cart insert");
		System.out.println("2.updateByCartNo");
		System.out.println(cartDao.updateByCartNo(Cart.builder().cartNo(1).cartQty(10).build()));
		System.out.println("3.updateByProductNo");
		System.out.println(cartDao.updateByProductNo(Cart.builder()
				.user(User.builder()
						.userId("dlsgh1")
						.build())
				.product(Product.builder()
						.pNo(1)
						.build())
				.cartQty(3)
				.build()));
		
		
		System.out.println("4.delete");
		
		System.out.println("5.cartList[select]");
		System.out.println(cartDao.countByProductNo("dlsgh1", 1));
		List<Cart> cartList1=cartDao.findByUserId("guard1");
		System.out.println(cartList1);
		System.out.println("6.selectProductCount");
	
		
	}
}
