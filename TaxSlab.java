package com.product.model.tax;

import javax.persistence.*;
import com.product.model.Product;

@Entity
@Table(name="product_tax_group")
public class TaxSlab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="product_id",nullable=false )
	private Product product;
	
    private Double applicableTax;
    
    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
	private Boolean isActive = Boolean.TRUE;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Double getApplicableTax() {
		return applicableTax;
	}
	public void setApplicableTax(Double applicableTax) {
		this.applicableTax = applicableTax;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
    

}
