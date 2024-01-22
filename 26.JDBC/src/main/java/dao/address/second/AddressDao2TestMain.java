package dao.address.second;

public class AddressDao2TestMain {

	public static void main(String[] args) throws Exception{
		AddressDao2 addressDao2=new AddressDao2();
		System.out.println("1.insert");
		addressDao2.insert("삼소라","123-8989","서울");
		addressDao2.insert("사소라","123-8989","서울");
		System.out.println("2.updateByNo");
		addressDao2.updateByNo(10,"채인지","000-1111","대전");
		addressDao2.updateByNo(10,"채민지","000-1111","대전");
		addressDao2.updateByNo(20,"제임스","000-1111","미쿸");
		System.out.println("3.deleteByNo");
		addressDao2.deleteByNo(3);
		System.out.println("4.selectByNo");
		addressDao2.selectByNo(13);
		System.out.println("5.selectAll");
		addressDao2.selectAll();

	}

}