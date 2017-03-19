package edoatley.example.persist;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edoatley.example.payment.Payment;

@RepositoryRestResource
public interface PaymentRepository  extends PagingAndSortingRepository<Payment, Long> {

	public List<Payment> findByDate(@Param("date") ZonedDateTime date);
	public List<Payment> findByPayee(@Param("payee") String payee);
	public List<Payment> findByAmount(@Param("amount") BigDecimal amount);
	
}

