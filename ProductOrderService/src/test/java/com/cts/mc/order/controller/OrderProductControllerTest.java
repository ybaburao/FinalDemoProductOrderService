package com.cts.mc.order.controller;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.mc.order.exception.OrderException;
import com.cts.mc.order.model.Order;

@SpringBootTest
public class OrderProductControllerTest {

	@Autowired
	private OrderProductController orderProductController;
	@Test
	 void addProductTest() throws OrderException {
		Order order = new Order();
		order.setOrderId(1L);
		order.setPrice(10.0);
		order.setOrderProductId(2);
		order.setNoOfUnits(789);
		order.setUserId(45L);
		Order orderProduct = orderProductController.addProductToCart(order);
		assertNotNull(orderProduct);
	
	}

	@Test
	 void listCartProductsTest() throws OrderException {
		Order order = new Order();
		order.setOrderId(1L);
		order.setPrice(10.0);
		order.setOrderProductId(2);
		order.setNoOfUnits(789);
		order.setUserId(45L);
		List<Order> orderProductList = orderProductController.listCartProducts(order.getOrderProductId());
		assertNotNull(orderProductList);
	
	}
	/*
	 * @Test void checkoutOrdersTest() throws OrderException { Order order = new
	 * Order(); order.setOrderId(1L); order.setPrice(10.0);
	 * order.setOrderProductId(2); order.setNoOfUnits(789); order.setUserId(45L);
	 * //String test =
	 * orderProductController.checkoutOrders(order.getOrderProductId());
	 * assertThrows(Email.class, () -> {
	 * orderProductController.checkoutOrders(order.getOrderProductId()); });
	 * 
	 * }
	 */
}
