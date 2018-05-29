package controllers;

import com.google.gson.Gson;

import PaymentService.PaymentService;
import models.PaymentDTO;
import play.mvc.Controller;

public class PaymentController extends Controller 
{
	static Gson gson=new Gson();
	public static void createOrder()
	{
		String body =params.get("body");
		PaymentDTO paymentDTO=gson.fromJson(body,PaymentDTO.class);
		PaymentService paymentService=new PaymentService();
		paymentService.insertPaymentDetails(paymentDTO);
		renderJSON("{\"success\":\"Payment Details Inserted\"}");
		
	}

	
	public static void deleteOrder(long id)
	{
		PaymentService paymentService=new PaymentService();
		paymentService.deletePaymentDetails(id);
	}
}
