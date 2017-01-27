package ru.alljoint.atctt.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Service {
	// ID услуги
	@Id
	private String serviceId;
	// Код цели
	private String targetCode;
	// Код формы
	private String formCode;
	// Категория получателей
	private Claim categoryOfRecipients;
	// Подуслуги
	private List<Subservice> subservices;
	// Департамент
	private String department;
	// Название
	private String name;
	// Код ведомства
	private String departmentCode;
	
	public Service() {
	}

	public Service(String serviceId, String targetCode, String formCode, Claim categoryOfRecipients,
			List<Subservice> subservices, String department, String name, String departmentCode) {
		super();
		this.serviceId = serviceId;
		this.targetCode = targetCode;
		this.formCode = formCode;
		this.categoryOfRecipients = categoryOfRecipients;
		this.subservices = subservices;
		this.department = department;
		this.name = name;
		this.departmentCode = departmentCode;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getTargetCode() {
		return targetCode;
	}

	public void setTargetCode(String targetCode) {
		this.targetCode = targetCode;
	}

	public String getFormCode() {
		return formCode;
	}

	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}

	public Claim getCategoryOfRecipients() {
		return categoryOfRecipients;
	}

	public void setCategoryOfRecipients(Claim categoryOfRecipients) {
		this.categoryOfRecipients = categoryOfRecipients;
	}

	public List<Subservice> getSubservices() {
		return subservices;
	}

	public void setSubservices(List<Subservice> subservices) {
		this.subservices = subservices;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
}
