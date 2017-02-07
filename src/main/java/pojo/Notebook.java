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
}
