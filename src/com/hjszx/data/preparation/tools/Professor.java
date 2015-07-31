package com.hjszx.data.preparation.tools;

public class Professor {
	
	public String pageid;
	public String name;
	public String sex;
	public String birthday;
	public String university;
	public String college;
	public String title;
	public String level; //²©µ¼¡¢Ë¶µ¼
	public String major;
	public String research;
	public String email;
	public String tel;
	public String addr;
	public String zip;
	public String introduction;
	
	@Override
	public String toString() {
		return "[pageid=" + pageid + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday
				+ ", university=" + university + ", college=" + college + ", title=" + title + ", level=" + level
				+ ", major=" + major + ", research=" + research + ", email=" + email + ", tel=" + tel + ", addr=" + addr
				+ ", zip=" + zip + ", introduction=" + introduction + "]";
	}
	
	
	
}
