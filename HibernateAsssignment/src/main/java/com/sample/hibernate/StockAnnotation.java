package com.sample.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Model class for Stock using annotations 
 * If annotation class is used there is no need of using stock.hbm.xml
 * Here we have simply supplied the same constraints through the annotations 
 * which we have used in stock.hbm.xml
 * 
 * For more necessary changes see hibernate.cfg.xml and pom.xml
 */


@Entity
@Table(name = "stock", catalog = "demodb", uniqueConstraints = {
		@UniqueConstraint(columnNames = "STOCK_NAME"),
		@UniqueConstraint(columnNames = "STOCK_CODE") })
public class StockAnnotation implements java.io.Serializable {
 
	private static final long serialVersionUID = 1L;
 
	private Integer stockId;
	private String stockCode;
	private String stockName;
 
	public StockAnnotation() {
	}
 
	public StockAnnotation(String stockCode, String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	public Integer getStockId() {
		return this.stockId;
	}
 
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
 
	@Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
	public String getStockCode() {
		return this.stockCode;
	}
 
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
 
	@Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
	public String getStockName() {
		return this.stockName;
	}
 
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
 
}