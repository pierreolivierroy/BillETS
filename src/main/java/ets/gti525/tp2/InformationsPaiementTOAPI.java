package ets.gti525.tp2;

import java.math.BigDecimal;

import gti525.paiement.InformationsPaiementTO;

public class InformationsPaiementTOAPI {
	private String api_key;
	private int store_id;
	private long order_id;
	private String first_name;
	private String last_name;
	private String card_number;
	private String security_code;
	private int year;
	private int month;
	private BigDecimal amount;
	
	public InformationsPaiementTOAPI(InformationsPaiementTO info) {
		this.api_key = info.getApi_key();
		this.store_id = info.getStore_id();
		this.order_id = info.getOrder_id();
		this.first_name = info.getFirst_name();
		this.last_name = info.getLast_name();
		this.card_number = Long.toString(info.getCard_number());
		this.security_code = Integer.toString(info.getSecurity_code());
		this.year = info.getYear();
		this.month = info.getMonth();
		this.amount = info.getAmount();
	}

	public String getApi_key() {
		return api_key;
	}

	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public String getSecurity_code() {
		return security_code;
	}

	public void setSecurity_code(String security_code) {
		this.security_code = security_code;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
