package gui;

/*
이름     널?       유형           
------ -------- ------------ 
MNO    NOT NULL NUMBER(4)    
MNAME           VARCHAR2(10) 
MPHONE          VARCHAR2(20) 
MDATE           DATE         
MPAY            NUMBER(10)   
SNO             NUMBER(2)    
*/

public class MemberDTO {
	private int mno;
	private String mname;
	private String mphone;
	private String mdate;
	private int mpay;
	private int sno;

	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(int mno, String mname, String mphone, String mdate, int mpay, int sno) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.mphone = mphone;
		this.mdate = mdate;
		this.mpay = mpay;
		this.sno = sno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public int getMpay() {
		return mpay;
	}

	public void setMpay(int mpay) {
		this.mpay = mpay;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}
	
	
}
