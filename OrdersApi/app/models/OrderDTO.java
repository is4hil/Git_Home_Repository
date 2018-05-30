package models;
import com.google.gson.annotations.SerializedName;

public class OrderDTO {
	
		
	@SerializedName("product_name")
	private String productName;
	
	@SerializedName("product_price")
	private int productPrice;
	
	@SerializedName("payment_mode")
	private String paymentMode;
	
	public OrderDTO()
	{
		
	}

	public OrderDTO(String productName, int productPrice, String paymentMode) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.paymentMode = paymentMode;
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
		return "OrderDTO [productName=" + productName + ", productPrice="
				+ productPrice + ", paymentMode=" + paymentMode + "]";
	}

	
}
