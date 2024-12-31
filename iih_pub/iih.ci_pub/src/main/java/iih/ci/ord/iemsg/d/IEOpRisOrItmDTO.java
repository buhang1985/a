package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE门诊检查申请对应项目信息DTO DTO数据 
 * 
 */
public class IEOpRisOrItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE检查申请对应项目主键标识
	 * @return String
	 */
	public String getId_ierisoritm() {
		return ((String) getAttrVal("Id_ierisoritm"));
	}	
	/**
	 * IE检查申请对应项目主键标识
	 * @param Id_ierisoritm
	 */
	public void setId_ierisoritm(String Id_ierisoritm) {
		setAttrVal("Id_ierisoritm", Id_ierisoritm);
	}
	/**
	 * IE检查申请
	 * @return String
	 */
	public String getId_ierisor() {
		return ((String) getAttrVal("Id_ierisor"));
	}	
	/**
	 * IE检查申请
	 * @param Id_ierisor
	 */
	public void setId_ierisor(String Id_ierisor) {
		setAttrVal("Id_ierisor", Id_ierisor);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getExam_serial() {
		return ((String) getAttrVal("Exam_serial"));
	}	
	/**
	 * 医嘱号
	 * @param Exam_serial
	 */
	public void setExam_serial(String Exam_serial) {
		setAttrVal("Exam_serial", Exam_serial);
	}
	/**
	 * 检查项目编码
	 * @return String
	 */
	public String getExam_sub_type() {
		return ((String) getAttrVal("Exam_sub_type"));
	}	
	/**
	 * 检查项目编码
	 * @param Exam_sub_type
	 */
	public void setExam_sub_type(String Exam_sub_type) {
		setAttrVal("Exam_sub_type", Exam_sub_type);
	}
	/**
	 * 检查项目名称
	 * @return String
	 */
	public String getExam_sub_type_name() {
		return ((String) getAttrVal("Exam_sub_type_name"));
	}	
	/**
	 * 检查项目名称
	 * @param Exam_sub_type_name
	 */
	public void setExam_sub_type_name(String Exam_sub_type_name) {
		setAttrVal("Exam_sub_type_name", Exam_sub_type_name);
	}
	/**
	 * 医嘱费用
	 * @return String
	 */
	public String getOrder_pri() {
		return ((String) getAttrVal("Order_pri"));
	}	
	/**
	 * 医嘱费用
	 * @param Order_pri
	 */
	public void setOrder_pri(String Order_pri) {
		setAttrVal("Order_pri", Order_pri);
	}
	/**
	 * 医嘱开始时间
	 * @return String
	 */
	public String getDt_effe() {
		return ((String) getAttrVal("Dt_effe"));
	}	
	/**
	 * 医嘱开始时间
	 * @param Dt_effe
	 */
	public void setDt_effe(String Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 医嘱停止时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}	
	/**
	 * 医嘱停止时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 医嘱执行频率编码
	 * @return String
	 */
	public String getYz_frequency() {
		return ((String) getAttrVal("Yz_frequency"));
	}	
	/**
	 * 医嘱执行频率编码
	 * @param Yz_frequency
	 */
	public void setYz_frequency(String Yz_frequency) {
		setAttrVal("Yz_frequency", Yz_frequency);
	}
	/**
	 * 医嘱执行频率名称
	 * @return String
	 */
	public String getYz_frequency_name() {
		return ((String) getAttrVal("Yz_frequency_name"));
	}	
	/**
	 * 医嘱执行频率名称
	 * @param Yz_frequency_name
	 */
	public void setYz_frequency_name(String Yz_frequency_name) {
		setAttrVal("Yz_frequency_name", Yz_frequency_name);
	}
	/**
	 * 检查方法变编码
	 * @return String
	 */
	public String getExam_sub_fftype() {
		return ((String) getAttrVal("Exam_sub_fftype"));
	}	
	/**
	 * 检查方法变编码
	 * @param Exam_sub_fftype
	 */
	public void setExam_sub_fftype(String Exam_sub_fftype) {
		setAttrVal("Exam_sub_fftype", Exam_sub_fftype);
	}
	/**
	 * 检查方法名
	 * @return String
	 */
	public String getExam_sub_fftype_name() {
		return ((String) getAttrVal("Exam_sub_fftype_name"));
	}	
	/**
	 * 检查方法名
	 * @param Exam_sub_fftype_name
	 */
	public void setExam_sub_fftype_name(String Exam_sub_fftype_name) {
		setAttrVal("Exam_sub_fftype_name", Exam_sub_fftype_name);
	}
	/**
	 * 检查部位编码
	 * @return String
	 */
	public String getExam_region() {
		return ((String) getAttrVal("Exam_region"));
	}	
	/**
	 * 检查部位编码
	 * @param Exam_region
	 */
	public void setExam_region(String Exam_region) {
		setAttrVal("Exam_region", Exam_region);
	}
	/**
	 * 检查部位名称
	 * @return String
	 */
	public String getExam_region_name() {
		return ((String) getAttrVal("Exam_region_name"));
	}	
	/**
	 * 检查部位名称
	 * @param Exam_region_name
	 */
	public void setExam_region_name(String Exam_region_name) {
		setAttrVal("Exam_region_name", Exam_region_name);
	}
	/**
	 * 是否皮试
	 * @return String
	 */
	public String getIsstest() {
		return ((String) getAttrVal("Isstest"));
	}	
	/**
	 * 是否皮试
	 * @param Isstest
	 */
	public void setIsstest(String Isstest) {
		setAttrVal("Isstest", Isstest);
	}
	/**
	 * 是否皮试结果
	 * @return String
	 */
	public String getStest() {
		return ((String) getAttrVal("Stest"));
	}	
	/**
	 * 是否皮试结果
	 * @param Stest
	 */
	public void setStest(String Stest) {
		setAttrVal("Stest", Stest);
	}
	/**
	 * 是否加急
	 * @return String
	 */
	public String getIs_em() {
		return ((String) getAttrVal("Is_em"));
	}	
	/**
	 * 是否加急
	 * @param Is_em
	 */
	public void setIs_em(String Is_em) {
		setAttrVal("Is_em", Is_em);
	}
	/**
	 * 是否加急结果
	 * @return String
	 */
	public String getIs_em_r() {
		return ((String) getAttrVal("Is_em_r"));
	}	
	/**
	 * 是否加急结果
	 * @param Is_em_r
	 */
	public void setIs_em_r(String Is_em_r) {
		setAttrVal("Is_em_r", Is_em_r);
	}
	/**
	 * 是否药观
	 * @return String
	 */
	public String getIsyg() {
		return ((String) getAttrVal("Isyg"));
	}	
	/**
	 * 是否药观
	 * @param Isyg
	 */
	public void setIsyg(String Isyg) {
		setAttrVal("Isyg", Isyg);
	}
	/**
	 * 是否药观结果
	 * @return String
	 */
	public String getYg() {
		return ((String) getAttrVal("Yg"));
	}	
	/**
	 * 是否药观结果
	 * @param Yg
	 */
	public void setYg(String Yg) {
		setAttrVal("Yg", Yg);
	}
	/**
	 * vip的值
	 * @return String
	 */
	public String getEu_vip() {
		return ((String) getAttrVal("Eu_vip"));
	}	
	/**
	 * vip的值
	 * @param Eu_vip
	 */
	public void setEu_vip(String Eu_vip) {
		setAttrVal("Eu_vip", Eu_vip);
	}
	/**
	 * 是否vip
	 * @return String
	 */
	public String getIsvip() {
		return ((String) getAttrVal("Isvip"));
	}	
	/**
	 * 是否vip
	 * @param Isvip
	 */
	public void setIsvip(String Isvip) {
		setAttrVal("Isvip", Isvip);
	}
	/**
	 * 医嘱时间类型编码
	 * @return String
	 */
	public String getOrdertimetype() {
		return ((String) getAttrVal("Ordertimetype"));
	}	
	/**
	 * 医嘱时间类型编码
	 * @param Ordertimetype
	 */
	public void setOrdertimetype(String Ordertimetype) {
		setAttrVal("Ordertimetype", Ordertimetype);
	}
	/**
	 * 医嘱时间类型名称
	 * @return String
	 */
	public String getOrdertimetypename() {
		return ((String) getAttrVal("Ordertimetypename"));
	}	
	/**
	 * 医嘱时间类型名称
	 * @param Ordertimetypename
	 */
	public void setOrdertimetypename(String Ordertimetypename) {
		setAttrVal("Ordertimetypename", Ordertimetypename);
	}
	/**
	 * 收费状态标识
	 * @return String
	 */
	public String getPayflag() {
		return ((String) getAttrVal("Payflag"));
	}	
	/**
	 * 收费状态标识
	 * @param Payflag
	 */
	public void setPayflag(String Payflag) {
		setAttrVal("Payflag", Payflag);
	}
	/**
	 * HIS执行状态
	 * @return String
	 */
	public String getHis_exec_status() {
		return ((String) getAttrVal("His_exec_status"));
	}	
	/**
	 * HIS执行状态
	 * @param His_exec_status
	 */
	public void setHis_exec_status(String His_exec_status) {
		setAttrVal("His_exec_status", His_exec_status);
	}
	/**
	 * 检查类型编码
	 * @return String
	 */
	public String getExamtypecode() {
		return ((String) getAttrVal("Examtypecode"));
	}	
	/**
	 * 检查类型编码
	 * @param Examtypecode
	 */
	public void setExamtypecode(String Examtypecode) {
		setAttrVal("Examtypecode", Examtypecode);
	}
	/**
	 * 检查类型名称
	 * @return String
	 */
	public String getExamtypename() {
		return ((String) getAttrVal("Examtypename"));
	}	
	/**
	 * 检查类型名称
	 * @param Examtypename
	 */
	public void setExamtypename(String Examtypename) {
		setAttrVal("Examtypename", Examtypename);
	}
	/**
	 * 是否哺乳
	 * @return String
	 */
	public String getIsbreastfeeding() {
		return ((String) getAttrVal("Isbreastfeeding"));
	}	
	/**
	 * 是否哺乳
	 * @param Isbreastfeeding
	 */
	public void setIsbreastfeeding(String Isbreastfeeding) {
		setAttrVal("Isbreastfeeding", Isbreastfeeding);
	}
	/**
	 * 是否妊娠
	 * @return String
	 */
	public String getIspregnancy() {
		return ((String) getAttrVal("Ispregnancy"));
	}	
	/**
	 * 是否妊娠
	 * @param Ispregnancy
	 */
	public void setIspregnancy(String Ispregnancy) {
		setAttrVal("Ispregnancy", Ispregnancy);
	}
	/**
	 * 体重
	 * @return String
	 */
	public String getWeight() {
		return ((String) getAttrVal("Weight"));
	}	
	/**
	 * 体重
	 * @param Weight
	 */
	public void setWeight(String Weight) {
		setAttrVal("Weight", Weight);
	}
	/**
	 * 身高
	 * @return String
	 */
	public String getHeight() {
		return ((String) getAttrVal("Height"));
	}	
	/**
	 * 身高
	 * @param Height
	 */
	public void setHeight(String Height) {
		setAttrVal("Height", Height);
	}
	/**
	 * 体重单位
	 * @return String
	 */
	public String getWeight_unit() {
		return ((String) getAttrVal("Weight_unit"));
	}	
	/**
	 * 体重单位
	 * @param Weight_unit
	 */
	public void setWeight_unit(String Weight_unit) {
		setAttrVal("Weight_unit", Weight_unit);
	}
	/**
	 * 身高单位
	 * @return String
	 */
	public String getHeight_unit() {
		return ((String) getAttrVal("Height_unit"));
	}	
	/**
	 * 身高单位
	 * @param Height_unit
	 */
	public void setHeight_unit(String Height_unit) {
		setAttrVal("Height_unit", Height_unit);
	}
	/**
	 * 妊娠时间
	 * @return FDateTime
	 */
	public FDateTime getPregnancy_date() {
		return ((FDateTime) getAttrVal("Pregnancy_date"));
	}	
	/**
	 * 妊娠时间
	 * @param Pregnancy_date
	 */
	public void setPregnancy_date(FDateTime Pregnancy_date) {
		setAttrVal("Pregnancy_date", Pregnancy_date);
	}
	/**
	 * 费用金额
	 * @return String
	 */
	public String getAmounts() {
		return ((String) getAttrVal("Amounts"));
	}	
	/**
	 * 费用金额
	 * @param Amounts
	 */
	public void setAmounts(String Amounts) {
		setAttrVal("Amounts", Amounts);
	}
	/**
	 * 检查类型编码（服务类型）
	 * @return String
	 */
	public String getSer_type_code() {
		return ((String) getAttrVal("Ser_type_code"));
	}	
	/**
	 * 检查类型编码（服务类型）
	 * @param Ser_type_code
	 */
	public void setSer_type_code(String Ser_type_code) {
		setAttrVal("Ser_type_code", Ser_type_code);
	}
	/**
	 * 检查类型编码名称（服务类型）
	 * @return String
	 */
	public String getSer_type_name() {
		return ((String) getAttrVal("Ser_type_name"));
	}	
	/**
	 * 检查类型编码名称（服务类型）
	 * @param Ser_type_name
	 */
	public void setSer_type_name(String Ser_type_name) {
		setAttrVal("Ser_type_name", Ser_type_name);
	}
}