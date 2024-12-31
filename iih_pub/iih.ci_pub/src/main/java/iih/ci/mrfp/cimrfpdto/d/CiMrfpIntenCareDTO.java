package iih.ci.mrfp.cimrfpdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病案首页重症监护 DTO数据 
 * 
 */
public class CiMrfpIntenCareDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 重症监护主键
	 * @return String
	 */
	public String getId_mrfp_intencare() {
		return ((String) getAttrVal("Id_mrfp_intencare"));
	}
	/**
	 * 重症监护主键
	 * @param Id_mrfp_intencare
	 */
	public void setId_mrfp_intencare(String Id_mrfp_intencare) {
		setAttrVal("Id_mrfp_intencare", Id_mrfp_intencare);
	}
	/**
	 * 病案首页其他信息主键
	 * @return String
	 */
	public String getId_cimrfpother() {
		return ((String) getAttrVal("Id_cimrfpother"));
	}
	/**
	 * 病案首页其他信息主键
	 * @param Id_cimrfpother
	 */
	public void setId_cimrfpother(String Id_cimrfpother) {
		setAttrVal("Id_cimrfpother", Id_cimrfpother);
	}
	/**
	 * 重症监护室名称
	 * @return String
	 */
	public String getName_intencare() {
		return ((String) getAttrVal("Name_intencare"));
	}
	/**
	 * 重症监护室名称
	 * @param Name_intencare
	 */
	public void setName_intencare(String Name_intencare) {
		setAttrVal("Name_intencare", Name_intencare);
	}
	/**
	 * 进重症监护室时间（年月日时分）
	 * @return FDateTime
	 */
	public FDateTime getTime_in_intencare() {
		return ((FDateTime) getAttrVal("Time_in_intencare"));
	}
	/**
	 * 进重症监护室时间（年月日时分）
	 * @param Time_in_intencare
	 */
	public void setTime_in_intencare(FDateTime Time_in_intencare) {
		setAttrVal("Time_in_intencare", Time_in_intencare);
	}
	/**
	 * 出重症监护室时间（年月日时分）
	 * @return FDateTime
	 */
	public FDateTime getTime_out_intencare() {
		return ((FDateTime) getAttrVal("Time_out_intencare"));
	}
	/**
	 * 出重症监护室时间（年月日时分）
	 * @param Time_out_intencare
	 */
	public void setTime_out_intencare(FDateTime Time_out_intencare) {
		setAttrVal("Time_out_intencare", Time_out_intencare);
	}
	/**
	 * 病案首页ID
	 * @return String
	 */
	public String getId_mrfp() {
		return ((String) getAttrVal("Id_mrfp"));
	}
	/**
	 * 病案首页ID
	 * @param Id_mrfp
	 */
	public void setId_mrfp(String Id_mrfp) {
		setAttrVal("Id_mrfp", Id_mrfp);
	}
	/**
	 * 版本
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 版本
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
}