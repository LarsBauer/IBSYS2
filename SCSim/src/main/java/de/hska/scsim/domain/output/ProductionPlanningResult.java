package de.hska.scsim.domain.output;

public class ProductionPlanningResult {
	private String itemConfigId;
	private int quantity;

	public ProductionPlanningResult() {}

	public ProductionPlanningResult(String itemConfigId, int quantity) {
		this.itemConfigId = itemConfigId;
		this.quantity = quantity;
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

	@Override
	public String toString() {
		return "ProductionPlaningResult [itemConfigId=" + itemConfigId + ", quantity=" + quantity + "]";
	}
}
