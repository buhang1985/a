package iih.mp.ot.dto.confirm.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技确认患者信息 DTO数据 
 * 
 */
public class MpOtPatDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getDes_order() {
		return ((String) getAttrVal("Des_order"));
	}
	/**
	 * 医嘱内容
	 * @param Des_order
	 */
	public void setDes_order(String Des_order) {
		setAttrVal("Des_order", Des_order);
	}
	/**
	 * 医嘱信息
	 * @return FArrayList
	 */
	public FArrayList getInfo_cior() {
		return ((FArrayList) getAttrVal("Info_cior"));
	}
	/**
	 * 医嘱信息
	 * @param Info_cior
	 */
	public void setInfo_cior(FArrayList Info_cior) {
		setAttrVal("Info_cior", Info_cior);
	}
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
}