package de.hska.scsim.domain.input;

public class OrdersInWorkWorkplace {
	
	private String id;
	private String itemId;
	private Integer amount;
	private Integer timeNeed;
	
	public OrdersInWorkWorkplace(String id, String itemId, Integer amount,
			Integer timeNeed) {
		this.id = id;
		this.itemId = itemId;
		this.amount = amount;
		this.timeNeed = timeNeed;
	}

	public String getId() {
		return id;
	}

	public String getItemId() {
		return itemId;
	}

	public Integer getAmount() {
		return amount;
	}

	public Integer getTimeNeed() {
		return timeNeed;
	}
}
