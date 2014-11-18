package de.hska.scsim.domain.input;

import java.util.List;

public class WaitingListStockMissingPart {
	
	private String id;
	private List<WaitingList> waitingLists;
	
	public String getId() {
		return id;
	}

	public List<WaitingList> getWaitingLists() {
		return waitingLists;
	}

	public WaitingListStockMissingPart(String id,
			List<WaitingList> waitinglists) {
		this.id = id;
		this.waitingLists = waitinglists;
	}
}
