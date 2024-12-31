package iih.hp.cp.importhp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 临床路径导入元数据 DTO数据 
 * 
 */
public class HpcpimportDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 路径名称
	 * @return String
	 */
	public String getHpcp_name() {
		return ((String) getAttrVal("Hpcp_name"));
	}
	/**
	 * 路径名称
	 * @param Hpcp_name
	 */
	public void setHpcp_name(String Hpcp_name) {
		setAttrVal("Hpcp_name", Hpcp_name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getDi_code() {
		return ((String) getAttrVal("Di_code"));
	}
	/**
	 * 诊断编码
	 * @param Di_code
	 */
	public void setDi_code(String Di_code) {
		setAttrVal("Di_code", Di_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDi_name() {
		return ((String) getAttrVal("Di_name"));
	}
	/**
	 * 诊断名称
	 * @param Di_name
	 */
	public void setDi_name(String Di_name) {
		setAttrVal("Di_name", Di_name);
	}
	/**
	 * 计划阶段
	 * @return String
	 */
	public String getStage_no() {
		return ((String) getAttrVal("Stage_no"));
	}
	/**
	 * 计划阶段
	 * @param Stage_no
	 */
	public void setStage_no(String Stage_no) {
		setAttrVal("Stage_no", Stage_no);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getItem_code() {
		return ((String) getAttrVal("Item_code"));
	}
	/**
	 * 项目编码
	 * @param Item_code
	 */
	public void setItem_code(String Item_code) {
		setAttrVal("Item_code", Item_code);
	}
	/**
	 * 父级编码
	 * @return String
	 */
	public String getParent_code() {
		return ((String) getAttrVal("Parent_code"));
	}
	/**
	 * 父级编码
	 * @param Parent_code
	 */
	public void setParent_code(String Parent_code) {
		setAttrVal("Parent_code", Parent_code);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getSrvmm_code() {
		return ((String) getAttrVal("Srvmm_code"));
	}
	/**
	 * 服务编码
	 * @param Srvmm_code
	 */
	public void setSrvmm_code(String Srvmm_code) {
		setAttrVal("Srvmm_code", Srvmm_code);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrvmm_name() {
		return ((String) getAttrVal("Srvmm_name"));
	}
	/**
	 * 服务名称
	 * @param Srvmm_name
	 */
	public void setSrvmm_name(String Srvmm_name) {
		setAttrVal("Srvmm_name", Srvmm_name);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 给药途径
	 * @return String
	 */
	public String getRoute_code() {
		return ((String) getAttrVal("Route_code"));
	}
	/**
	 * 给药途径
	 * @param Route_code
	 */
	public void setRoute_code(String Route_code) {
		setAttrVal("Route_code", Route_code);
	}
	/**
	 * 剂量
	 * @return FDouble
	 */
	public FDouble getDosage() {
		return ((FDouble) getAttrVal("Dosage"));
	}
	/**
	 * 剂量
	 * @param Dosage
	 */
	public void setDosage(FDouble Dosage) {
		setAttrVal("Dosage", Dosage);
	}
	/**
	 * 剂量单位
	 * @return String
	 */
	public String getDosage_unit() {
		return ((String) getAttrVal("Dosage_unit"));
	}
	/**
	 * 剂量单位
	 * @param Dosage_unit
	 */
	public void setDosage_unit(String Dosage_unit) {
		setAttrVal("Dosage_unit", Dosage_unit);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getFreq_code() {
		return ((String) getAttrVal("Freq_code"));
	}
	/**
	 * 频次
	 * @param Freq_code
	 */
	public void setFreq_code(String Freq_code) {
		setAttrVal("Freq_code", Freq_code);
	}
	/**
	 * 元素类型
	 * @return String
	 */
	public String getEletp_code() {
		return ((String) getAttrVal("Eletp_code"));
	}
	/**
	 * 元素类型
	 * @param Eletp_code
	 */
	public void setEletp_code(String Eletp_code) {
		setAttrVal("Eletp_code", Eletp_code);
	}
	/**
	 * 必选标识
	 * @return FBoolean
	 */
	public FBoolean getFg_necessary() {
		return ((FBoolean) getAttrVal("Fg_necessary"));
	}
	/**
	 * 必选标识
	 * @param Fg_necessary
	 */
	public void setFg_necessary(FBoolean Fg_necessary) {
		setAttrVal("Fg_necessary", Fg_necessary);
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
	 * 在院整领标识
	 * @return FBoolean
	 */
	public FBoolean getFg_wholepack() {
		return ((FBoolean) getAttrVal("Fg_wholepack"));
	}
	/**
	 * 在院整领标识
	 * @param Fg_wholepack
	 */
	public void setFg_wholepack(FBoolean Fg_wholepack) {
		setAttrVal("Fg_wholepack", Fg_wholepack);
	}
	/**
	 * 总量_当前包装
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}
	/**
	 * 总量_当前包装
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	/**
	 * 总量单位编码_当前包装
	 * @return String
	 */
	public String getCode_unit_cur() {
		return ((String) getAttrVal("Code_unit_cur"));
	}
	/**
	 * 总量单位编码_当前包装
	 * @param Code_unit_cur
	 */
	public void setCode_unit_cur(String Code_unit_cur) {
		setAttrVal("Code_unit_cur", Code_unit_cur);
	}
	/**
	 * 所属部门编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 所属部门编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 所属部门名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 所属部门名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 加急标志
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急标志
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 不计费类型sd
	 * @return String
	 */
	public String getSd_nodispense() {
		return ((String) getAttrVal("Sd_nodispense"));
	}
	/**
	 * 不计费类型sd
	 * @param Sd_nodispense
	 */
	public void setSd_nodispense(String Sd_nodispense) {
		setAttrVal("Sd_nodispense", Sd_nodispense);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getCode_dep_mp() {
		return ((String) getAttrVal("Code_dep_mp"));
	}
	/**
	 * 执行科室编码
	 * @param Code_dep_mp
	 */
	public void setCode_dep_mp(String Code_dep_mp) {
		setAttrVal("Code_dep_mp", Code_dep_mp);
	}
	/**
	 * 物资药房编码
	 * @return String
	 */
	public String getCode_dep_wh() {
		return ((String) getAttrVal("Code_dep_wh"));
	}
	/**
	 * 物资药房编码
	 * @param Code_dep_wh
	 */
	public void setCode_dep_wh(String Code_dep_wh) {
		setAttrVal("Code_dep_wh", Code_dep_wh);
	}
	/**
	 * 嘱托内容
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 嘱托内容
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 当前层次下序号
	 * @return Integer
	 */
	public Integer getSerialno() {
		return ((Integer) getAttrVal("Serialno"));
	}
	/**
	 * 当前层次下序号
	 * @param Serialno
	 */
	public void setSerialno(Integer Serialno) {
		setAttrVal("Serialno", Serialno);
	}
}