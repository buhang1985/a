package iih.mp.nr.opuvsigncollect.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体征保存项 DTO数据 
 * 
 */
public class SignsItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体征模板项目
	 * @return String
	 */
	public String getId_mrtplvtitm() {
		return ((String) getAttrVal("Id_mrtplvtitm"));
	}
	/**
	 * 体征模板项目
	 * @param Id_mrtplvtitm
	 */
	public void setId_mrtplvtitm(String Id_mrtplvtitm) {
		setAttrVal("Id_mrtplvtitm", Id_mrtplvtitm);
	}
	/**
	 * 体征测量主表ID
	 * @return String
	 */
	public String getId_mrvt() {
		return ((String) getAttrVal("Id_mrvt"));
	}
	/**
	 * 体征测量主表ID
	 * @param Id_mrvt
	 */
	public void setId_mrvt(String Id_mrvt) {
		setAttrVal("Id_mrvt", Id_mrvt);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务项目名称
	 * @return String
	 */
	public String getId_srv_name() {
		return ((String) getAttrVal("Id_srv_name"));
	}
	/**
	 * 服务项目名称
	 * @param Id_srv_name
	 */
	public void setId_srv_name(String Id_srv_name) {
		setAttrVal("Id_srv_name", Id_srv_name);
	}
	/**
	 * 测量时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt() {
		return ((FDateTime) getAttrVal("Dt_vt"));
	}
	/**
	 * 测量时间
	 * @param Dt_vt
	 */
	public void setDt_vt(FDateTime Dt_vt) {
		setAttrVal("Dt_vt", Dt_vt);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 值个数
	 * @return Integer
	 */
	public Integer getValcount() {
		return ((Integer) getAttrVal("Valcount"));
	}
	/**
	 * 值个数
	 * @param Valcount
	 */
	public void setValcount(Integer Valcount) {
		setAttrVal("Valcount", Valcount);
	}
	/**
	 * 值
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}
	/**
	 * 值
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 值1
	 * @return String
	 */
	public String getValue1() {
		return ((String) getAttrVal("Value1"));
	}
	/**
	 * 值1
	 * @param Value1
	 */
	public void setValue1(String Value1) {
		setAttrVal("Value1", Value1);
	}
	/**
	 * 值2
	 * @return String
	 */
	public String getValue2() {
		return ((String) getAttrVal("Value2"));
	}
	/**
	 * 值2
	 * @param Value2
	 */
	public void setValue2(String Value2) {
		setAttrVal("Value2", Value2);
	}
	/**
	 * 值3
	 * @return String
	 */
	public String getValue3() {
		return ((String) getAttrVal("Value3"));
	}
	/**
	 * 值3
	 * @param Value3
	 */
	public void setValue3(String Value3) {
		setAttrVal("Value3", Value3);
	}
	/**
	 * 测量部位
	 * @return String
	 */
	public String getId_vt_pos() {
		return ((String) getAttrVal("Id_vt_pos"));
	}
	/**
	 * 测量部位
	 * @param Id_vt_pos
	 */
	public void setId_vt_pos(String Id_vt_pos) {
		setAttrVal("Id_vt_pos", Id_vt_pos);
	}
}