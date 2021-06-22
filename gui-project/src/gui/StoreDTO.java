package gui;

/*
 이름     널?       유형           
------ -------- ------------ 
SNO    NOT NULL NUMBER(2)    
SNAME           VARCHAR2(30) 
SPHONE          VARCHAR2(20)
 */


public class StoreDTO {
	private int sno;
	private String sname;
	private String sphone;
	
	public StoreDTO() {
		// TODO Auto-generated constructor stub
		
	}

	public StoreDTO(int sno, String sname, String sphone) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sphone = sphone;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	
	
}
