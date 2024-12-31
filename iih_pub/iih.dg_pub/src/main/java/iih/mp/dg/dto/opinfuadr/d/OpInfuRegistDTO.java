package iih.mp.dg.dto.opinfuadr.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 输液登记信息dto DTO数据 
 * 
 */
public class OpInfuRegistDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 输液登记主键
	 * @return String
	 */
	public String getId_dginfu() {
		return ((String) getAttrVal("Id_dginfu"));
	}
	/**
	 * 输液登记主键
	 * @param Id_dginfu
	 */
	public void setId_dginfu(String Id_dginfu) {
		setAttrVal("Id_dginfu", Id_dginfu);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 计划执行时间
	 * @return String
	 */
	public String getDt_mp_plan() {
		return ((String) getAttrVal("Dt_mp_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(String Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
}