package ru.alljoint.atctt.entity;

import java.util.Date;

public class Person {
	// идентификатор заявителя
	private String personId;
	// ФИО
	private String fullName;
	// идентификатор заявки
	private String orderId;
	// идентификатор услуги
	private String serviceId;
	// дата создания
	private Date createDate;
	// статус (открыта, закрыта)
	private boolean status;
	
	public Person() {
	}

	public Person(String personId, String fullName, String orderId, String serviceId, Date createDate, boolean status) {
		super();
		this.personId = personId;
		this.fullName = fullName;
		this.orderId = orderId;
		this.serviceId = serviceId;
		this.createDate = createDate;
		this.status = status;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
