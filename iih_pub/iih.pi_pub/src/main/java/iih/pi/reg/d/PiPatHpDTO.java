package iih.pi.reg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者医保dto DTO数据 
 * 
 */
public class PiPatHpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 主医保主键
	 * @return String
	 */
	public String getId_prim_hp() {
		return ((String) getAttrVal("Id_prim_hp"));
	}
	/**
	 * 主医保主键
	 * @param Id_prim_hp
	 */
	public void setId_prim_hp(String Id_prim_hp) {
		setAttrVal("Id_prim_hp", Id_prim_hp);
	}
	/**
	 * 主医保编码
	 * @return String
	 */
	public String getCode_prim_hp() {
		return ((String) getAttrVal("Code_prim_hp"));
	}
	/**
	 * 主医保编码
	 * @param Code_prim_hp
	 */
	public void setCode_prim_hp(String Code_prim_hp) {
		setAttrVal("Code_prim_hp", Code_prim_hp);
	}
	/**
	 * 辅助医保主键
	 * @return String
	 */
	public String getId_auxi_hp() {
		return ((String) getAttrVal("Id_auxi_hp"));
	}
	/**
	 * 辅助医保主键
	 * @param Id_auxi_hp
	 */
	public void setId_auxi_hp(String Id_auxi_hp) {
		setAttrVal("Id_auxi_hp", Id_auxi_hp);
	}
	/**
	 * 辅助医保编码
	 * @return String
	 */
	public String getCode_auxi_hp() {
		return ((String) getAttrVal("Code_auxi_hp"));
	}
	/**
	 * 辅助医保编码
	 * @param Code_auxi_hp
	 */
	public void setCode_auxi_hp(String Code_auxi_hp) {
		setAttrVal("Code_auxi_hp", Code_auxi_hp);
	}
}