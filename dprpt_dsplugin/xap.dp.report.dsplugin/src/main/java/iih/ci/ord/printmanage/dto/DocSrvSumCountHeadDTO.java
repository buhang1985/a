package iih.ci.ord.printmanage.dto;

import java.util.List;

public class DocSrvSumCountHeadDTO {
	/**
	 * 医生姓名
	 */
	private String Psndoc_name;
	/**
	 * 医生工号
	 */
	private String Psndoc_code;
	/**
	 * 开始时间
	 */
	private String Dt_st;
	/**
	 * 截止时间
	 */
	private String Dt_ed;
	/**
	 * 总计价格
	 */
	private String total_pri;
	/**
	 * 汇总统计集合
	 */
	private List<DocSrvSumCountItemDTO> itemdtolist;
	
	public String getTotal_pri() {
		return total_pri;
	}
	public void setTotal_pri(String total_pri) {
		this.total_pri = total_pri;
	}
	public String getPsndoc_name() {
		return Psndoc_name;
	}
	public void setPsndoc_name(String psndoc_name) {
		Psndoc_name = psndoc_name;
	}
	public String getPsndoc_code() {
		return Psndoc_code;
	}
	public void setPsndoc_code(String psndoc_code) {
		Psndoc_code = psndoc_code;
	}
	public String getDt_st() {
		return Dt_st;
	}
	public void setDt_st(String dt_st) {
		Dt_st = dt_st;
	}
	public String getDt_ed() {
		return Dt_ed;
	}
	public void setDt_ed(String dt_ed) {
		Dt_ed = dt_ed;
	}
	public List<DocSrvSumCountItemDTO> getItemdtolist() {
		return itemdtolist;
	}
	public void setItemdtolist(List<DocSrvSumCountItemDTO> itemdtolist) {
		this.itemdtolist = itemdtolist;
	}
	
}
