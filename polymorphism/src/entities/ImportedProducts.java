package entities;

public class ImportedProducts extends Product{
	private Double customsFee;
	public ImportedProducts() {
		super();
	}

	public ImportedProducts(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee=customsFee;
		// TODO Auto-generated constructor stub
	}

	public Double getCustomsFee() {
		return customsFee;
	}
	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	@Override
	public String priceTag() {
		return getName() 
				+ " $ " 
				+ String.format("%.2f", totalPrice())
				+ " (Customs fee: $ " 
				+ String.format("%.2f", customsFee)
				+ ")";
	}
	public Double totalPrice() {
		return getPrice()+customsFee;
	}
}
