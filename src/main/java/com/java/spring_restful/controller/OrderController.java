package com.java.spring_restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

	
	//对订单进行增删改查
	//@GetMapping("/add")  不符合restful风格的url设计  restfuk风格里面，不允许出现动词、只能出现名词
	//幂等性  == 多次调用一个接口，并且传递的参数一样的情况下如果结果相同，说明该接口符合幂等性；
	//非幂等性
	/*
	 * 1、针对不同的请求应该使用请求方法   get/put/delete/post....
	 * 2、接口设计中应该体现出"资源"，不能使用动词，只能使用名词；
	 * 每一个资源都要有唯一的标识
	 * 对于不同的行为，使用对应的http-method
	 */
	//访问：/order
	
	//添加
	@PostMapping("")
	public void addOrder() {
		
	}
	
	//查询
	@GetMapping("/{id}")
	public void getOrder(@PathVariable("id") Integer id) {
		
	}
	
	@GetMapping("")
	public void getOrder() {
		
	}
	
	
	
	// /order/xxx
	//删除
	@DeleteMapping("/{id}")
	public void getOrderById(@PathVariable("id") Integer id) {
		
	}
	
	//更新
	@PutMapping("/{id}")
	public void updateOrderById(@PathVariable("id") String id) {
		
	}
	
	//updateOrder
	//更新
	@PutMapping("/name/{name}")
	public void updateOrderByName(@PathVariable("name") String name) {
			
	}
}
