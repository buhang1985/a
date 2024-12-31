package iih.syn.common.dto.mdsyn.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 主数据信息 DTO数据 
 * 
 */
public class MdDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主数据分类ID
	 * @return String
	 */
	public String getId_mdm_ca() {
		return ((String) getAttrVal("Id_mdm_ca"));
	}
	/**
	 * 主数据分类ID
	 * @param Id_mdm_ca
	 */
	public void setId_mdm_ca(String Id_mdm_ca) {
		setAttrVal("Id_mdm_ca", Id_mdm_ca);
	}
	/**
	 * 主数据分类编码
	 * @return String
	 */
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}
	/**
	 * 主数据分类编码
	 * @param Code_ca
	 */
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	/**
	 * 主数据分类名称
	 * @return String
	 */
	public String getName_ca() {
		return ((String) getAttrVal("Name_ca"));
	}
	/**
	 * 主数据分类名称
	 * @param Name_ca
	 */
	public void setName_ca(String Name_ca) {
		setAttrVal("Name_ca", Name_ca);
	}
	/**
	 * 主数据ID
	 * @return String
	 */
	public String getId_md() {
		return ((String) getAttrVal("Id_md"));
	}
	/**
	 * 主数据ID
	 * @param Id_md
	 */
	public void setId_md(String Id_md) {
		setAttrVal("Id_md", Id_md);
	}
	/**
	 * 主数据名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 主数据名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 主数据key
	 * @return String
	 */
	public String getKey_iih() {
		return ((String) getAttrVal("Key_iih"));
	}
	/**
	 * 主数据key
	 * @param Key_iih
	 */
	public void setKey_iih(String Key_iih) {
		setAttrVal("Key_iih", Key_iih);
	}
	/**
	 * 主数据编码
	 * @return String
	 */
	public String getCode_iih() {
		return ((String) getAttrVal("Code_iih"));
	}
	/**
	 * 主数据编码
	 * @param Code_iih
	 */
	public void setCode_iih(String Code_iih) {
		setAttrVal("Code_iih", Code_iih);
	}
	/**
	 * 第三方编码
	 * @return String
	 */
	public String getCode_thrd() {
		return ((String) getAttrVal("Code_thrd"));
	}
	/**
	 * 第三方编码
	 * @param Code_thrd
	 */
	public void setCode_thrd(String Code_thrd) {
		setAttrVal("Code_thrd", Code_thrd);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
}