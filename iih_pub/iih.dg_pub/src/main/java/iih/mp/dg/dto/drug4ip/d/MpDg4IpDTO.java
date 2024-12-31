package iih.mp.dg.dto.drug4ip.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 集成平台住院发药DTO DTO数据 
 * 
 */
public class MpDg4IpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 消息类型
	 * @return String
	 */
	public String getMsgtype() {
		return ((String) getAttrVal("Msgtype"));
	}
	/**
	 * 消息类型
	 * @param Msgtype
	 */
	public void setMsgtype(String Msgtype) {
		setAttrVal("Msgtype", Msgtype);
	}
	/**
	 * 域ID
	 * @return String
	 */
	public String getId_domain() {
		return ((String) getAttrVal("Id_domain"));
	}
	/**
	 * 域ID
	 * @param Id_domain
	 */
	public void setId_domain(String Id_domain) {
		setAttrVal("Id_domain", Id_domain);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊序号
	 * @return String
	 */
	public String getTicketno() {
		return ((String) getAttrVal("Ticketno"));
	}
	/**
	 * 就诊序号
	 * @param Ticketno
	 */
	public void setTicketno(String Ticketno) {
		setAttrVal("Ticketno", Ticketno);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getTimes_en() {
		return ((String) getAttrVal("Times_en"));
	}
	/**
	 * 就诊次数
	 * @param Times_en
	 */
	public void setTimes_en(String Times_en) {
		setAttrVal("Times_en", Times_en);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 处方号
	 * @return String
	 */
	public String getCode_press() {
		return ((String) getAttrVal("Code_press"));
	}
	/**
	 * 处方号
	 * @param Code_press
	 */
	public void setCode_press(String Code_press) {
		setAttrVal("Code_press", Code_press);
	}
	/**
	 * 摆药单单号
	 * @return String
	 */
	public String getCode_dgipap() {
		return ((String) getAttrVal("Code_dgipap"));
	}
	/**
	 * 摆药单单号
	 * @param Code_dgipap
	 */
	public void setCode_dgipap(String Code_dgipap) {
		setAttrVal("Code_dgipap", Code_dgipap);
	}
	/**
	 * 发药确认人编码
	 * @return String
	 */
	public String getCode_emp_dp() {
		return ((String) getAttrVal("Code_emp_dp"));
	}
	/**
	 * 发药确认人编码
	 * @param Code_emp_dp
	 */
	public void setCode_emp_dp(String Code_emp_dp) {
		setAttrVal("Code_emp_dp", Code_emp_dp);
	}
	/**
	 * 发药确认人名称
	 * @return String
	 */
	public String getName_emp_dp() {
		return ((String) getAttrVal("Name_emp_dp"));
	}
	/**
	 * 发药确认人名称
	 * @param Name_emp_dp
	 */
	public void setName_emp_dp(String Name_emp_dp) {
		setAttrVal("Name_emp_dp", Name_emp_dp);
	}
	/**
	 * 发药确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_dp() {
		return ((FDateTime) getAttrVal("Dt_dp"));
	}
	/**
	 * 发药确认时间
	 * @param Dt_dp
	 */
	public void setDt_dp(FDateTime Dt_dp) {
		setAttrVal("Dt_dp", Dt_dp);
	}
	/**
	 * 请领人编码
	 * @return String
	 */
	public String getCode_dispense() {
		return ((String) getAttrVal("Code_dispense"));
	}
	/**
	 * 请领人编码
	 * @param Code_dispense
	 */
	public void setCode_dispense(String Code_dispense) {
		setAttrVal("Code_dispense", Code_dispense);
	}
	/**
	 * 请领人名称
	 * @return String
	 */
	public String getName_dispense() {
		return ((String) getAttrVal("Name_dispense"));
	}
	/**
	 * 请领人名称
	 * @param Name_dispense
	 */
	public void setName_dispense(String Name_dispense) {
		setAttrVal("Name_dispense", Name_dispense);
	}
	/**
	 * 请领科室编码
	 * @return String
	 */
	public String getCode_dep_ap() {
		return ((String) getAttrVal("Code_dep_ap"));
	}
	/**
	 * 请领科室编码
	 * @param Code_dep_ap
	 */
	public void setCode_dep_ap(String Code_dep_ap) {
		setAttrVal("Code_dep_ap", Code_dep_ap);
	}
	/**
	 * 请领科室名称
	 * @return String
	 */
	public String getName_dep_ap() {
		return ((String) getAttrVal("Name_dep_ap"));
	}
	/**
	 * 请领科室名称
	 * @param Name_dep_ap
	 */
	public void setName_dep_ap(String Name_dep_ap) {
		setAttrVal("Name_dep_ap", Name_dep_ap);
	}
	/**
	 * 发药库房编码
	 * @return String
	 */
	public String getCode_dep_wh() {
		return ((String) getAttrVal("Code_dep_wh"));
	}
	/**
	 * 发药库房编码
	 * @param Code_dep_wh
	 */
	public void setCode_dep_wh(String Code_dep_wh) {
		setAttrVal("Code_dep_wh", Code_dep_wh);
	}
	/**
	 * 发药库房名称
	 * @return String
	 */
	public String getName_dep_wh() {
		return ((String) getAttrVal("Name_dep_wh"));
	}
	/**
	 * 发药库房名称
	 * @param Name_dep_wh
	 */
	public void setName_dep_wh(String Name_dep_wh) {
		setAttrVal("Name_dep_wh", Name_dep_wh);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 批次号
	 * @return String
	 */
	public String getCode_batch() {
		return ((String) getAttrVal("Code_batch"));
	}
	/**
	 * 批次号
	 * @param Code_batch
	 */
	public void setCode_batch(String Code_batch) {
		setAttrVal("Code_batch", Code_batch);
	}
	/**
	 * 领药量
	 * @return FDouble
	 */
	public FDouble getQuan_ap() {
		return ((FDouble) getAttrVal("Quan_ap"));
	}
	/**
	 * 领药量
	 * @param Quan_ap
	 */
	public void setQuan_ap(FDouble Quan_ap) {
		setAttrVal("Quan_ap", Quan_ap);
	}
	/**
	 * 药量单位
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 药量单位
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 药品明细
	 * @return FArrayList
	 */
	public FArrayList getId_iedgipdts() {
		return ((FArrayList) getAttrVal("Id_iedgipdts"));
	}
	/**
	 * 药品明细
	 * @param Id_iedgipdts
	 */
	public void setId_iedgipdts(FArrayList Id_iedgipdts) {
		setAttrVal("Id_iedgipdts", Id_iedgipdts);
	}
}