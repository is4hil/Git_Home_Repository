package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;
@Entity
@Table(name="payment_table")
public class PaymentEntity extends Model {
	
	@Column(name="order_id")
	private int orderId;

	@Column(name="payment_amount")
	private int amtReceived;

	@Column(name="payment_mode")
	private String paymentMode;

	public PaymentEntity(int orderId, int amtReceived, String paymentMode) {
		super();
		this.orderId = orderId;
		this.amtReceived = amtReceived;
		this.paymentMode = paymentMode;
	}

	public PaymentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getAmtReceived() {
		return amtReceived;
	}

	public void setAmtReceived(int amtReceived) {
		this.amtReceived = amtReceived;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	
	
	
}
