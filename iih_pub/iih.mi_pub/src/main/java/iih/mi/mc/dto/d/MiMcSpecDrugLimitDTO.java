package iih.mi.mc.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者医保特殊病药品控制量dto DTO数据 
 * 
 */
public class MiMcSpecDrugLimitDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊断id
	 * @return String
	 */
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}
	/**
	 * 诊断id
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}
	/**
	 * 诊断编码
	 * @param Code_di
	 */
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
	}
	/**
	 * 病种id
	 * @return String
	 */
	public String getId_dsdef() {
		return ((String) getAttrVal("Id_dsdef"));
	}
	/**
	 * 病种id
	 * @param Id_dsdef
	 */
	public void setId_dsdef(String Id_dsdef) {
		setAttrVal("Id_dsdef", Id_dsdef);
	}
	/**
	 * 病种编码
	 * @return String
	 */
	public String getCode_ds() {
		return ((String) getAttrVal("Code_ds"));
	}
	/**
	 * 病种编码
	 * @param Code_ds
	 */
	public void setCode_ds(String Code_ds) {
		setAttrVal("Code_ds", Code_ds);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 控制类型
	 * @return Integer
	 */
	public Integer getSd_control() {
		return ((Integer) getAttrVal("Sd_control"));
	}
	/**
	 * 控制类型
	 * @param Sd_control
	 */
	public void setSd_control(Integer Sd_control) {
		setAttrVal("Sd_control", Sd_control);
	}
	/**
	 * 限制数量（换算后）
	 * @return FDouble
	 */
	public FDouble getQuan_limit() {
		return ((FDouble) getAttrVal("Quan_limit"));
	}
	/**
	 * 限制数量（换算后）
	 * @param Quan_limit
	 */
	public void setQuan_limit(FDouble Quan_limit) {
		setAttrVal("Quan_limit", Quan_limit);
	}
	/**
	 * 单位id
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}
	/**
	 * 单位id
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 原限制数量
	 * @return FDouble
	 */
	public FDouble getQuan_ori_limit() {
		return ((FDouble) getAttrVal("Quan_ori_limit"));
	}
	/**
	 * 原限制数量
	 * @param Quan_ori_limit
	 */
	public void setQuan_ori_limit(FDouble Quan_ori_limit) {
		setAttrVal("Quan_ori_limit", Quan_ori_limit);
	}
	/**
	 * 基本包装单位
	 * @return String
	 */
	public String getId_unit_pkgbase() {
		return ((String) getAttrVal("Id_unit_pkgbase"));
	}
	/**
	 * 基本包装单位
	 * @param Id_unit_pkgbase
	 */
	public void setId_unit_pkgbase(String Id_unit_pkgbase) {
		setAttrVal("Id_unit_pkgbase", Id_unit_pkgbase);
	}
}