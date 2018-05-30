package service;

import controllers.StatusModule.IStatusModule;
import models.PaymentDTO;
import models.PaymentEntity;

public class PaymentService implements IPaymentService {

	/*public void insertPaymentDetails(PaymentDTO paymentDTO) {
		PaymentEntity paymentEntity=new PaymentEntity(paymentDTO.getOrderId(),paymentDTO.getAmtReceived(),paymentDTO.getPaymentMode());
		paymentEntity.save();}*/
		
	public void insertPaymentDetails(PaymentDTO paymentDTO)
	{
		PaymentEntity  paymentEntity=new PaymentEntity(paymentDTO.getOrderId(), paymentDTO.getAmtReceived(), paymentDTO.getPaymentMode(),IStatusModule.ACTIVE);
		paymentEntity.save();
	}

	public void deletePaymentDetails(long id) {
		PaymentEntity  paymentEntity=new PaymentEntity();
		paymentEntity.delete("delete from PaymentEntity where id=?", id);
				
		
	}
		
	}


