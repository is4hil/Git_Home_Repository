package service;

import com.google.gson.Gson;

import controllers.StatusModule.IStatusModule;
import models.OrderDTO;
import models.OrdersEntity;
import models.PaymentDTO;
import play.libs.WS;
import play.libs.WS.HttpResponse;
import play.libs.WS.WSRequest;

public class OrderService implements IOrdersService {

	private final String PAYMENT_APP_URL = "http://localhost:9000/";
	static Gson gson = new Gson();

	public void createOrder(OrderDTO orderDTO) {
		OrdersEntity ordersEntity = new OrdersEntity(orderDTO.getProductName(), orderDTO.getProductPrice(),
				orderDTO.getPaymentMode(),IStatusModule.ACTIVE);
		ordersEntity.save();

		String createPaymentUrl = new StringBuilder(PAYMENT_APP_URL).append("payments/createorder/").toString();

		PaymentDTO paymentDTO = new PaymentDTO();
		/*paymentDTO.setOrderId(orderDTO.getOrderId());
		paymentDTO.setAmtReceived(orderDTO.getProductPrice());
		paymentDTO.setPaymentMode(orderDTO.getPaymentMode());
		 */
		
		paymentDTO.setOrderId(ordersEntity.getId().intValue());
		paymentDTO.setAmtReceived(ordersEntity.getProductPrice());
		paymentDTO.setPaymentMode(ordersEntity.getPaymentMode());
		
		
		
		String paymentJsonFormate = gson.toJson(paymentDTO);
		WSRequest request = WS.url(createPaymentUrl).setHeader("Content-Type", "application/json");
		request.body = paymentJsonFormate;
		try {
			HttpResponse httpResponse = request.post();
			System.out.println(httpResponse.getStatusText());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteOrder(Long id) {
		OrderDTO orderDTO=new OrderDTO();
		OrdersEntity ordersEntity = new OrdersEntity(orderDTO.getProductName(), orderDTO.getProductPrice(),
				orderDTO.getPaymentMode(),IStatusModule.ACTIVE);
		ordersEntity.delete("delete from OrdersEntity where id=?", id);
		
		String createPaymentUrl = new StringBuilder(PAYMENT_APP_URL).append("payments/deleteorder/").toString();
		WSRequest request = WS.url(createPaymentUrl).setHeader("Content-Type", "application/json");
		request.get();
		try {
			HttpResponse httpResponse = request.delete();
			System.out.println(httpResponse.getStatusText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
