package iih.mi.itf2.dto.drugmanualcomp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 查询已对照的原始目录入参 DTO数据 
 * 
 */
public class LoadOrginalDataInParam extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 目录类型
	 * @return String
	 */
	public String getDirtype() {
		return ((String) getAttrVal("Dirtype"));
	}
	/**
	 * 目录类型
	 * @param Dirtype
	 */
	public void setDirtype(String Dirtype) {
		setAttrVal("Dirtype", Dirtype);
	}
	/**
	 * 医保计划主键
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划主键
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保项目编码集合
	 * @return FArrayList
	 */
	public FArrayList getCodes() {
		return ((FArrayList) getAttrVal("Codes"));
	}
	/**
	 * 医保项目编码集合
	 * @param Codes
	 */
	public void setCodes(FArrayList Codes) {
		setAttrVal("Codes", Codes);
	}
}