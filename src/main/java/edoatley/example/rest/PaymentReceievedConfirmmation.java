package edoatley.example.rest;

import java.time.ZonedDateTime;

public class PaymentReceievedConfirmmation {
	private int numberOfPayments;
	private boolean acknowledged;
	private ZonedDateTime acknowledgementDateTime;
	
	public PaymentReceievedConfirmmation(int numberOfPayments, boolean acknowledged,
			ZonedDateTime acknowledgementDateTime) {
		super();
		this.numberOfPayments = numberOfPayments;
		this.acknowledged = acknowledged;
		this.acknowledgementDateTime = acknowledgementDateTime;
	}
	public int getNumberOfPayments() {
		return numberOfPayments;
	}
	public boolean isAcknowledged() {
		return acknowledged;
	}
	public ZonedDateTime getAcknowledgementDateTime() {
		return acknowledgementDateTime;
	}
	
	
}
