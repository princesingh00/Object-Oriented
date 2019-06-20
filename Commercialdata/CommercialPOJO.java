package com.bridgeit.objectoriented.Commercialdata;

public class CommercialPOJO {

	private String companyName;
	private String symbol;
	private String shareValue;
	private int totalShares;
	private String date;
	private int totalPrice;

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getShareValue() {
		return shareValue;
	}

	public void setShareValue(String shareValue) {
		this.shareValue = shareValue;
	}

	public int getTotalShares() {
		return totalShares;
	}

	public void setTotalShares(int totalShares) {
		this.totalShares = totalShares;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
