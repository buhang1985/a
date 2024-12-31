package iih.ci.ord.external.blood.wqxk.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 万全血库参数 DTO数据 
 * 
 */
public class WQUbOrEnParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 住院次数 
	 * @return String
	 */
	public String getTimesip() {
		return ((String) getAttrVal("Timesip"));
	}
	/**
	 * 住院次数 
	 * @param Timesip
	 */
	public void setTimesip(String Timesip) {
		setAttrVal("Timesip", Timesip);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 *  病人姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 *  病人姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 *  申请单号(根据第三方的规则生成新的医嘱号)
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}
	/**
	 *  申请单号(根据第三方的规则生成新的医嘱号)
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 *  开具的血液成分内容，多成分拼接而成（血液成分、数量、单位）
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 *  开具的血液成分内容，多成分拼接而成（血液成分、数量、单位）
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 交叉配血号
	 * @return String
	 */
	public String getMatch_id() {
		return ((String) getAttrVal("Match_id"));
	}
	/**
	 * 交叉配血号
	 * @param Match_id
	 */
	public void setMatch_id(String Match_id) {
		setAttrVal("Match_id", Match_id);
	}
	/**
	 * 申请医生代码
	 * @return String
	 */
	public String getCode_emp_or() {
		return ((String) getAttrVal("Code_emp_or"));
	}
	/**
	 * 申请医生代码
	 * @param Code_emp_or
	 */
	public void setCode_emp_or(String Code_emp_or) {
		setAttrVal("Code_emp_or", Code_emp_or);
	}
	/**
	 * 用血时间
	 * @return String
	 */
	public String getDt_effe() {
		return ((String) getAttrVal("Dt_effe"));
	}
	/**
	 * 用血时间
	 * @param Dt_effe
	 */
	public void setDt_effe(String Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 执行科室
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 *  记账人编码
	 * @return String
	 */
	public String getOperacg() {
		return ((String) getAttrVal("Operacg"));
	}
	/**
	 *  记账人编码
	 * @param Operacg
	 */
	public void setOperacg(String Operacg) {
		setAttrVal("Operacg", Operacg);
	}
	/**
	 * 执行时间
	 * @return String
	 */
	public String getOperatime() {
		return ((String) getAttrVal("Operatime"));
	}
	/**
	 * 执行时间
	 * @param Operatime
	 */
	public void setOperatime(String Operatime) {
		setAttrVal("Operatime", Operatime);
	}
	/**
	 * 开立人编码
	 * @return String
	 */
	public String getOperaor() {
		return ((String) getAttrVal("Operaor"));
	}
	/**
	 * 开立人编码
	 * @param Operaor
	 */
	public void setOperaor(String Operaor) {
		setAttrVal("Operaor", Operaor);
	}
	/**
	 * 执行人编码
	 * @return String
	 */
	public String getOperamp() {
		return ((String) getAttrVal("Operamp"));
	}
	/**
	 * 执行人编码
	 * @param Operamp
	 */
	public void setOperamp(String Operamp) {
		setAttrVal("Operamp", Operamp);
	}
	/**
	 *  执行科室编码
	 * @return String
	 */
	public String getMpdepcode() {
		return ((String) getAttrVal("Mpdepcode"));
	}
	/**
	 *  执行科室编码
	 * @param Mpdepcode
	 */
	public void setMpdepcode(String Mpdepcode) {
		setAttrVal("Mpdepcode", Mpdepcode);
	}
	/**
	 * 费用实际记账科室编码
	 * @return String
	 */
	public String getCgdepcode() {
		return ((String) getAttrVal("Cgdepcode"));
	}
	/**
	 * 费用实际记账科室编码
	 * @param Cgdepcode
	 */
	public void setCgdepcode(String Cgdepcode) {
		setAttrVal("Cgdepcode", Cgdepcode);
	}
	/**
	 * 婴儿标志(默认0，Y为婴儿)
	 * @return String
	 */
	public String getInfantflag() {
		return ((String) getAttrVal("Infantflag"));
	}
	/**
	 * 婴儿标志(默认0，Y为婴儿)
	 * @param Infantflag
	 */
	public void setInfantflag(String Infantflag) {
		setAttrVal("Infantflag", Infantflag);
	}
	/**
	 * 1 记费 ， -1 退费
	 * @return String
	 */
	public String getDirectflag() {
		return ((String) getAttrVal("Directflag"));
	}
	/**
	 * 1 记费 ， -1 退费
	 * @param Directflag
	 */
	public void setDirectflag(String Directflag) {
		setAttrVal("Directflag", Directflag);
	}
	/**
	 * 费用标志(默认0，Y为第三方计费 0：使用IIH费用方式记账 Y：使用第三方系统费用值)
	 * @return String
	 */
	public String getCostflag() {
		return ((String) getAttrVal("Costflag"));
	}
	/**
	 * 费用标志(默认0，Y为第三方计费 0：使用IIH费用方式记账 Y：使用第三方系统费用值)
	 * @param Costflag
	 */
	public void setCostflag(String Costflag) {
		setAttrVal("Costflag", Costflag);
	}
	/**
	 * 使用第三方系统补费来源描述
	 * @return String
	 */
	public String getSourcedesc() {
		return ((String) getAttrVal("Sourcedesc"));
	}
	/**
	 * 使用第三方系统补费来源描述
	 * @param Sourcedesc
	 */
	public void setSourcedesc(String Sourcedesc) {
		setAttrVal("Sourcedesc", Sourcedesc);
	}
	/**
	 * 费用明细集合
	 * @return FArrayList
	 */
	public FArrayList getChargeitem() {
		return ((FArrayList) getAttrVal("Chargeitem"));
	}
	/**
	 * 费用明细集合
	 * @param Chargeitem
	 */
	public void setChargeitem(FArrayList Chargeitem) {
		setAttrVal("Chargeitem", Chargeitem);
	}
}