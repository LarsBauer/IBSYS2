package de.hska.scsim.domain.input;

public class FutureInwardStockMovementOrder {
	
	private String id;
	private Integer orderPeriod;
	private Integer mode;
	private String itemId;
	private Integer amount;
	
	public FutureInwardStockMovementOrder(String id, Integer orderId,
			Integer mode, String itemId, Integer amount) {
		this.id = id;
		this.orderPeriod = orderId;
		this.mode = mode;
		this.itemId = itemId;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public Integer getOrderPeriod() {
		return orderPeriod;
	}

	public Integer getMode() {
		return mode;
	}

	public String getItemId() {
		return itemId;
	}

	public Integer getAmount() {
		return amount;
	}		
}
