package practice.guestdao;



import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
이름             널?       유형             
-------------- -------- -------------- 
GUEST_NO       NOT NULL NUMBER(10)     
GUEST_NAME     NOT NULL VARCHAR2(50)   
GUEST_DATE     NOT NULL DATE           
GUEST_EMAIL             VARCHAR2(50)   
GUEST_HOMEPAGE          VARCHAR2(50)   
GUEST_TITLE    NOT NULL VARCHAR2(100)  
GUEST_CONTENT  NOT NULL VARCHAR2(4000) 
*/
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guest {
	private int guestNo;
	private String guestName;
	private Date guestDate;
	private String guestEmail;
	private String guestHomepage;
	private String guestTitle;
	private String guestContent;
	@Override
	public String toString() {
		return "Guest [guestNo=" + guestNo + ", guestName=" + guestName + ", guestDate=" + guestDate + ", guestEmail="
				+ guestEmail + ", guestHomepage=" + guestHomepage + ", guestTitle=" + guestTitle + ", guestContent="
				+ guestContent + "]\n";
	}
}
