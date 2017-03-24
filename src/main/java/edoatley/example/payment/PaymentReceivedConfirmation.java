package edoatley.example.payment;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PaymentReceivedConfirmation {
	private int numberOfPayments;
	private boolean acknowledged;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private ZonedDateTime acknowledgementDateTime;
	
	public PaymentReceivedConfirmation(int numberOfPayments, boolean acknowledged,
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
