package iih.bl.inc.blcpntpdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class BlCpnTpDto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 优惠券类型主键
	 * @return String
	 */
	public String getId_tr() {
		return ((String) getAttrVal("Id_tr"));
	}
	/**
	 * 优惠券类型主键
	 * @param Id_tr
	 */
	public void setId_tr(String Id_tr) {
		setAttrVal("Id_tr", Id_tr);
	}
	/**
	 * 优惠券类型
	 * @return String
	 */
	public String getName_tr() {
		return ((String) getAttrVal("Name_tr"));
	}
	/**
	 * 优惠券类型
	 * @param Name_tr
	 */
	public void setName_tr(String Name_tr) {
		setAttrVal("Name_tr", Name_tr);
	}
	/**
	 * 优惠券类型编码
	 * @return String
	 */
	public String getCode_tr() {
		return ((String) getAttrVal("Code_tr"));
	}
	/**
	 * 优惠券类型编码
	 * @param Code_tr
	 */
	public void setCode_tr(String Code_tr) {
		setAttrVal("Code_tr", Code_tr);
	}
	/**
	 * 优惠券规则编码
	 * @return String
	 */
	public String getCoderule_cpn() {
		return ((String) getAttrVal("Coderule_cpn"));
	}
	/**
	 * 优惠券规则编码
	 * @param Coderule_cpn
	 */
	public void setCoderule_cpn(String Coderule_cpn) {
		setAttrVal("Coderule_cpn", Coderule_cpn);
	}
	/**
	 * 优惠券父类型
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}
	/**
	 * 优惠券父类型
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	/**
	 * 级别
	 * @return Integer
	 */
	public Integer getLevel_tr() {
		return ((Integer) getAttrVal("Level_tr"));
	}
	/**
	 * 级别
	 * @param Level_tr
	 */
	public void setLevel_tr(Integer Level_tr) {
		setAttrVal("Level_tr", Level_tr);
	}
}