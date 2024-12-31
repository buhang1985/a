package iih.mp.dg.dto.ipdgrecordcond.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 特殊退药单Head表头 DTO数据 
 * 
 */
public class IpDgSpecialRetHdDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊id
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 请领主键
	 * @return String
	 */
	public String getId_dgipap() {
		return ((String) getAttrVal("Id_dgipap"));
	}
	/**
	 * 请领主键
	 * @param Id_dgipap
	 */
	public void setId_dgipap(String Id_dgipap) {
		setAttrVal("Id_dgipap", Id_dgipap);
	}
	/**
	 * 请领单号
	 * @return String
	 */
	public String getCode_dgipap() {
		return ((String) getAttrVal("Code_dgipap"));
	}
	/**
	 * 请领单号
	 * @param Code_dgipap
	 */
	public void setCode_dgipap(String Code_dgipap) {
		setAttrVal("Code_dgipap", Code_dgipap);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	 * 请领单类型名称
	 * @return String
	 */
	public String getName_aptype() {
		return ((String) getAttrVal("Name_aptype"));
	}
	/**
	 * 请领单类型名称
	 * @param Name_aptype
	 */
	public void setName_aptype(String Name_aptype) {
		setAttrVal("Name_aptype", Name_aptype);
	}
}