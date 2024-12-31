package iih.bd.mm.medidirecdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 包药机药品维护目录DTO DTO数据 
 * 
 */
public class MedicDirecDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 包药机维护目录主键
	 * @return String
	 */
	public String getId_oralmech_rel() {
		return ((String) getAttrVal("Id_oralmech_rel"));
	}
	/**
	 * 包药机维护目录主键
	 * @param Id_oralmech_rel
	 */
	public void setId_oralmech_rel(String Id_oralmech_rel) {
		setAttrVal("Id_oralmech_rel", Id_oralmech_rel);
	}
	/**
	 * 药品编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 药品编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 药品名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 通用名
	 * @return String
	 */
	public String getGenericname() {
		return ((String) getAttrVal("Genericname"));
	}
	/**
	 * 通用名
	 * @param Genericname
	 */
	public void setGenericname(String Genericname) {
		setAttrVal("Genericname", Genericname);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 剂型
	 * @return String
	 */
	public String getDosageform() {
		return ((String) getAttrVal("Dosageform"));
	}
	/**
	 * 剂型
	 * @param Dosageform
	 */
	public void setDosageform(String Dosageform) {
		setAttrVal("Dosageform", Dosageform);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 生产厂商
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}
	/**
	 * 生产厂商
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
}