package iih.ci.mi.ord.i.meta;

import xap.mw.coreitf.d.FBoolean;

public class OrdSrvIndicRstDTO extends OrdSrvIndicParamDTO{

	private static final long serialVersionUID = 1L;

	/**
	 * 适应症判断方式，控制类型
	 * @return String
	 */
	public String getEu_hpsrvctrtp() {
		return ((String) getAttrVal("Eu_hpsrvctrtp"));
	}
	/**
	 * 适应症判断方式，控制类型
	 * @param Eu_hpsrvctrtp
	 */
	public void setEu_hpsrvctrtp(String Eu_hpsrvctrtp) {
		setAttrVal("Eu_hpsrvctrtp", Eu_hpsrvctrtp);
	}
	
	/**
	 * 医保限制条件
	 * @return String
	 */
	public String getDes_limit() {
		return ((String) getAttrVal("Des_limit"));
	}
	/**
	 * 医保限制条件
	 * @param Des_limit
	 */
	public void setDes_limit(String Des_limit) {
		setAttrVal("Des_limit", Des_limit);
	}
	
	/**
	 * 临床医保适应症判定方式
	 * @return String
	 */
	public String getEu_hpjudge() {
		return ((String) getAttrVal("Eu_hpjudge"));
	}
	/**
	 * 临床医保适应症判定方式
	 * @param Eu_hpjudge
	 */
	public void setEu_hpjudge(String Eu_hpjudge) {
		setAttrVal("Eu_hpjudge", Eu_hpjudge);
	}
	
	/**
	 * 适应症判断结果是否允许修改
	 * @return String
	 */
	public FBoolean getFg_allowdedit() {
		return ((FBoolean) getAttrVal("Fg_allowdedit"));
	}
	/**
	 * 适应症判断结果是否允许修改
	 * @param Fg_allowdedit
	 */
	public void setFg_allowdedit(FBoolean Fg_allowdedit) {
		setAttrVal("Fg_allowdedit", Fg_allowdedit);
	}
	
}
