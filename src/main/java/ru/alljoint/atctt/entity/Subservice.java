package ru.alljoint.atctt.entity;

import org.springframework.data.annotation.Id;

public class Subservice {
	// ID подуслуги
	@Id
	private String subserviceId;
	// Код цели
	private String targetCode;
	// Название подуслуги
	private String name;
	
	public Subservice() {
	}

	public Subservice(String subserviceId, String targetCode, String name) {
		this.subserviceId = subserviceId;
		this.targetCode = targetCode;
		this.name = name;
	}

	public String getSubserviceId() {
		return subserviceId;
	}

	public void setSubserviceId(String subserviceId) {
		this.subserviceId = subserviceId;
	}

	public String getTargetCode() {
		return targetCode;
	}

	public void setTargetCode(String targetCode) {
		this.targetCode = targetCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
