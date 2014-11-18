package de.hska.scsim.domain;

import java.util.Objects;

public class ProductionStepConfig {
	private Integer id;
	private Integer workplaceId;
	private String itemConfigId;
	private int productionTime;
	private int setupTime;
	private Integer preProductionStepConfigId;
	
	public ProductionStepConfig() {}

	public ProductionStepConfig(Integer id, Integer workplaceId, String itemConfigId, int productionTime, 
								int setupTime, Integer preProductionStepConfigId) {
		this.id = id;
		this.workplaceId = workplaceId;
		this.itemConfigId = itemConfigId;
		this.productionTime = productionTime;
		this.setupTime = setupTime;
		this.preProductionStepConfigId = preProductionStepConfigId;
	}

	public ProductionStepConfig(Integer id, Integer workplaceId, String itemConfigId, 
								int productionTime, int setupTime) {
		this.id = id;
		this.workplaceId = workplaceId;
		this.itemConfigId = itemConfigId;
		this.productionTime = productionTime;
		this.setupTime = setupTime;
	}

	public Integer getId() {
		return id;
	}

	public Integer getWorkplaceId() {
		return workplaceId;
	}

	public String getItemConfigId() {
		return itemConfigId;
	}

	public int getProductionTime() {
		return productionTime;
	}

	public int getSetupTime() {
		return setupTime;
	}

	public Integer getPreProductionStepConfigId() {
		return preProductionStepConfigId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(obj == this) {
			return true;
		}
		
		if(!(obj instanceof ProductionStepConfig)) {
			return false;
		}
		
		ProductionStepConfig productionStepConfig = (ProductionStepConfig) obj;
		return Objects.equals(id, productionStepConfig.getId()) &&
			   Objects.equals(workplaceId, productionStepConfig.getWorkplaceId()) &&
			   Objects.equals(itemConfigId, productionStepConfig.getItemConfigId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, workplaceId, itemConfigId);
	}

	@Override
	public String toString() {
		return "ProductionStepConfig [id=" + id + ", workplaceId=" + workplaceId + ", itemConfigId=" + itemConfigId
				+ ", productionTime=" + productionTime + ", setupTime=" + setupTime + ", preProductionStepConfigId=" + preProductionStepConfigId + "]";
	}
}
