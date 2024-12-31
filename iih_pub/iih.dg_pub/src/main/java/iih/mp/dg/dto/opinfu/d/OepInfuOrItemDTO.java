package iih.mp.dg.dto.opinfu.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 输液管理处方明细 DTO数据 
 * 
 */
public class OepInfuOrItemDTO extends BaseDTO {
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
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getEnt_times() {
		return ((Integer) getAttrVal("Ent_times"));
	}
	/**
	 * 就诊次数
	 * @param Ent_times
	 */
	public void setEnt_times(Integer Ent_times) {
		setAttrVal("Ent_times", Ent_times);
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
	 * 对应天数
	 * @return Integer
	 */
	public Integer getTarget_day() {
		return ((Integer) getAttrVal("Target_day"));
	}
	/**
	 * 对应天数
	 * @param Target_day
	 */
	public void setTarget_day(Integer Target_day) {
		setAttrVal("Target_day", Target_day);
	}
	/**
	 * 请领主键
	 * @return String
	 */
	public String getId_dgoepdt() {
		return ((String) getAttrVal("Id_dgoepdt"));
	}
	/**
	 * 请领主键
	 * @param Id_dgoepdt
	 */
	public void setId_dgoepdt(String Id_dgoepdt) {
		setAttrVal("Id_dgoepdt", Id_dgoepdt);
	}
	/**
	 * 输液表主键
	 * @return String
	 */
	public String getId_dgoepinfu() {
		return ((String) getAttrVal("Id_dgoepinfu"));
	}
	/**
	 * 输液表主键
	 * @param Id_dgoepinfu
	 */
	public void setId_dgoepinfu(String Id_dgoepinfu) {
		setAttrVal("Id_dgoepinfu", Id_dgoepinfu);
	}
	/**
	 * 执行时间
	 * @return FTime
	 */
	public FTime getMp_time() {
		return ((FTime) getAttrVal("Mp_time"));
	}
	/**
	 * 执行时间
	 * @param Mp_time
	 */
	public void setMp_time(FTime Mp_time) {
		setAttrVal("Mp_time", Mp_time);
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
}