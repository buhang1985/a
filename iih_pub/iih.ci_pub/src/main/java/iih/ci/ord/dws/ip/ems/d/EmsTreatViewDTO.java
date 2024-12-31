package iih.ci.ord.dws.ip.ems.d;

import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;


/**
 * 治疗医疗单 DTO数据 
 * 
 */
public class EmsTreatViewDTO extends OrderListViewDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 备注
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 备注
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
}