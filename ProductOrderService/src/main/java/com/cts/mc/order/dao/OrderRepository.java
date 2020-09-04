package com.cts.mc.order.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.mc.order.model.Order;
@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
	public List<Order> findByOrderProductId(int userId);
}
