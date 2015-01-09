package de.hska.scsim.domain.output;

import de.hska.scsim.util.Constants;

public class PurchasePlanningResult {
	private String itemConfigId;
	private int quantity;
	private int purchaseMode;
	private int deliveryCosts;
	private double price;
	private int discountQuantity;
	private double deliveryTime;
	private double variance;
	
	public PurchasePlanningResult() {}

	public PurchasePlanningResult(String itemConfigId, int quantity, int purchaseMode, int deliveryCosts, 
								 double price, int discountQuantity, double deliveryTime, double variance) {
		this.itemConfigId = itemConfigId;
		this.quantity = quantity;
		this.purchaseMode = purchaseMode;
		this.deliveryCosts = deliveryCosts;
		this.price = price;
		this.discountQuantity = discountQuantity;
		this.deliveryTime = deliveryTime;
		this.variance = variance;
	}

	public String getItemConfigId() {
		return itemConfigId;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPurchaseMode() {
		return purchaseMode;
	}

	public void setPurchaseMode(int purchaseMode) {
		this.purchaseMode = purchaseMode;
	}
	
	public int getDiscountQuantity() {
		return discountQuantity;
	}
	
	public double getDeliveryTime() {
		return deliveryTime;
	}
	
	public double getVariance() {
		return variance;
	}
	
	public boolean isDeliveryInCurrentPeriod() {
		double currentDeliveryTime;
		switch (purchaseMode) {
			case Constants.STANDARD_DELIVERY_ID : {
				currentDeliveryTime = deliveryTime + variance;
				break;
			}
			case Constants.FAST_DELIVERY_ID : {
				currentDeliveryTime = deliveryTime / 2;
				break;
			}
			default : {
				return false;
			}
		}
		
		return currentDeliveryTime < 1;
	}
	
        //TODO
	public double getPositionCosts() {
		if(quantity <= 0) {
			return 0d;
		}
		
		int currentOrderingCosts = 0;
		if(purchaseMode == Constants.FAST_DELIVERY_ID) {
			currentOrderingCosts = deliveryCosts * Constants.FAST_DELIVERY_ADDITION;
		} else {
			currentOrderingCosts = deliveryCosts;
		}
		
		double positionCosts = price * quantity + currentOrderingCosts;
		if(quantity < discountQuantity) {
			return positionCosts;
		} else {
			return Math.round((positionCosts * Constants.DISCOUNT_PRICE) * 100.0) / 100.0;
		}
	}
	
	

	@Override
	public String toString() {
		return "PurchasePlaningResult [itemConfigId=" + itemConfigId + ", quantity=" + quantity + ", purchaseMode=" + purchaseMode +
				", discountQuantity=" + discountQuantity + ", deliveryInCurrentPeriod=" + isDeliveryInCurrentPeriod() + ", positionCosts=" + getPositionCosts() +
				", deliveryTime=" + deliveryTime + ", variance=" + variance + "]";
	}
}
