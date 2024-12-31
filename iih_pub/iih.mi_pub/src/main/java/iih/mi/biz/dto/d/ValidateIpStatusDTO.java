package iih.mi.biz.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 验证本人是否在院 DTO数据 
 * 
 */
public class ValidateIpStatusDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病人地区编码
	 * @return String
	 */
	public String getAreacode() {
		return ((String) getAttrVal("Areacode"));
	}
	/**
	 * 病人地区编码
	 * @param Areacode
	 */
	public void setAreacode(String Areacode) {
		setAttrVal("Areacode", Areacode);
	}
	/**
	 * 医保证号
	 * @return String
	 */
	public String getMedicalcode() {
		return ((String) getAttrVal("Medicalcode"));
	}
	/**
	 * 医保证号
	 * @param Medicalcode
	 */
	public void setMedicalcode(String Medicalcode) {
		setAttrVal("Medicalcode", Medicalcode);
	}
	/**
	 * 成员序号
	 * @return String
	 */
	public String getMemberno() {
		return ((String) getAttrVal("Memberno"));
	}
	/**
	 * 成员序号
	 * @param Memberno
	 */
	public void setMemberno(String Memberno) {
		setAttrVal("Memberno", Memberno);
	}
	/**
	 * 用户单位id
	 * @return String
	 */
	public String getCompanyid() {
		return ((String) getAttrVal("Companyid"));
	}
	/**
	 * 用户单位id
	 * @param Companyid
	 */
	public void setCompanyid(String Companyid) {
		setAttrVal("Companyid", Companyid);
	}
}