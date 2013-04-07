package tomcat_jk.beans;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private static final long serialVersionUID = 0L;

	/** �A�J�E���g���� */
	private Integer web_account_level;
	
	/** �N�� */
	private Integer age;
	
	/** ���� */
	private String  sex;
	
	/** ���O */
	private String  name;
	
	/** �a�� */
	private String  name_jp;
	
	/** �E�� */
	private String  job;
	
	/** ��� */
	private String  company;
	
	/** ���� */
	private String  dept;
	
	/** ��E */
	private String  yakushoku;
	
	/** E���[���A�h���X */
	private String  e_mail;
	
	/** �s���{�� */
	private String  pref;
	
	/** �Z�� */
	private String  address;
	
	/** �d�b�ԍ� */
	private String  phone;
	
	/** �g�єԍ� */
	private String  cell_phone;
	
	/** ���� */
	private String  memo;

	public Integer getWeb_account_level() {
		return web_account_level;
	}

	public void setWeb_account_level(Integer account_level) {
		this.web_account_level = account_level;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCell_phone() {
		return cell_phone;
	}

	public void setCell_phone(String cell_phone) {
		this.cell_phone = cell_phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_jp() {
		return name_jp;
	}

	public void setName_jp(String name_jp) {
		this.name_jp = name_jp;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPref() {
		return pref;
	}

	public void setPref(String pref) {
		this.pref = pref;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getYakushoku() {
		return yakushoku;
	}

	public void setYakushoku(String yakushoku) {
		this.yakushoku = yakushoku;
	}
	
}
