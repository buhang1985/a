package iih.ei.std.d.v1.bl.opincitminfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊自助发票明细查询出参 DTO数据 
 * 
 */
public class OpIncItmInfoResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结算号
	 * @return String
	 */
	public String getCode_stoep() {
		return ((String) getAttrVal("Code_stoep"));
	}	
	/**
	 * 结算号
	 * @param Code_stoep
	 */
	public void setCode_stoep(String Code_stoep) {
		setAttrVal("Code_stoep", Code_stoep);
	}
	/**
	 * 医院级别
	 * @return String
	 */
	public String getName_hostp() {
		return ((String) getAttrVal("Name_hostp"));
	}	
	/**
	 * 医院级别
	 * @param Name_hostp
	 */
	public void setName_hostp(String Name_hostp) {
		setAttrVal("Name_hostp", Name_hostp);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}	
	/**
	 * 患者分类
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 医院名称
	 * @return String
	 */
	public String getName_hos() {
		return ((String) getAttrVal("Name_hos"));
	}	
	/**
	 * 医院名称
	 * @param Name_hos
	 */
	public void setName_hos(String Name_hos) {
		setAttrVal("Name_hos", Name_hos);
	}
	/**
	 * 操作员编码
	 * @return String
	 */
	public String getCode_opera() {
		return ((String) getAttrVal("Code_opera"));
	}	
	/**
	 * 操作员编码
	 * @param Code_opera
	 */
	public void setCode_opera(String Code_opera) {
		setAttrVal("Code_opera", Code_opera);
	}
	/**
	 * 结算时间
	 * @return String
	 */
	public String getDt_st() {
		return ((String) getAttrVal("Dt_st"));
	}	
	/**
	 * 结算时间
	 * @param Dt_st
	 */
	public void setDt_st(String Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 本次结算总费用
	 * @return String
	 */
	public String getAmt_stoep() {
		return ((String) getAttrVal("Amt_stoep"));
	}	
	/**
	 * 本次结算总费用
	 * @param Amt_stoep
	 */
	public void setAmt_stoep(String Amt_stoep) {
		setAttrVal("Amt_stoep", Amt_stoep);
	}
	/**
	 * 门诊发票号信息
	 * @return String
	 */
	public FArrayList getIncnoinfo() {
		return ((FArrayList) getAttrVal("Incnoinfo"));
	}	
	/**
	 * 门诊发票号信息
	 * @param Incnoinfo
	 */
	public void setIncnoinfo(FArrayList Incnoinfo) {
		setAttrVal("Incnoinfo", Incnoinfo);
	}
}