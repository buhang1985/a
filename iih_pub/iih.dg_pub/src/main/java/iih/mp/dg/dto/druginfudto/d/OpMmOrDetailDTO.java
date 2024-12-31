package iih.mp.dg.dto.druginfudto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 输液用药明细 DTO数据 
 * 
 */
public class OpMmOrDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱服务主键
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务主键
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医嘱服务名称
	 * @return String
	 */
	public String getName_orsrv() {
		return ((String) getAttrVal("Name_orsrv"));
	}
	/**
	 * 医嘱服务名称
	 * @param Name_orsrv
	 */
	public void setName_orsrv(String Name_orsrv) {
		setAttrVal("Name_orsrv", Name_orsrv);
	}
	/**
	 * 药品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 药品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 药品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 单次剂量
	 * @return String
	 */
	public String getSingle_med() {
		return ((String) getAttrVal("Single_med"));
	}
	/**
	 * 单次剂量
	 * @param Single_med
	 */
	public void setSingle_med(String Single_med) {
		setAttrVal("Single_med", Single_med);
	}
	/**
	 * 皮试id
	 * @return String
	 */
	public String getId_skintest() {
		return ((String) getAttrVal("Id_skintest"));
	}
	/**
	 * 皮试id
	 * @param Id_skintest
	 */
	public void setId_skintest(String Id_skintest) {
		setAttrVal("Id_skintest", Id_skintest);
	}
	/**
	 * 皮试名称
	 * @return String
	 */
	public String getName_skintest() {
		return ((String) getAttrVal("Name_skintest"));
	}
	/**
	 * 皮试名称
	 * @param Name_skintest
	 */
	public void setName_skintest(String Name_skintest) {
		setAttrVal("Name_skintest", Name_skintest);
	}
	/**
	 * 处方id
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方id
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 处方编码
	 * @return String
	 */
	public String getCode_pres() {
		return ((String) getAttrVal("Code_pres"));
	}
	/**
	 * 处方编码
	 * @param Code_pres
	 */
	public void setCode_pres(String Code_pres) {
		setAttrVal("Code_pres", Code_pres);
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
	 * 用法id
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法id
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法名称
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 用法编码
	 * @return String
	 */
	public String getCode_route() {
		return ((String) getAttrVal("Code_route"));
	}
	/**
	 * 用法编码
	 * @param Code_route
	 */
	public void setCode_route(String Code_route) {
		setAttrVal("Code_route", Code_route);
	}
	/**
	 * 批次
	 * @return String
	 */
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}
	/**
	 * 批次
	 * @param Batch
	 */
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	/**
	 * 唯一码
	 * @return String
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}
	/**
	 * 唯一码
	 * @param Onlycode
	 */
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}
	/**
	 * 生产厂家
	 * @return String
	 */
	public String getId_fac() {
		return ((String) getAttrVal("Id_fac"));
	}
	/**
	 * 生产厂家
	 * @param Id_fac
	 */
	public void setId_fac(String Id_fac) {
		setAttrVal("Id_fac", Id_fac);
	}
	/**
	 * 生厂厂家名称
	 * @return String
	 */
	public String getName_fac() {
		return ((String) getAttrVal("Name_fac"));
	}
	/**
	 * 生厂厂家名称
	 * @param Name_fac
	 */
	public void setName_fac(String Name_fac) {
		setAttrVal("Name_fac", Name_fac);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getId_mmpkgu() {
		return ((String) getAttrVal("Id_mmpkgu"));
	}
	/**
	 * 医学单位
	 * @param Id_mmpkgu
	 */
	public void setId_mmpkgu(String Id_mmpkgu) {
		setAttrVal("Id_mmpkgu", Id_mmpkgu);
	}
	/**
	 * 医学单位名称
	 * @return String
	 */
	public String getMmpkgu_name() {
		return ((String) getAttrVal("Mmpkgu_name"));
	}
	/**
	 * 医学单位名称
	 * @param Mmpkgu_name
	 */
	public void setMmpkgu_name(String Mmpkgu_name) {
		setAttrVal("Mmpkgu_name", Mmpkgu_name);
	}
}