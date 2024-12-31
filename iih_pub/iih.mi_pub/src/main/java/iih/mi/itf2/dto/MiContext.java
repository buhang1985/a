package iih.mi.itf2.dto;

import xap.mw.core.data.BaseDTO;

/**
 * 医保平台上下文
 * @author ly
 *
 */
public class MiContext extends BaseDTO {

private static final long serialVersionUID = 1938974517895175899L;
	
	public MiContext() {
		super();
	}
	
	/**
	 * 医保产品主键
	 * @return
	 */
	public String getIdHp() {
		return (String)getAttrVal("IdHp");
	}
	
	/**
	 * 医保产品主键
	 * @param hpId
	 */
	public void setIdHp(String hpId) {
		setAttrVal("IdHp", hpId);
	}
	
	/**
	 * 医保产品编码
	 * @return
	 */
	public String getCodeHp() {
		return (String)getAttrVal("CodeHp");
	}
	
	/**
	 * 医保产品编码 
	 * @param codeHp
	 */
	public void setCodeHp(String codeHp) {
		setAttrVal("CodeHp", codeHp);
	}
	
	/**
	 * 患者分类编码
	 * @return
	 */
	public String getCodePatCa() {
		return (String)getAttrVal("CodePatCa");
	}
	
	/**
	 * 患者分类编码
	 * @param CodePatCa
	 */
	public void setCodePatCa(String CodePatCa) {
		setAttrVal("CodePatCa", CodePatCa);
	}

	/**
	 * 险种
	 * @return
	 */
	public String getCodeHpKind() {
		return (String)getAttrVal("CodeHpKind");
	}
	
	/**
	 * 险种
	 * @param codeHpKind
	 */
	public void setCodeHpKind(String codeHpKind) {
		setAttrVal("CodeHpKind", codeHpKind);
	}
	
	/**
	 * 医疗类别
	 * @return
	 */
	public String getCodeMedKind() {
		return (String)getAttrVal("CodeMedKind");
	}
	
	/**
	 * 医疗类别
	 * @param CodeMedKind
	 */
	public void setCodeMedKind(String CodeMedKind) {
		setAttrVal("CodeMedKind", CodeMedKind);
	}
}
