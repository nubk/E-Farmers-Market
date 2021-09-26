package com.app.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.OrderRepository;
import com.app.dao.UserRepository;
import com.app.pojos.Data;
import com.app.pojos.Order;
import com.app.pojos.User;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService{
@Autowired
private OrderRepository orderRepo;
@Autowired
private UserRepository userRepo;

@Override
	public Order addOrderDetails(Data data) {
	int buyerId=data.getBuyerId();
	double orderAmount=data.getPrice();
		User buyer=userRepo.getById(buyerId);
		Order newOrder=new Order();
		newOrder.setBuyers(buyer);
		newOrder.setOrderAmount(orderAmount);
		newOrder.setOrderDate(LocalDate.now());
		
		return orderRepo.save(newOrder);
	}
}
