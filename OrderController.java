package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.dto.PurchaseOrderDto;
import com.order.model.PurchaseOrder;
import com.order.service.OrderService;
import com.product.model.Product;



@RestController
public class OrderController {
	
	@Autowired
    private OrderService orderService;
	
	 @RequestMapping(value = "/{orderNo}/addToCart", method = RequestMethod.POST)
	 
	    public PurchaseOrder addProductToCart(@RequestBody PurchaseOrderDto purchaseOrderDto,
	                                           @PathVariable("orderNo") Long cartId) throws Exception {
		 PurchaseOrder orderDetail=null; 
		 try {
	            orderDetail = orderService.getPurchanseOrderDetails(cartId);
	            Product product = orderService.getProduct(purchaseOrderDto.getProduct_code());
	            orderDetail = (PurchaseOrder) orderService.addProductToCart(orderDetail, product, purchaseOrderDto.getQuantity());
	            
	        } catch (Exception e){
	            System.out.println(e.getMessage());
	            throw new Exception("invalid order");
	        }
	        return orderDetail;
	    }
	 @RequestMapping(value = "/{orderId}/generateBill", method = RequestMethod.POST)
	    @ResponseBody
	    public PurchaseOrder generateBill(@PathVariable("orderNo") Long cartId) throws Exception {
		 PurchaseOrder orderDetail = orderService.generateBill(cartId);
	        return orderDetail;
	    }

}
