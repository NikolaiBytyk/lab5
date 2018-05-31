package it.unipv.payroll.model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import it.unipv.payroll.util.TimeManagUtil;

@SuppressWarnings("serial")
@Entity
@Table

/*
 * Sales Receipts work similarly to the TimeCard class. They define a
 * SaleAmount, which is the price for which an item is sold, a TimeStamp which
 * stores the day and the hour of the deal, and an autogenerated id. Given the
 * bidirectional relationship, they keep a field of the commission employee
 * they're connected to.
 */

public class SalesReceipt implements Serializable {

	@Id	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar TimeStamp;
	private float SaleAmount;

	@ManyToOne	@JoinColumn(name = "employee_id")
	CommissionEmployee employee;

	public SalesReceipt() {
		super();
	}

	// getters and setters

	public String getTimeStamp() {
		return TimeManagUtil.getStringfromGCobject(TimeStamp);
	}

	public void setTimeStamp(String timeStamp) throws ParseException {
		TimeStamp = TimeManagUtil.getGCobjectfromString(timeStamp);

	}

	public float getSaleAmount() {
		return SaleAmount;
	}

	public void setSaleAmount(float saleAmount) {
		SaleAmount = saleAmount;
	}

	public void setEmployee(CommissionEmployee employee) {
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public SalesReceipt(String timeStamp, float saleAmount, CommissionEmployee employee) throws ParseException {
		super();
		TimeStamp = TimeManagUtil.getGCobjectfromString(timeStamp);
		SaleAmount = saleAmount;
		this.employee = employee;
	}

}
