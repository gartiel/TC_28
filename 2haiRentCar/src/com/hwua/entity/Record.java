package com.hwua.entity;


public class Record {

	private long id;
	private long carId;
	private String model;
	private long userId;
	private String userName;
	private Double rent;
	private double payment;
	private String tComments;
	private String BandName;
	private String CategoryName;
	private String startDate;
	private String returnDate;

	public Record(long userId, long carId, String startDate, String returnDate, double payment) {
		this.userId = userId;
		this.carId = carId;
		this.startDate = startDate;
		this.returnDate = returnDate;
		this.payment = payment;
	}

	public Record(long id, long carId, String model, long userId, String userName, Double rent, double payment,
			String tComments, String bandName, String categoryName, String startDate, String returnDate) {
		this.id = id;
		this.carId = carId;
		this.model = model;
		this.userId = userId;
		this.userName = userName;
		this.rent = rent;
		this.payment = payment;
		this.tComments = tComments;
		BandName = bandName;
		CategoryName = categoryName;
		this.startDate = startDate;
		this.returnDate = returnDate;
	}

	public Record(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getRent() {
		return rent;
	}

	public void setRent(Double rent) {
		this.rent = rent;
	}

	public String gettComments() {
		return tComments;
	}

	public void settComments(String tComments) {
		this.tComments = tComments;
	}

	public String getBandName() {
		return BandName;
	}

	public void setBandName(String bandName) {
		BandName = bandName;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
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

	public Record() {

	}

	public Record(long id, long userId, long carId, String startDate, String returnDate, double payment) {
		this.id = id;
		this.userId = userId;
		this.carId = carId;
		this.startDate = startDate;
		this.returnDate = returnDate;
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", userId=" + userId + ", carId=" + carId + ", startDate=" + startDate
				+ ", returnDate=" + returnDate + ", payment=" + payment + "]";
	}

}
