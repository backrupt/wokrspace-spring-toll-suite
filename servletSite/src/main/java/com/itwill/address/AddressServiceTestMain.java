


package com.itwill.address;

public class AddressServiceTestMain {

	public static void main(String[] args) throws Exception{
		AddressService addressService=
				new AddressService();
		addressService.addressList();
		
		System.out.println("1.주소록리스트");
		System.out.println(addressService.addressList());
		System.out.println("2.주소록상세보기");
		Address updateAddress = addressService.addressDetail(10);
		System.out.println(updateAddress);
		System.out.println("3.주소록수정");
		updateAddress.setName("체인지");
		updateAddress.setPhone("000-0000");
		System.out.println(">> update row count:"+addressService.addressUpdate(updateAddress));
		System.out.println("4.주소록삭제");
		System.out.println(">> delete row coutn:"+addressService.addressDelete(11));
	}

}
