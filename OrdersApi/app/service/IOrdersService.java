package service;

import models.OrderDTO;

public interface IOrdersService {
	
	void createOrder(OrderDTO orderDT);
	
	void deleteOrder(Long id);

	String getAllActiveOrder();
	
	
}
