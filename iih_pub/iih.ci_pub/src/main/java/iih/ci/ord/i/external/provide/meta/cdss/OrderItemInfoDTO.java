package iih.ci.ord.i.external.provide.meta.cdss;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱项目DTO DTO数据 
 * 
 */
public class OrderItemInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 项目id
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 项目id
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 药物商品名
	 * @return String
	 */
	public String getTrade_name() {
		return ((String) getAttrVal("Trade_name"));
	}
	/**
	 * 药物商品名
	 * @param Trade_name
	 */
	public void setTrade_name(String Trade_name) {
		setAttrVal("Trade_name", Trade_name);
	}
	/**
	 * 药物通用名
	 * @return String
	 */
	public String getCommon_name() {
		return ((String) getAttrVal("Common_name"));
	}
	/**
	 * 药物通用名
	 * @param Common_name
	 */
	public void setCommon_name(String Common_name) {
		setAttrVal("Common_name", Common_name);
	}
	/**
	 * 国药准字号
	 * @return String
	 */
	public String getApprno() {
		return ((String) getAttrVal("Apprno"));
	}
	/**
	 * 国药准字号
	 * @param Apprno
	 */
	public void setApprno(String Apprno) {
		setAttrVal("Apprno", Apprno);
	}
	/**
	 * 药物编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 药物编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 药物类别
	 * @return String
	 */
	public String getName_mmca() {
		return ((String) getAttrVal("Name_mmca"));
	}
	/**
	 * 药物类别
	 * @param Name_mmca
	 */
	public void setName_mmca(String Name_mmca) {
		setAttrVal("Name_mmca", Name_mmca);
	}
	/**
	 * 药物剂型
	 * @return String
	 */
	public String getName_dosage() {
		return ((String) getAttrVal("Name_dosage"));
	}
	/**
	 * 药物剂型
	 * @param Name_dosage
	 */
	public void setName_dosage(String Name_dosage) {
		setAttrVal("Name_dosage", Name_dosage);
	}
	/**
	 * 用药途径
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用药途径
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 频次编码
	 * @return String
	 */
	public String getCode_freq() {
		return ((String) getAttrVal("Code_freq"));
	}
	/**
	 * 频次编码
	 * @param Code_freq
	 */
	public void setCode_freq(String Code_freq) {
		setAttrVal("Code_freq", Code_freq);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 频次名称
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 单次剂量
	 * @return String
	 */
	public String getQuan_med() {
		return ((String) getAttrVal("Quan_med"));
	}
	/**
	 * 单次剂量
	 * @param Quan_med
	 */
	public void setQuan_med(String Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	/**
	 * 总剂量
	 * @return String
	 */
	public String getQuan_total_medu() {
		return ((String) getAttrVal("Quan_total_medu"));
	}
	/**
	 * 总剂量
	 * @param Quan_total_medu
	 */
	public void setQuan_total_medu(String Quan_total_medu) {
		setAttrVal("Quan_total_medu", Quan_total_medu);
	}
	/**
	 * 剂量单位
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 剂量单位
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 是否皮试
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}
	/**
	 * 是否皮试
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
}