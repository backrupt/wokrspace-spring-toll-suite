package dao.address.third;

import java.util.List;

public class AddressDao3TestMain {

	public static void main(String[] args) throws Exception{
		AddressDao3 addressDao3=new AddressDao3();
		System.out.println("1.insert");
		Address insertAddress = new Address(0,"김수미","666-6666","CA");
		System.out.println(">> insert row count:"+addressDao3.insert(insertAddress));
		
		System.out.println("2.updateByNo");
		Address updateAddress = new Address(10,"텐수정","1313-4545","북한");
		System.out.println(">> update row count:"+addressDao3.updateByNo(updateAddress));
		addressDao3.updateByNo(new Address(18,"시팔수정","1818-1818","제주"));
		System.out.println("3.deleteByNo");
		System.out.println(">> delete row count:"+addressDao3.deleteByNo(3));
		System.out.println("4.selectByNo");
		addressDao3.selectByNo(13);
		Address findAddress = addressDao3.selectByNo(10);
		System.out.println(findAddress);
		System.out.println("5.selectAll");
		List<Address> addressList = addressDao3.selectAll();
		for (Address address : addressList) {
			System.out.println(address);
		}

	}

}