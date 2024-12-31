package iih.mp.nr.dto.pattagt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者过滤指标业务数据模型 DTO数据 
 * 
 */
public class PatTagtDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 业务时间
	 * @return FDateTime
	 */
	public FDateTime getDt_biz() {
		return ((FDateTime) getAttrVal("Dt_biz"));
	}
	/**
	 * 业务时间
	 * @param Dt_biz
	 */
	public void setDt_biz(FDateTime Dt_biz) {
		setAttrVal("Dt_biz", Dt_biz);
	}
	/**
	 * 体征属性
	 * @return String
	 */
	public String getId_mrtpl_vs_itm() {
		return ((String) getAttrVal("Id_mrtpl_vs_itm"));
	}
	/**
	 * 体征属性
	 * @param Id_mrtpl_vs_itm
	 */
	public void setId_mrtpl_vs_itm(String Id_mrtpl_vs_itm) {
		setAttrVal("Id_mrtpl_vs_itm", Id_mrtpl_vs_itm);
	}
	/**
	 * ID值
	 * @return String
	 */
	public String getId_value() {
		return ((String) getAttrVal("Id_value"));
	}
	/**
	 * ID值
	 * @param Id_value
	 */
	public void setId_value(String Id_value) {
		setAttrVal("Id_value", Id_value);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getId_entstate() {
		return ((String) getAttrVal("Id_entstate"));
	}
	/**
	 * 就诊状态
	 * @param Id_entstate
	 */
	public void setId_entstate(String Id_entstate) {
		setAttrVal("Id_entstate", Id_entstate);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
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
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
}