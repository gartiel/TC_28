package com.hwua.entity;
/**
 * 
 * <p>Title: User</p>  
 * <p>Description: 用户类</p>  
 * @author Zhang Jiawei 
 * @date 2018年4月19日 下午7:48:49
 */
public class User {
	/**
	* @param id; 用户编号
	* @param username; 用户名
	* @param password; 密码
	* @param sex; 用户性别
	* @param idNumber; 用户身份证号
	* @param tel; 电话
	* @param addr; 地址
	* @param type; 账户类别
	 */
	private long id;
	private String username;
	private String password;
	private int sex;
	private String idNumber;
	private String tel;
	private String addr;
	private int type;
	public User() {}
	public User(long id, String username, String password, int sex, String idNumber, String tel, String addr,
			int type) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.idNumber = idNumber;
		this.tel = tel;
		this.addr = addr;
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", idNumber="
				+ idNumber + ", tel=" + tel + ", addr=" + addr + ", type=" + type + "]";
	}
	
	
}
