package edoatley.example.persist;

import org.springframework.data.repository.CrudRepository;

import edoatley.example.payment.Payment;

public interface PaymentRepository  extends CrudRepository<Payment, Long> {

}

