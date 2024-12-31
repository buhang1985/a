package test.rptbean;

public class SaleBean {
	private int year = 0;
	private int month = 0;
	private String area = null;
	
	private float count = 0f;

	public SaleBean() {
		
	}
	
	public SaleBean(int year, int month, String area) {
		this.year = year;
		this.month = month;
		this.area = area;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public float getCount() {
		return count;
	}

	public void setCount(float count) {
		this.count = count;
	}
	
}
