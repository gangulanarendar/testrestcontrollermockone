package com.trc.onlineshopping.domain;

import java.io.Serializable;

public class Transaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long transid;
	private String transBank;
	private String cardNumber;
	private String carHolderName;
	private String cvv;

	public long getTransid() {
		return transid;
	}

	public void setTransid(long transid) {
		this.transid = transid;
	}

	public String getTransBank() {
		return transBank;
	}

	public void setTransBank(String transBank) {
		this.transBank = transBank;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCarHolderName() {
		return carHolderName;
	}

	public void setCarHolderName(String carHolderName) {
		this.carHolderName = carHolderName;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Transaction [transid=" + transid + ", transBank=" + transBank + ", cardNumber=" + cardNumber
				+ ", carHolderName=" + carHolderName + ", cvv=" + cvv + "]";
	}

	public Transaction() {
		super();

	}

	public Transaction(long transid, String transBank, String cardNumber, String carHolderName, String cvv) {
		super();
		this.transid = transid;
		this.transBank = transBank;
		this.cardNumber = cardNumber;
		this.carHolderName = carHolderName;
		this.cvv = cvv;
	}

}
