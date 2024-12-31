package iih.pis.ivx.invoice.d;

public class Info {
	
	//项目的名称(必填)
	private String name;
	
	//项目的数量
	private Integer num;
	
	//项目的单位，如个
	private String unit;
	
	//项目的单价,以分为单位(必填)
	private Integer price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
