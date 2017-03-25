package edoatley.example.payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Payment {

	private static final DateTimeFormatter PAYMENT_DATE_AS_STRING_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
	
	private String payee;
	
	private BigDecimal amount;
	
	protected Payment() {} // JPA only
	
	public Payment(LocalDate date, String payee, BigDecimal amount) {
		super();
		this.date = date;
		this.payee = payee;
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getPayee() {
		return payee;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	
	@Override
    public String toString() {
		return String.format("Payment[id=%d, date=%s, payee=%s, amount=%s]", id
				           , PAYMENT_DATE_AS_STRING_FORMAT.format(date), payee, amount);
	}
}
