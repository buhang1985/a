package iih.mi.mc.dto.mimcwholerule.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱服务信息 DTO数据 
 * 
 */
public class MiMcOrdSrvDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 病种code
	 * @return String
	 */
	public String getCode_dsdef() {
		return ((String) getAttrVal("Code_dsdef"));
	}
	/**
	 * 病种code
	 * @param Code_dsdef
	 */
	public void setCode_dsdef(String Code_dsdef) {
		setAttrVal("Code_dsdef", Code_dsdef);
	}
	/**
	 * 病种名称
	 * @return String
	 */
	public String getName_dsdef() {
		return ((String) getAttrVal("Name_dsdef"));
	}
	/**
	 * 病种名称
	 * @param Name_dsdef
	 */
	public void setName_dsdef(String Name_dsdef) {
		setAttrVal("Name_dsdef", Name_dsdef);
	}
	/**
	 * 诊断id
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 诊断id
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 医嘱服务id
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务id
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
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
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
	 * 物品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 物品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 是否特殊病药品
	 * @return FBoolean
	 */
	public FBoolean getSpecdrug_flag() {
		return ((FBoolean) getAttrVal("Specdrug_flag"));
	}
	/**
	 * 是否特殊病药品
	 * @param Specdrug_flag
	 */
	public void setSpecdrug_flag(FBoolean Specdrug_flag) {
		setAttrVal("Specdrug_flag", Specdrug_flag);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 剂量
	 * @return String
	 */
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}
	/**
	 * 剂量
	 * @param Id_dosage
	 */
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	/**
	 * 当前物品持有天数
	 * @return Integer
	 */
	public Integer getDays_available() {
		return ((Integer) getAttrVal("Days_available"));
	}
	/**
	 * 当前物品持有天数
	 * @param Days_available
	 */
	public void setDays_available(Integer Days_available) {
		setAttrVal("Days_available", Days_available);
	}
	/**
	 * 换算系数
	 * @return FDouble
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}
	/**
	 * 换算系数
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	/**
	 * 换算系数_医疗基本
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}
	/**
	 * 换算系数_医疗基本
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	/**
	 * 开单量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 开单量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 开单单位id
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}
	/**
	 * 开单单位id
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 开单单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 开单单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
}