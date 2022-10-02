package project.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	int id;
	
	String name;
	int stock;
	int deal;
	int free;
	double mrp;
	double rate;
	String company;
	String batch;
	Date exp;
	String supplier;
	
	
	
	public Product() {
		super();
	}
	public Product(int id, String name, int stock, int deal, int free, float mrp, float rate, String company,
			String batch, Date exp, String supplier) {
		super();
		this.id = id;
		this.name = name;
		this.stock = stock;
		this.deal = deal;
		this.free = free;
		this.mrp = mrp;
		this.rate = rate;
		this.company = company;
		this.batch = batch;
		this.exp = exp;
		this.supplier = supplier;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getDeal() {
		return deal;
	}
	public void setDeal(int deal) {
		this.deal = deal;
	}
	public int getFree() {
		return free;
	}
	public void setFree(int free) {
		this.free = free;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public Date getExp() {
		return exp;
	}
	public void setExp(Date exp) {
		this.exp = exp;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	
}
