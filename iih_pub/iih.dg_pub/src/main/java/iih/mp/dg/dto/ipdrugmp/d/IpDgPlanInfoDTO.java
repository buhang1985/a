package iih.mp.dg.dto.ipdrugmp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 计划执行信息 DTO数据 
 * 
 */
public class IpDgPlanInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 请领状态
	 * @return Integer
	 */
	public Integer getEu_su() {
		return ((Integer) getAttrVal("Eu_su"));
	}
	/**
	 * 请领状态
	 * @param Eu_su
	 */
	public void setEu_su(Integer Eu_su) {
		setAttrVal("Eu_su", Eu_su);
	}
	/**
	 * 摆药状态
	 * @return Integer
	 */
	public Integer getEu_disp() {
		return ((Integer) getAttrVal("Eu_disp"));
	}
	/**
	 * 摆药状态
	 * @param Eu_disp
	 */
	public void setEu_disp(Integer Eu_disp) {
		setAttrVal("Eu_disp", Eu_disp);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getMemo() {
		return ((String) getAttrVal("Memo"));
	}
	/**
	 * 备注
	 * @param Memo
	 */
	public void setMemo(String Memo) {
		setAttrVal("Memo", Memo);
	}
	/**
	 * 生成标志
	 * @return Integer
	 */
	public Integer getSign() {
		return ((Integer) getAttrVal("Sign"));
	}
	/**
	 * 生成标志
	 * @param Sign
	 */
	public void setSign(Integer Sign) {
		setAttrVal("Sign", Sign);
	}
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱服务ID
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务ID
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 无效的
	 * @return FBoolean
	 */
	public FBoolean getInvalid() {
		return ((FBoolean) getAttrVal("Invalid"));
	}
	/**
	 * 无效的
	 * @param Invalid
	 */
	public void setInvalid(FBoolean Invalid) {
		setAttrVal("Invalid", Invalid);
	}
}