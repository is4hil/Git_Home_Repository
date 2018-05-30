package controllers;

import com.google.gson.Gson;

import service.PaymentService;
import models.PaymentDTO;
import play.mvc.Controller;
import service.IPaymentService;

public class PaymentController extends Controller 
{
	static Gson gson=new Gson();
	public static void createOrder()
	{
		String body =params.get("body");
		PaymentDTO paymentDTO=gson.fromJson(body,PaymentDTO.class);
		IPaymentService paymentService=new PaymentService();
		paymentService.insertPaymentDetails(paymentDTO);
		renderJSON("{\"success\":\"Payment Details Inserted\"}");
		
	}

	
	public static void deleteOrder(long id)
	{
		IPaymentService paymentService=new PaymentService();
		paymentService.deletePaymentDetails(id);
	}
}
