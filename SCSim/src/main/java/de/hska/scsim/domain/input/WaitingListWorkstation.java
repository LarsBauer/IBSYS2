package de.hska.scsim.domain.input;

import java.util.List;

public class WaitingListWorkstation {
	private String id;
	private Integer timeNeed;
	private List<WaitingList> waitingLists;
	
	public WaitingListWorkstation(String id, Integer timeNeed,
			List<WaitingList> waitinglists) {
		this.id = id;
		this.timeNeed = timeNeed;
		this.waitingLists = waitinglists;
	}

	public String getId() {
		return id;
	}

	public Integer getTimeNeed() {
		return timeNeed;
	}

	public List<WaitingList> getWaitingLists() {
		return waitingLists;
	}
}
