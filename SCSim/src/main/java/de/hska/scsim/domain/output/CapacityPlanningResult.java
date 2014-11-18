package de.hska.scsim.domain.output;

import de.hska.scsim.util.Constants;

public class CapacityPlanningResult {
	private Integer workplaceId;
	private int reqCapacity;
	private int shifts;
	private int overtime;
	private String producedItemConfigs;

	public CapacityPlanningResult() {}

	public CapacityPlanningResult(Integer workplaceId, int reqCapacity, int shifts, 
								 int overtime, String producedItemConfigs) {
		this.workplaceId = workplaceId;
		this.reqCapacity = reqCapacity;
		this.shifts = shifts;
		this.overtime = overtime;
		this.producedItemConfigs = producedItemConfigs;
	}

	public Integer getWorkplaceId() {
		return workplaceId;
	}
	
	public int getReqCapacity() {
		return reqCapacity;
	}
	
	public int getShifts() {
		return shifts;
	}

	public int getOvertime() {
		return overtime;
	}

	public String getProducedItemConfigs() {
		return producedItemConfigs;
	}
	
	public double getEfficiency() {
		double reqCapacityAsDouble = (double) reqCapacity;
		double shiftsAsDouble = (double) shifts;
		double overtimeAsDouble = (double) overtime;
		double efficiency = (reqCapacityAsDouble / (shiftsAsDouble * Constants.WORKPLACE_CAPACITY + overtimeAsDouble)) * 100;
		return Math.round(efficiency * 100.0) / 100.0;
	}

	@Override
	public String toString() {
		return "CapacityPlaningResult [workplaceId=" + workplaceId + ", reqCapacity=" + reqCapacity + ", shifts=" + shifts
				+ ", overtime=" + overtime + ", efficiency=" + getEfficiency() + ", producedItemConfigs=" + producedItemConfigs + "]";
	}
}
