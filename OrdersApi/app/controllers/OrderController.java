package controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import models.OrderDTO;
import models.OrdersEntity;
import play.mvc.Controller;
import service.IOrdersService;
import service.OrderService;

public class OrderController extends Controller {
	static Gson gson = new Gson();
	static OrdersEntity ordersEntity=new OrdersEntity();
	
	public static void placeOrder() {

		String body = params.get("body");
		OrderDTO orderDTO = gson.fromJson(body, OrderDTO.class);
		IOrdersService orderService = new OrderService();
		orderService.createOrder(orderDTO);
		renderJSON("{\"success\":\"true\"}");

	}
	
	public static void truncateOrder(Long id)  
	{
		OrderService orderService=new OrderService();
		orderService.deleteOrder(id);
		renderJSON("{\"Deletion\":\"Success\"}");
	}
	
	public static void truncateOrderRemotely(Long id) {
		OrderService orderService=new OrderService();
		orderService.deleteOrderRemotely(id);
		renderJSON("{\"Remote_Deletion\":\"Success\"}");
	}

	public static void getOrderDetails(Long id) {
		OrderService orderService=new OrderService();
		/*ordersEntity=orderService.getOrder(id);
		renderJSON(ordersEntity);*/
		
		String jsonString=orderService.getOrder(id);
		renderJSON(jsonString);
	}

	public static void getAllOrderDetails() {
		
		OrderService orderService=new OrderService();
		String allJsontring=orderService.getAllOrder();
		renderJSON(allJsontring);
		
	}

	public static void getAllActiveOrderDetails() {
		IOrdersService ordersService=new OrderService();
		String orderEntitiesList=ordersService.getAllActiveOrder();
		renderJSON(orderEntitiesList);
	}

	

}
