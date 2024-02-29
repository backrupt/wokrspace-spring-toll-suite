package practice.guestdao;

import java.util.List;

public class GuestDaoTestMain {

	public static void main(String[] args)throws Exception {
		GuestDao guestDao = new GuestDao();
		//Guest guest = new Guest(0, "고소미", null, "gosomi@naver.com", "http://www.naver.com", "제목", "설명");
		Guest guest = Guest.builder()
				.guestContent("내용")
				.guestEmail("gosomi@naver.com")
				.guestHomepage("http://www/naver.com")
				.guestTitle("제목")
				.guestName("고소미")
				.build();//빌더패턴
		//System.out.println("1.insert:"+guestDao.insert(guest)+"row insert");
		System.out.println("2.findByAll:");
		System.out.println(guestDao.findByAll());
		System.out.println("3.findByGuestNo:"+guestDao.findByGuestNo(6));
		System.out.println("3.findByGuestNo:"+guestDao.findByGuestNo(7));
		System.out.println("4-1.update form 보여주기");
		Guest updateGuest = guestDao.findByGuestNo(6);
		System.out.println(updateGuest);
		updateGuest.setGuestName("정변경");
		updateGuest.setGuestEmail("change@naver.com");
		updateGuest.setGuestTitle("제목변경");
		updateGuest.setGuestContent("내용변경");
		System.out.println("4-2.update:"+guestDao.updateByPk(updateGuest));
		System.out.println(updateGuest);
		System.out.println("5.delete:"+guestDao.deleteByPk(10));
		
		
		
		
		
		
		
	}

}
