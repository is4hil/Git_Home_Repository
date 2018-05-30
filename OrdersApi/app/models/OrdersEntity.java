package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import play.db.jpa.Model;

@Entity
@Table(name = "order_table")
public class OrdersEntity extends Model {

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_price")
	private int productPrice;

	@Column(name = "payment_mode")
	private String paymentMode;

	@Column(name = "status")
	private String status;

	public OrdersEntity(String productName, int productPrice,
			String paymentMode, String status) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.paymentMode = paymentMode;
		this.status = status;
	}

	public OrdersEntity() {
		super();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
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
		return "OrdersEntity [productName=" + productName + ", productPrice="
				+ productPrice + ", paymentMode=" + paymentMode + ", status="
				+ status + "]";
	}

}
