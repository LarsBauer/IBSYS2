package de.hska.scsim.domain.input;

public class WaitingList {
	
	private String itemId;
	private Integer amount;
	private Integer timeNeed;
			
	public WaitingList(String itemId, Integer amount, Integer timeNeed) {
		this.itemId = itemId;
		this.amount = amount;
		this.timeNeed = timeNeed;
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
