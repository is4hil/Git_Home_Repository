package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

@Entity
@Table(name = "payment_table")
public class PaymentEntity extends Model {

	@Column(name = "order_id")
	private int orderId;

	@Column(name = "payment_amount")
	private int amtReceived;

	@Column(name = "payment_mode")
	private String paymentMode;

	@Column(name = "status")
	private String status;

	public PaymentEntity() {
		super();
	}

	public PaymentEntity(int orderId, int amtReceived, String paymentMode,
			String status) {
		super();
		this.orderId = orderId;
		this.amtReceived = amtReceived;
		this.paymentMode = paymentMode;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PaymentEntity [orderId=" + orderId + ", amtReceived="
				+ amtReceived + ", paymentMode=" + paymentMode + ", status="
				+ status + "]";
	}

}
