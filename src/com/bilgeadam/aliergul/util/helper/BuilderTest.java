package com.bilgeadam.aliergul.util.helper;

public class BuilderTest {
	private String name;
	private String surname;
	
	// asıl methodun
	public BuilderTest(Builder builder) {
		this.name = builder.name;
		this.surname = builder.surname;
		
	}
	
	public static void main(String[] args) {
		BuilderTest test = new BuilderTest.Builder().soyisim("ergul").build();
		
	}
	
	// **************************** inşa edici sınıf.
	static class Builder {
		
		private String name;
		private String surname;
		
		public Builder isim(String name) {
			this.name = name;
			return this;
		}
		
		public Builder soyisim(String surname) {
			this.surname = surname;
			return this;
		}
		
		public BuilderTest build() {
			
			return new BuilderTest(this);
		}
	}
	
}
