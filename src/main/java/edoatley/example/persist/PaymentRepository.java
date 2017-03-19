package edoatley.example.persist;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edoatley.example.payment.Payment;

public interface PaymentRepository  extends CrudRepository<Payment, Long> {

	public List<Payment> findByDate(ZonedDateTime date);
	public List<Payment> findByPayee(String payee);
	public List<Payment> findByAmount(BigDecimal amount);
	
}

