package pojo;

import java.io.Serializable;

public class Projector extends Resource implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String brand;
	private String model; 
	private String resolution;
	
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
	
	public String getResolution() {
		return resolution;
	}
	
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	@Override
	public String toString() {
		return "Projector [brand=" + brand + ", model=" + model + ", resolution=" + resolution + ", toString()="
				+ super.toString() + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projector other = (Projector) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (resolution == null) {
			if (other.resolution != null)
				return false;
		} else if (!resolution.equals(other.resolution))
			return false;
		return true;
	}
	
	@Override
	public boolean filterByContraint(int minimum) {
		
		//TODO: IDENTIFY A VALID INT CONSTRAINT FOR THE FILTER 
		return true;
	}
	
	
	
	
}
