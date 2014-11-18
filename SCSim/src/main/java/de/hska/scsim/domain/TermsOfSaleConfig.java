package de.hska.scsim.domain;

import java.util.Objects;

public class TermsOfSaleConfig {
	private String itemConfigId;
	private double deliveryTime;
	private double variance;
	private int deliveryCosts;
	private int discountQuantity;

	public TermsOfSaleConfig() {}

	public TermsOfSaleConfig(String itemConfigId, double deliveryTime, double variance, 
							 int orderingCosts, int discountQuantity) {
		this.itemConfigId = itemConfigId;
		this.deliveryTime = deliveryTime;
		this.variance = variance;
		this.deliveryCosts = orderingCosts;
		this.discountQuantity = discountQuantity;
	}

	public String getItemConfigId() {
		return itemConfigId;
	}

	public double getDeliveryTime() {
		return deliveryTime;
	}

	public double getVariance() {
		return variance;
	}

	public int getDeliveryCosts() {
		return deliveryCosts;
	}

	public int getDiscountQuantity() {
		return discountQuantity;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(obj == this) {
			return true;
		}
		
		if(!(obj instanceof TermsOfSaleConfig)) {
			return false;
		}
		
		TermsOfSaleConfig termsOfSaleConfig = (TermsOfSaleConfig) obj;
		return Objects.equals(itemConfigId, termsOfSaleConfig.getItemConfigId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(itemConfigId);
	}

	@Override
	public String toString() {
		return "TermsOfSaleConfig [itemConfigId=" + itemConfigId + ", deliveryTime=" + deliveryTime + ", variance=" + variance
				+ ", orderingCosts=" + deliveryCosts + ", discountQuantity=" + discountQuantity + "]";
	}
}
