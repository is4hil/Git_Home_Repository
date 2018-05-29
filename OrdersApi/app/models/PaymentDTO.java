package models;

import com.google.gson.annotations.SerializedName;

public class PaymentDTO {
	@SerializedName("order_id")
	private int orderId;

	@SerializedName("amt_received")
	private int amtReceived;

	@SerializedName("payment_mode")
	private String paymentMode;

	public PaymentDTO() {

	}

	public PaymentDTO(int orderId, int amtReceived, String paymentMode) {
		super();
		this.orderId = orderId;
		this.amtReceived = amtReceived;
		this.paymentMode = paymentMode;
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

	@Override
	public String toString() {
		return "PaymentDTO [orderId=" + orderId + ", amtReceived=" + amtReceived + ", paymentMode=" + paymentMode + "]";
	}

}
