package com.cts.mc.order.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.mc.order.dao.OrderRepository;
import com.cts.mc.order.exception.OrderException;
import com.cts.mc.order.model.EmailMessage;
import com.cts.mc.order.model.Order;

@Service
public class OrderProductService implements IOrderProductService {
	static Logger log = Logger.getLogger(OrderProductService.class.getName());
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	OrderRepository orderRepository;

	@Override

	public Order addProductToCart(Order order) throws OrderException {
		Order orderInCart = null ;
			orderInCart=orderRepository.save(order);
		return orderInCart;
	}

	@Override
	public List<Order> listCartProducts(int orderProductId) throws OrderException {
		 List<Order> cartProducts =  orderRepository.findByOrderProductId(orderProductId);
			
		 cartProducts.forEach(item->{
				if(orderProductId ==item.getOrderProductId()){
					log.info("OrderProductId  is available");
				} 
			});
			
			if (cartProducts.stream().count() < 0) {
				log.info("Cart Product  List is empty");
				 throw new OrderException("The given Order Product  is does not Exist");
			}
			
		return cartProducts;
	}

	@Override
	public String checkoutOrders(int orderProductId) throws OrderException {
		List<Order> orders = listCartProducts(orderProductId);
		for (Order order : orders) {		
		EmailMessage emailMessage = new EmailMessage();
		emailMessage.setToAddress("ybaburao@gmail.com");
		emailMessage.setOrderId(order.getOrderId());
		emailMessage.setBody("Your order for the Order id: "+orderProductId+ " is confirmed");
		restTemplate.getForObject("https://emailconfirmationservice/email/send",EmailMessage.class,emailMessage);
		}
		return "Your Order Confirmed";
	}
}

