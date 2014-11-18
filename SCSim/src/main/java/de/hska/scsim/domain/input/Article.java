package de.hska.scsim.domain.input;

public class Article {
	
	private Integer id;
	private Integer amount;
	private Integer startAmount;
	private Double pct;
	private Double price;
	private Double stockValue;
	
	public Integer getId() {
		return id;
	}
	
	public Article(Integer id, Integer amount, Integer startAmount,
			Double pct, Double price, Double stockvalue) {
		this.id = id;
		this.amount = amount;
		this.startAmount = startAmount;
		this.pct = pct;
		this.price = price;
		this.stockValue = stockvalue;
	}

	public Integer getAmount() {
		return amount;
	}

	public Integer getStartAmount() {
		return startAmount;
	}

	public Double getPct() {
		return pct;
	}

	public Double getPrice() {
		return price;
	}

	public Double getStockValue() {
		return stockValue;
	}
}
