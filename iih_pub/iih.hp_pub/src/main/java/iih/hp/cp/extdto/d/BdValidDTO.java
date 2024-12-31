package iih.hp.cp.extdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 基础数据检查结果项(如诊断标准) DTO数据 
 * 
 */
public class BdValidDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 数据Id
	 * @return String
	 */
	public String getId_bd() {
		return ((String) getAttrVal("Id_bd"));
	}
	/**
	 * 数据Id
	 * @param Id_bd
	 */
	public void setId_bd(String Id_bd) {
		setAttrVal("Id_bd", Id_bd);
	}
	/**
	 * 数据名称
	 * @return String
	 */
	public String getName_bd() {
		return ((String) getAttrVal("Name_bd"));
	}
	/**
	 * 数据名称
	 * @param Name_bd
	 */
	public void setName_bd(String Name_bd) {
		setAttrVal("Name_bd", Name_bd);
	}
	/**
	 * 数据检查类型
	 * @return String
	 */
	public String getSd_chktp() {
		return ((String) getAttrVal("Sd_chktp"));
	}
	/**
	 * 数据检查类型
	 * @param Sd_chktp
	 */
	public void setSd_chktp(String Sd_chktp) {
		setAttrVal("Sd_chktp", Sd_chktp);
	}
	/**
	 * 数据有效标识
	 * @return FBoolean
	 */
	public FBoolean getFg_valid() {
		return ((FBoolean) getAttrVal("Fg_valid"));
	}
	/**
	 * 数据有效标识
	 * @param Fg_valid
	 */
	public void setFg_valid(FBoolean Fg_valid) {
		setAttrVal("Fg_valid", Fg_valid);
	}
	/**
	 * 是否内部参照
	 * @return FBoolean
	 */
	public FBoolean getFg_inneref() {
		return ((FBoolean) getAttrVal("Fg_inneref"));
	}
	/**
	 * 是否内部参照
	 * @param Fg_inneref
	 */
	public void setFg_inneref(FBoolean Fg_inneref) {
		setAttrVal("Fg_inneref", Fg_inneref);
	}
	/**
	 * 数据检查结果描述
	 * @return String
	 */
	public String getMsg_reschk() {
		return ((String) getAttrVal("Msg_reschk"));
	}
	/**
	 * 数据检查结果描述
	 * @param Msg_reschk
	 */
	public void setMsg_reschk(String Msg_reschk) {
		setAttrVal("Msg_reschk", Msg_reschk);
	}
	/**
	 * 删除标识
	 * @return Integer
	 */
	public Integer getDs() {
		return ((Integer) getAttrVal("Ds"));
	}
	/**
	 * 删除标识
	 * @param Ds
	 */
	public void setDs(Integer Ds) {
		setAttrVal("Ds", Ds);
	}
}