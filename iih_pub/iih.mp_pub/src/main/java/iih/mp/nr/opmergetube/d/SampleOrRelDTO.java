package iih.mp.nr.opmergetube.d;

import java.util.List;

/**
 * 门诊标本医嘱关系 DTO数据 
 * 
 */
public class SampleOrRelDTO{

	public String getNo_bar() {
		return no_bar;
	}
	public void setNo_bar(String no_bar) {
		this.no_bar = no_bar;
	}
	public List<String> getListOrs() {
		return listOrs;
	}
	public void setListOrs(List<String> listOrs) {
		this.listOrs = listOrs;
	}
	public List<String> getListOrprs() {
		return listOrprs;
	}
	public void setListOrprs(List<String> listOrprs) {
		this.listOrprs = listOrprs;
	}
	private String no_bar;
	private List<String> listOrs;
	private List<String> listOrprs;

}