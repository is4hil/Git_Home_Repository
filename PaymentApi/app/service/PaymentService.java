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
				System.out.println("Successfully Deleted from Payment_Table");
		
	}

	@Override
	public void deletePaymentDetailsremotely(Long id) {
		int iid=id.intValue();
		PaymentEntity paymentEntity=PaymentEntity.find("orderId = ?" ,iid).first();
		System.out.println(paymentEntity);
		System.out.println(paymentEntity.getStatus());
		
		IStatusModule iStatusModule=new IStatusModule();
		paymentEntity.setStatus(iStatusModule.IN_ACTIVE);
		
		System.out.println(paymentEntity.getStatus());
		paymentEntity.save();
		System.out.println(paymentEntity.getStatus());
		System.out.println("Deleted from Payment_Table Remotely");
		
	}
		
	}


