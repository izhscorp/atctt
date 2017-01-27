package ru.alljoint.atctt.entity;

public enum Claim {
	IE("ИП"),
	LE("Юридическое лицо"),
	NP("Физическое лицо");
	
	private final String title;
	
	private Claim(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
}
