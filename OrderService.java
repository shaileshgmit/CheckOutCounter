package com.order.service;

import com.order.model.PurchaseOrder;
import com.order.model.PurchaseOrderItems;
import com.product.model.Product;
import com.product.model.tax.TaxSlab;

public class OrderService {

	

	public PurchaseOrder getPurchanseOrderDetails(Long orderNo) {
		// the PurchaseOrderRepository.findByOrderNo(orderNo)
		return null;
	}

	public Product getProduct(String product_code) {
		// ProductRepository.findByCode(product_code)
		return null;
	}

	public Object addProductToCart(PurchaseOrder orderDetail, Product product,
			Integer quantity) {
		Long productId = product.getId();
        PurchaseOrderItems PoItem = orderDetail.getPurchaseOrderItems().stream()
                .filter(cp -> productId == cp.getProduct().getId())
                .findFirst()
                .orElse(null);
        boolean foundProduct = !(PoItem == null);
        if(PoItem == null) {
        	PoItem = new PurchaseOrderItems();
        	PoItem.setPurchaseOrder(orderDetail);
        	PoItem.setProduct(product);
        	PoItem.setQuantity(quantity);
        	PoItem.setPrice(product.getPrice());
        	PoItem.setTax(getTaxAmount(product));
        } else {
        	PoItem.setQuantity(PoItem.getQuantity() + quantity);
        }
        PoItem.setPrice(product.getPrice());
        PoItem.setTax(getTaxAmount(product));
        PoItem.setTotalAmount();
        PoItem.setTotalTax();

        //PoItem = PurchaseOrderItems.save(PoItem);
        if(!foundProduct){
        	//PoItem.getPurchaseOrder().add(PoItem);
        }
        Double totalPrice = PoItem.getPurchaseOrder().stream().mapToDouble(p-> p.getTotalPrice()).sum();
        Double totalTax = PoItem.getPurchaseOrder().stream().mapToDouble(p -> p.getTotalTax()).sum();

        orderDetail.setTotalAmount(totalPrice + totalTax);
        orderDetail.setTotalItems(orderDetail.getPurchaseOrderItems().stream().mapToInt(p -> p.getQuantity()).sum());
        //orderDetail = PurchaseOrder.save(orderDetail);
        updateInventory(product, quantity);
        return orderDetail;
		return null;
	}


	public PurchaseOrder generateBill(Long orderNo) {
		PurchaseOrder orderDetail = getPurchanseOrderDetails(orderNo);
		//orderDetail = orderDetailRepository.save(orderDetail);
        return orderDetail;
	}
	
	private Double getTaxAmount(Product product) {
       // TaxSlab tax = Product.findByProductId(product.getId());
        Double taxAmount = 0.0;
        if(tax!=null){
            taxAmount = (tax.getApplicableTax() * product.getPrice() / 100);
        }
        return taxAmount;
    }
	
	private void updateInventory(Product product, Integer quantity) {
		product.setConsumed(product.getConsumed()+quantity);
		//Product.save(product);
		
		
	}

}
