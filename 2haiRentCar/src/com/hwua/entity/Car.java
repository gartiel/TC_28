package com.hwua.entity;
/**
 * 
 * <p>Title: Car</p>  
 * <p>Description: 汽车类</p>  
 * @author Zhang Jiawei 
 * @date 2018年4月19日 下午7:37:09
 */
public class Car {
	/**
    * @param id; 汽车编号
	* @param carNumber; 车牌号
	* @param  brandId; 品牌编号
	* @param  model; 汽车型号
	* @param  color; 颜色
	* @param  categoryId; 类型编号
	* @param  tComments; 汽车简介
	* @param  price; 汽车市场价
	* @param  rent; 每日租金
	* @param  status; 汽车状态
	* @param  useable; 汽车是否上架
	* @param  brandName; 品牌名
	* @param  cateName; 类型名
	* @param  startDate; 出借日期
	* @param  returnDate; 还车日期
	* @param  payment; 总租金
	* @param  recordId; 租车记录编号
	* @param  userId; 用户编号
	* @param  userName; 用户名
	 */
	private long id;
	private String carNumber;
	private long brandId;
	private String model;
	private String color;
	private long categoryId;
	private String tComments;
	private double price;
	private double rent;
	private int status;
	private int useable;
	private String brandName;
	private String cateName;
	private String startDate;
	private String returnDate;
	private double payment;
	private long recordId;
	private long userId;
	private String userName;
	public Car() {}
	public Car(long id, String carNumber, long brandId, String model, String color, long categoryId, String tComments,
			double price, double rent, int status, int userable, String brandName, String cateName) {
		this.id = id;
		this.carNumber = carNumber;
		this.brandId = brandId;
		this.model = model;
		this.color = color;
		this.categoryId = categoryId;
		this.tComments = tComments;
		this.price = price;
		this.rent = rent;
		this.status = status;
		this.useable = userable;
		this.brandName = brandName;
		this.cateName = cateName;
	}
	
	
	
	public Car(long id, String carNumber, long brandId, String model, String color, long categoryId, String tComments,
			double price, double rent, int status, int useable) {
		this.id = id;
		this.carNumber = carNumber;
		this.brandId = brandId;
		this.model = model;
		this.color = color;
		this.categoryId = categoryId;
		this.tComments = tComments;
		this.price = price;
		this.rent = rent;
		this.status = status;
		this.useable = useable;
	}
	public Car(long recordId,long id, String model, double payment, String tComments, String brandName, String cateName,
			String startDate, String returnDate) {
		this.recordId=recordId;
		this.id = id;
		this.model = model;
		this.payment = payment;
		this.tComments = tComments;
		this.brandName = brandName;
		this.cateName = cateName;
		this.startDate = startDate;
		this.returnDate = returnDate;
	}
	public Car(long id, String carNumber, long brandId, String model, String color, long categoryId, String tComments,
			double price, double rent, int status, int useable, String brandName, String cateName, String startDate) {
 		this.id = id;
		this.carNumber = carNumber;
		this.brandId = brandId;
		this.model = model;
		this.color = color;
		this.categoryId = categoryId;
		this.tComments = tComments;
		this.price = price;
		this.rent = rent;
		this.status = status;
		this.useable = useable;
		this.brandName = brandName;
		this.cateName = cateName;
		this.startDate = startDate;
	}
	public Car(long id, String carNumber, long brandId, String model, long categoryId, String tComments, double rent,
			int status, int useable, String brandName, String cateName, String startDate, String returnDate,
			double payment) {
		this.id = id;
		this.carNumber = carNumber;
		this.brandId = brandId;
		this.model = model;
		this.categoryId = categoryId;
		this.tComments = tComments;
		this.rent = rent;
		this.status = status;
		this.useable = useable;
		this.brandName = brandName;
		this.cateName = cateName;
		this.startDate = startDate;
		this.returnDate = returnDate;
		this.payment = payment;
	}
	
	
	
	public Car(long id, String carNumber, long brandId, String model, String color, long categoryId, String tComments,
			double price, double rent, int status, int useable, String brandName, String cateName, String startDate,
			String returnDate, double payment) {
		this.id = id;
		this.carNumber = carNumber;
		this.brandId = brandId;
		this.model = model;
		this.color = color;
		this.categoryId = categoryId;
		this.tComments = tComments;
		this.price = price;
		this.rent = rent;
		this.status = status;
		this.useable = useable;
		this.brandName = brandName;
		this.cateName = cateName;
		this.startDate = startDate;
		this.returnDate = returnDate;
		this.payment = payment;
	}
	
	public Car(long recordId,long id, String model, long userId, String userName,double rent,double payment, String tComments, String brandName, String cateName,
			String startDate, String returnDate) {
		this.id = id;
		this.model = model;
		this.tComments = tComments;
		this.rent = rent;
		this.brandName = brandName;
		this.cateName = cateName;
		this.startDate = startDate;
		this.returnDate = returnDate;
		this.payment = payment;
		this.recordId = recordId;
		this.userId = userId;
		this.userName = userName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getRecordId() {
		return recordId;
	}
	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public long getBrandId() {
		return brandId;
	}
	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String gettComments() {
		return tComments;
	}
	public void settComments(String tComments) {
		this.tComments = tComments;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUserable() {
		return useable;
	}
	public void setUserable(int userable) {
		this.useable = userable;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", carNumber=" + carNumber + ", brandId=" + brandId + ", model=" + model + ", color="
				+ color + ", categoryId=" + categoryId + ", tComments=" + tComments + ", price=" + price + ", rent="
				+ rent + ", status=" + status + ", userable=" + useable + ", brandName=" + brandName + ", cateName="
				+ cateName + "]";
	}
	
	
	
}
