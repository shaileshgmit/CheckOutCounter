package com.product.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@Column(unique = true)
	private String productCode;
	
	private String description;
	
	@Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
	private Boolean isActive = Boolean.TRUE;
	
	@Column(nullable=false)
    private Double price;
	
	private Integer inventoryStock;
	
	private Integer consumed;
	
	public Integer getInventoryStock() {
		return inventoryStock;
	}
	public void setInventoryStock(Integer inventoryStock) {
		this.inventoryStock = inventoryStock;
	}
	public Integer getConsumed() {
		return consumed;
	}
	public void setConsumed(Integer consumed) {
		this.consumed = consumed;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	

}
 	