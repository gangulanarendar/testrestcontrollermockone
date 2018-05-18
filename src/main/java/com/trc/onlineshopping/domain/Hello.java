package com.trc.onlineshopping.domain;
public class Hello
    {
	
	Hello()
	{
		
	}
    	private String message;
    	private String value;
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Hello(String message, String value) {
			super();
			this.message = message;
			this.value = value;
		}
    	
    	
    }