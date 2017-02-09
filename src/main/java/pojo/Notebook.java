package pojo;

import java.io.Serializable;

public class Notebook extends Resource implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String brand;
	private String model;
	private String hardDiskType;
	private String processor;
	private int ram;
	private boolean Usb3;
	
	
	public Notebook(){
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

	public String getHardDiskType() {
		return hardDiskType;
	}

	public void setHardDiskType(String hardDiskType) {
		this.hardDiskType = hardDiskType;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public boolean isUsb3() {
		return Usb3;
	}

	public void setUsb3(boolean usb3) {
		Usb3 = usb3;
	}

	@Override
	public String toString() {
		return "Notebook [brand=" + brand + ", model=" + model + ", hardDiskType=" + hardDiskType + ", processor="
				+ processor + ", ram=" + ram + ", Usb3=" + Usb3 + ", toString()=" + super.toString() + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notebook other = (Notebook) obj;
		if (Usb3 != other.Usb3)
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (hardDiskType == null) {
			if (other.hardDiskType != null)
				return false;
		} else if (!hardDiskType.equals(other.hardDiskType))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (processor == null) {
			if (other.processor != null)
				return false;
		} else if (!processor.equals(other.processor))
			return false;
		if (ram != other.ram)
			return false;
		return true;
	}
	
	
}
