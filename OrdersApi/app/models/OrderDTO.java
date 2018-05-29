package models;
import com.google.gson.annotations.SerializedName;

public class OrderDTO {
	
	@SerializedName("order_id")
	private int orderId;
	
	@SerializedName("product_name")
	private String productName;
	
	@SerializedName("product_price")
	private int productPrice;
	
	@SerializedName("payment_mode")
	private String paymentMode;
	
	public OrderDTO()
	{
		
	}

	public OrderDTO(int orderId,String productName, int productPrice, String paymentMode) {
		super();
		this.orderId= orderId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.paymentMode = paymentMode;
	}
	
	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	@Override
	public String toString() {
		return "OrderDTO [productName=" + productName + ", productPrice=" + productPrice + ", paymentMode="
				+ paymentMode + "]";
	}
	
	
	
	
	
}
