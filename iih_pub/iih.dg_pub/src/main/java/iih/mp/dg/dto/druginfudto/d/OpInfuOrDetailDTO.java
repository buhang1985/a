package iih.mp.dg.dto.druginfudto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱明细 DTO数据 
 * 
 */
public class OpInfuOrDetailDTO extends BaseDTO {
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
	 * 频次id
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次id
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
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
	 * 是否需要皮试
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}
	/**
	 * 是否需要皮试
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
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
	 * 自带药
	 * @return FBoolean
	 */
	public FBoolean getFg_byo() {
		return ((FBoolean) getAttrVal("Fg_byo"));
	}
	/**
	 * 自带药
	 * @param Fg_byo
	 */
	public void setFg_byo(FBoolean Fg_byo) {
		setAttrVal("Fg_byo", Fg_byo);
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
	 * 完成状态
	 * @return String
	 */
	public String getStatus_fin() {
		return ((String) getAttrVal("Status_fin"));
	}
	/**
	 * 完成状态
	 * @param Status_fin
	 */
	public void setStatus_fin(String Status_fin) {
		setAttrVal("Status_fin", Status_fin);
	}
	/**
	 * 执行时间
	 * @return FTime
	 */
	public FTime getTime_plan() {
		return ((FTime) getAttrVal("Time_plan"));
	}
	/**
	 * 执行时间
	 * @param Time_plan
	 */
	public void setTime_plan(FTime Time_plan) {
		setAttrVal("Time_plan", Time_plan);
	}
	/**
	 * 输液次数
	 * @return Integer
	 */
	public Integer getTrans_times() {
		return ((Integer) getAttrVal("Trans_times"));
	}
	/**
	 * 输液次数
	 * @param Trans_times
	 */
	public void setTrans_times(Integer Trans_times) {
		setAttrVal("Trans_times", Trans_times);
	}
	/**
	 * 瓶贴二维码
	 * @return String
	 */
	public String getQrcode_label() {
		return ((String) getAttrVal("Qrcode_label"));
	}
	/**
	 * 瓶贴二维码
	 * @param Qrcode_label
	 */
	public void setQrcode_label(String Qrcode_label) {
		setAttrVal("Qrcode_label", Qrcode_label);
	}
	/**
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getOpent_times() {
		return ((Integer) getAttrVal("Opent_times"));
	}
	/**
	 * 就诊次数
	 * @param Opent_times
	 */
	public void setOpent_times(Integer Opent_times) {
		setAttrVal("Opent_times", Opent_times);
	}
	/**
	 * 药品打印名称
	 * @return String
	 */
	public String getPrintname() {
		return ((String) getAttrVal("Printname"));
	}
	/**
	 * 药品打印名称
	 * @param Printname
	 */
	public void setPrintname(String Printname) {
		setAttrVal("Printname", Printname);
	}
}