package PaymentService;

import models.PaymentDTO;
import models.PaymentEntity;

public class PaymentService {

	/*public void insertPaymentDetails(PaymentDTO paymentDTO) {
		PaymentEntity paymentEntity=new PaymentEntity(paymentDTO.getOrderId(),paymentDTO.getAmtReceived(),paymentDTO.getPaymentMode());
		paymentEntity.save();}*/
		
	public void insertPaymentDetails(PaymentDTO paymentDTO)
	{
		PaymentEntity  paymentEntity=new PaymentEntity(paymentDTO.getOrderId(), paymentDTO.getAmtReceived(), paymentDTO.getPaymentMode());
		paymentEntity.save();
	}
		
	}


