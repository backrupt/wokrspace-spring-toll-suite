package dao.address;

import java.util.List;

public class AddressDaoTestMain {

	public static void main(String[] args) throws Exception{
		AddressDao addressDao=new AddressDao();
		System.out.println("1.insert");
		Address insertAddress = new Address(0,"김수미","666-6666","CA");
		System.out.println(">> insert row count:"+addressDao.insert(insertAddress));
		
		System.out.println("2.updateByNo");
		Address updateAddress = new Address(10,"텐수정","1313-4545","북한");
		System.out.println(">> update row count:"+addressDao.updateByNo(updateAddress));
		addressDao.updateByNo(new Address(18,"시팔수정","1818-1818","제주"));
		System.out.println("3.deleteByNo");
		System.out.println(">> delete row count:"+addressDao.deleteByNo(3));
		System.out.println("4.selectByNo");
		addressDao.selectByNo(13);
		Address findAddress = addressDao.selectByNo(10);
		System.out.println(findAddress);
		System.out.println("5.selectAll");
		List<Address> addressList = addressDao.selectAll();
		for (Address address : addressList) {
			System.out.println(address);
		}

	}

}