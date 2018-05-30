package service;

import java.util.ArrayList;
import java.util.List;

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
	static List<OrdersEntity> ordersEntities=new ArrayList();

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
		//OrderDTO orderDTO=new OrderDTO();
		/*OrdersEntity ordersEntity = new OrdersEntity(orderDTO.getProductName(), orderDTO.getProductPrice(),
				orderDTO.getPaymentMode(),IStatusModule.ACTIVE);*/
		OrdersEntity ordersEntity = new OrdersEntity();
		ordersEntity.delete("delete from OrdersEntity where id=?", id);
		System.out.println("Successfully Deleted from Order Table");
		
		String createTruncateUrl = new StringBuilder(PAYMENT_APP_URL).append("payments/deleteorder/").append(id).toString();
		WSRequest request = WS.url(createTruncateUrl).setHeader("Content-Type", "application/json");
		request.delete();
		
		/*try 
		{
			HttpResponse httpResponse = request.delete();
			System.out.println("Successfully Request Sent ");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}*/
		
		
	}

	public String getOrder(Long id) {
		OrdersEntity ordersEntity = new OrdersEntity();
		/*ordersEntity=ordersEntity.findById(id);
		return ordersEntity;*/
		
		ordersEntity=ordersEntity.findById(id);
		return gson.toJson(ordersEntity);
		}

	public String getAllOrder() {
		OrdersEntity ordersEntity = new OrdersEntity();
		List<OrdersEntity> orderList=new ArrayList();
		orderList=ordersEntity.findAll();
		return gson.toJson(orderList);
	}

	public void deleteOrderRemotely(Long id) {
		OrdersEntity ordersEntity=new OrdersEntity();
		ordersEntity=ordersEntity.findById(id);
		
		System.out.println(ordersEntity.getStatus());
		System.out.println(IStatusModule.IN_ACTIVE);
		
		ordersEntity.setStatus(IStatusModule.IN_ACTIVE);
		
		System.out.println(ordersEntity.getStatus());
		
		ordersEntity.save();
		System.out.println("Deleted from Orders_Table Remotely");
		String createTruncateUrl = new StringBuilder(PAYMENT_APP_URL).append("payments/deleteorderremotely/").append(id).toString();
		WSRequest request = WS.url(createTruncateUrl).setHeader("Content-Type", "application/json");
		request.delete();
		
	}

	@Override
	public String getAllActiveOrder() {
		OrdersEntity ordersEntity=new OrdersEntity();
		ordersEntities=ordersEntity.find("status=?", IStatusModule.ACTIVE).fetch();
		return gson.toJson(ordersEntities);
	}

	

	

}
