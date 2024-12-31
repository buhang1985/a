package iih.ci.ord.dws.ip.ems.d;

import xap.mw.coreitf.d.*;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;

/**
 * 出院医疗单 DTO数据 
 * 
 */
public class EmsOutHospViewDTO extends OrderListViewDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 离院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_timeout() {
		return ((FDateTime) getAttrVal("Dt_timeout"));
	}
	/**
	 * 离院时间
	 * @param Dt_timeout
	 */
	public void setDt_timeout(FDateTime Dt_timeout) {
		setAttrVal("Dt_timeout", Dt_timeout);
	}
	/**
	 * 离院方式id
	 * @return String
	 */
	public String getId_outtp() {
		return ((String) getAttrVal("Id_outtp"));
	}
	/**
	 * 离院方式id
	 * @param Id_outtp
	 */
	public void setId_outtp(String Id_outtp) {
		setAttrVal("Id_outtp", Id_outtp);
	}
	/**
	 * 离院方式编码
	 * @return String
	 */
	public String getSd_outtp() {
		return ((String) getAttrVal("Sd_outtp"));
	}
	/**
	 * 离院方式编码
	 * @param Sd_outtp
	 */
	public void setSd_outtp(String Sd_outtp) {
		setAttrVal("Sd_outtp", Sd_outtp);
	}
	/**
	 * 离院方式
	 * @return String
	 */
	public String getName_outtp() {
		return ((String) getAttrVal("Name_outtp"));
	}
	/**
	 * 离院方式
	 * @param Name_outtp
	 */
	public void setName_outtp(String Name_outtp) {
		setAttrVal("Name_outtp", Name_outtp);
	}
	
	/**
	 * 离院描述
	 * @return String
	 */
	public String getDes_outtp() {
		return ((String) getAttrVal("Des_outtp"));
	}
	/**
	 * 离院描述
	 * @param Des_outtp
	 */
	public void setDes_outtp(String Des_outtp) {
		setAttrVal("Des_outtp", Des_outtp);
	}
	/**
	 * 31日内再次计划住院标识
	 * @return FBoolean
	 */
	public FBoolean getFg_again31() {
		return ((FBoolean) getAttrVal("Fg_again31"));
	}
	/**
	 * 31日内再次计划住院标识
	 * @param Fg_again31
	 */
	public void setFg_again31(FBoolean Fg_again31) {
		setAttrVal("Fg_again31", Fg_again31);
	}
	/**
	 * 31日内再入院目的
	 * @return String
	 */
	public String getDes_again31() {
		return ((String) getAttrVal("Des_again31"));
	}
	/**
	 * 31日内再入院目的
	 * @param Des_again31
	 */
	public void setDes_again31(String Des_again31) {
		setAttrVal("Des_again31", Des_again31);
	}
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