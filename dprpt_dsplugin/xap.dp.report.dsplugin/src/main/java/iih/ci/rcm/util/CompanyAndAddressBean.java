package iih.ci.rcm.util;


public class CompanyAndAddressBean {
	private String company="";
	private String address="";
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CorAndAddressBean [company=" + company + ", address=" + address + "]";
	}
	
}
