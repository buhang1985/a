package iih.mi.biz.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 读卡信息及模式 DTO数据 
 * 
 */
public class ReadCardPatternDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 个人编号
	 * @return String
	 */
	public String getPersonno() {
		return ((String) getAttrVal("Personno"));
	}
	/**
	 * 个人编号
	 * @param Personno
	 */
	public void setPersonno(String Personno) {
		setAttrVal("Personno", Personno);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getIdcard() {
		return ((String) getAttrVal("Idcard"));
	}
	/**
	 * 身份证号
	 * @param Idcard
	 */
	public void setIdcard(String Idcard) {
		setAttrVal("Idcard", Idcard);
	}
	/**
	 * 统筹区域编码
	 * @return String
	 */
	public String getRegioncode() {
		return ((String) getAttrVal("Regioncode"));
	}
	/**
	 * 统筹区域编码
	 * @param Regioncode
	 */
	public void setRegioncode(String Regioncode) {
		setAttrVal("Regioncode", Regioncode);
	}
	/**
	 * 读卡模式
	 * @return String
	 */
	public String getReadpattern() {
		return ((String) getAttrVal("Readpattern"));
	}
	/**
	 * 读卡模式
	 * @param Readpattern
	 */
	public void setReadpattern(String Readpattern) {
		setAttrVal("Readpattern", Readpattern);
	}
	/**
	 * 患者来源
	 * @return String
	 */
	public String getPatsource() {
		return ((String) getAttrVal("Patsource"));
	}
	/**
	 * 患者来源
	 * @param Patsource
	 */
	public void setPatsource(String Patsource) {
		setAttrVal("Patsource", Patsource);
	}
	/**
	 * 患者医保身份编码
	 * @return String
	 */
	public String getCode_patca() {
		return ((String) getAttrVal("Code_patca"));
	}
	/**
	 * 患者医保身份编码
	 * @param Code_patca
	 */
	public void setCode_patca(String Code_patca) {
		setAttrVal("Code_patca", Code_patca);
	}
	/**
	 * 患者医保身份名称
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}
	/**
	 * 患者医保身份名称
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 病人信息
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 病人信息
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}
	/**
	 * 患者编码
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getEntcode() {
		return ((String) getAttrVal("Entcode"));
	}
	/**
	 * 就诊编码
	 * @param Entcode
	 */
	public void setEntcode(String Entcode) {
		setAttrVal("Entcode", Entcode);
	}
}