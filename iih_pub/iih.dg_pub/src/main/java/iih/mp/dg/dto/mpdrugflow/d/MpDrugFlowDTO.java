package iih.mp.dg.dto.mpdrugflow.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 物品物资流向及库存价格 DTO数据 
 * 
 */
public class MpDrugFlowDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 服务分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_usage() {
		return ((String) getAttrVal("Id_usage"));
	}
	/**
	 * 用法
	 * @param Id_usage
	 */
	public void setId_usage(String Id_usage) {
		setAttrVal("Id_usage", Id_usage);
	}
	/**
	 * 流向类型
	 * @return Integer
	 */
	public Integer getEu_wftp() {
		return ((Integer) getAttrVal("Eu_wftp"));
	}
	/**
	 * 流向类型
	 * @param Eu_wftp
	 */
	public void setEu_wftp(Integer Eu_wftp) {
		setAttrVal("Eu_wftp", Eu_wftp);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getId_measdoc() {
		return ((String) getAttrVal("Id_measdoc"));
	}
	/**
	 * 单位
	 * @param Id_measdoc
	 */
	public void setId_measdoc(String Id_measdoc) {
		setAttrVal("Id_measdoc", Id_measdoc);
	}
	/**
	 * 长临标识
	 * @return String
	 */
	public String getRecurstr() {
		return ((String) getAttrVal("Recurstr"));
	}
	/**
	 * 长临标识
	 * @param Recurstr
	 */
	public void setRecurstr(String Recurstr) {
		setAttrVal("Recurstr", Recurstr);
	}
	/**
	 * 星期几
	 * @return String
	 */
	public String getWeekno() {
		return ((String) getAttrVal("Weekno"));
	}
	/**
	 * 星期几
	 * @param Weekno
	 */
	public void setWeekno(String Weekno) {
		setAttrVal("Weekno", Weekno);
	}
	/**
	 * 时间
	 * @return FTime
	 */
	public FTime getTimestr() {
		return ((FTime) getAttrVal("Timestr"));
	}
	/**
	 * 时间
	 * @param Timestr
	 */
	public void setTimestr(FTime Timestr) {
		setAttrVal("Timestr", Timestr);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getId_dept_en() {
		return ((String) getAttrVal("Id_dept_en"));
	}
	/**
	 * 就诊科室
	 * @param Id_dept_en
	 */
	public void setId_dept_en(String Id_dept_en) {
		setAttrVal("Id_dept_en", Id_dept_en);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dept_ns() {
		return ((String) getAttrVal("Id_dept_ns"));
	}
	/**
	 * 病区
	 * @param Id_dept_ns
	 */
	public void setId_dept_ns(String Id_dept_ns) {
		setAttrVal("Id_dept_ns", Id_dept_ns);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dept_or() {
		return ((String) getAttrVal("Id_dept_or"));
	}
	/**
	 * 开立科室
	 * @param Id_dept_or
	 */
	public void setId_dept_or(String Id_dept_or) {
		setAttrVal("Id_dept_or", Id_dept_or);
	}
	/**
	 * 服务分类内编码
	 * @return String
	 */
	public String getInnercode_srvca() {
		return ((String) getAttrVal("Innercode_srvca"));
	}
	/**
	 * 服务分类内编码
	 * @param Innercode_srvca
	 */
	public void setInnercode_srvca(String Innercode_srvca) {
		setAttrVal("Innercode_srvca", Innercode_srvca);
	}
	/**
	 * 出院带药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}
	/**
	 * 出院带药标识
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	/**
	 * 药品剂型
	 * @return String
	 */
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}
	/**
	 * 药品剂型
	 * @param Id_dosage
	 */
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	/**
	 * 毒麻类型
	 * @return String
	 */
	public String getSd_pois() {
		return ((String) getAttrVal("Sd_pois"));
	}
	/**
	 * 毒麻类型
	 * @param Sd_pois
	 */
	public void setSd_pois(String Sd_pois) {
		setAttrVal("Sd_pois", Sd_pois);
	}
	/**
	 * 流向科室执行
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 流向科室执行
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 流向科室物资
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	/**
	 * 流向科室物资
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 取得结果
	 * @return FBoolean
	 */
	public FBoolean getResult() {
		return ((FBoolean) getAttrVal("Result"));
	}
	/**
	 * 取得结果
	 * @param Result
	 */
	public void setResult(FBoolean Result) {
		setAttrVal("Result", Result);
	}
}