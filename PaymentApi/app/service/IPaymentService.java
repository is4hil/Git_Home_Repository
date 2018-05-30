package service;

import models.PaymentDTO;

public interface IPaymentService {

	void insertPaymentDetails(PaymentDTO paymentDTO);

	void deletePaymentDetails(long id);

	void deletePaymentDetailsremotely(Long id);

}
