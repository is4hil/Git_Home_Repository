package controllers;

import com.google.gson.Gson;

import models.OrderDTO;
import play.mvc.Controller;
import service.IOrdersService;
import service.OrderService;

public class OrderController extends Controller {
	static Gson gson = new Gson();

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
		renderJSON("{\"success\":\"true\"}");
	}

}
