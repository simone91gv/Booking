package pojo;

import java.io.Serializable;

public class Vehicle extends Resource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String brand;
	private String model;
	private int displacement;
	private String supplyType;
	
	
	public Vehicle() {
		super();
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getDisplacement() {
		return displacement;
	}


	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public String getSupplyType() {
		return supplyType;
	}


	public void setSupplyType(String supplyType) {
		this.supplyType = supplyType;
	}


	@Override
	public String toString() {
		return "Vehicle [brand=" + brand + ", model=" + model + ", displacement=" + displacement + ", supplyType="
				+ supplyType + ", toString()=" + super.toString() + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + displacement;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((supplyType == null) ? 0 : supplyType.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (displacement != other.displacement)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (supplyType == null) {
			if (other.supplyType != null)
				return false;
		} else if (!supplyType.equals(other.supplyType))
			return false;
		return true;
	}


	
	
	


	
	
	
	
	
}
