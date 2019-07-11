package com.order.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	 private String orderNo;//will generate a random number for each order
	 
	 private Date billDate;
	 private Double totalAmount;
	 private Integer totalItems;
	 
	 @OneToMany(cascade = CascadeType.ALL)
	 private List<PurchaseOrderItems> purchaseOrderItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public List<PurchaseOrderItems> getPurchaseOrderItems() {
		return purchaseOrderItems;
	}

	public void setPurchaseOrderItems(List<PurchaseOrderItems> purchaseOrderItems) {
		this.purchaseOrderItems = purchaseOrderItems;
	}
	 
	 
	
}
