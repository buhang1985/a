package iih.mp.dg.dto.mpdg4es.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * IE发药信息属性集 DTO数据 
 * 
 */
public class MpDt4IEDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * IE发药属性集主键
	 * @return String
	 */
	public String getId_mpdt4ie() {
		return ((String) getAttrVal("Id_mpdt4ie"));
	}
	/**
	 * IE发药属性集主键
	 * @param Id_mpdt4ie
	 */
	public void setId_mpdt4ie(String Id_mpdt4ie) {
		setAttrVal("Id_mpdt4ie", Id_mpdt4ie);
	}
	/**
	 * IE发药信息主键集合
	 * @return FArrayList
	 */
	public FArrayList getId_iedgips() {
		return ((FArrayList) getAttrVal("Id_iedgips"));
	}
	/**
	 * IE发药信息主键集合
	 * @param Id_iedgips
	 */
	public void setId_iedgips(FArrayList Id_iedgips) {
		setAttrVal("Id_iedgips", Id_iedgips);
	}
	/**
	 * IE请领明细主键集合
	 * @return FArrayList
	 */
	public FArrayList getId_iedgipdes() {
		return ((FArrayList) getAttrVal("Id_iedgipdes"));
	}
	/**
	 * IE请领明细主键集合
	 * @param Id_iedgipdes
	 */
	public void setId_iedgipdes(FArrayList Id_iedgipdes) {
		setAttrVal("Id_iedgipdes", Id_iedgipdes);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
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
	 * @return Integer
	 */
	public Integer getTimes_en() {
		return ((Integer) getAttrVal("Times_en"));
	}
	/**
	 * 就诊次数
	 * @param Times_en
	 */
	public void setTimes_en(Integer Times_en) {
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
	 * 消息创建时间
	 * @return FDateTime
	 */
	public FDateTime getCurrentdate() {
		return ((FDateTime) getAttrVal("Currentdate"));
	}
	/**
	 * 消息创建时间
	 * @param Currentdate
	 */
	public void setCurrentdate(FDateTime Currentdate) {
		setAttrVal("Currentdate", Currentdate);
	}
	/**
	 * 消息交互类型
	 * @return String
	 */
	public String getMessagetype() {
		return ((String) getAttrVal("Messagetype"));
	}
	/**
	 * 消息交互类型
	 * @param Messagetype
	 */
	public void setMessagetype(String Messagetype) {
		setAttrVal("Messagetype", Messagetype);
	}
	/**
	 * 域ID
	 * @return String
	 */
	public String getRegionid() {
		return ((String) getAttrVal("Regionid"));
	}
	/**
	 * 域ID
	 * @param Regionid
	 */
	public void setRegionid(String Regionid) {
		setAttrVal("Regionid", Regionid);
	}
	/**
	 * IE摆药单主键
	 * @return String
	 */
	public String getId_iedgipde() {
		return ((String) getAttrVal("Id_iedgipde"));
	}
	/**
	 * IE摆药单主键
	 * @param Id_iedgipde
	 */
	public void setId_iedgipde(String Id_iedgipde) {
		setAttrVal("Id_iedgipde", Id_iedgipde);
	}
	/**
	 * IE摆药单主键集合
	 * @return FArrayList
	 */
	public FArrayList getId_iedgipdts() {
		return ((FArrayList) getAttrVal("Id_iedgipdts"));
	}
	/**
	 * IE摆药单主键集合
	 * @param Id_iedgipdts
	 */
	public void setId_iedgipdts(FArrayList Id_iedgipdts) {
		setAttrVal("Id_iedgipdts", Id_iedgipdts);
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
	 * 发药人编码
	 * @return String
	 */
	public String getCode_emp_dp() {
		return ((String) getAttrVal("Code_emp_dp"));
	}
	/**
	 * 发药人编码
	 * @param Code_emp_dp
	 */
	public void setCode_emp_dp(String Code_emp_dp) {
		setAttrVal("Code_emp_dp", Code_emp_dp);
	}
	/**
	 * 发药人名称
	 * @return String
	 */
	public String getName_emp_dp() {
		return ((String) getAttrVal("Name_emp_dp"));
	}
	/**
	 * 发药人名称
	 * @param Name_emp_dp
	 */
	public void setName_emp_dp(String Name_emp_dp) {
		setAttrVal("Name_emp_dp", Name_emp_dp);
	}
	/**
	 * 发药确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_tp() {
		return ((FDateTime) getAttrVal("Dt_tp"));
	}
	/**
	 * 发药确认时间
	 * @param Dt_tp
	 */
	public void setDt_tp(FDateTime Dt_tp) {
		setAttrVal("Dt_tp", Dt_tp);
	}
	/**
	 * 配药医师编码
	 * @return String
	 */
	public String getCode_emp_disp() {
		return ((String) getAttrVal("Code_emp_disp"));
	}
	/**
	 * 配药医师编码
	 * @param Code_emp_disp
	 */
	public void setCode_emp_disp(String Code_emp_disp) {
		setAttrVal("Code_emp_disp", Code_emp_disp);
	}
	/**
	 * 配药医师名称
	 * @return String
	 */
	public String getName_emp_disp() {
		return ((String) getAttrVal("Name_emp_disp"));
	}
	/**
	 * 配药医师名称
	 * @param Name_emp_disp
	 */
	public void setName_emp_disp(String Name_emp_disp) {
		setAttrVal("Name_emp_disp", Name_emp_disp);
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
	 * IE请领明细主键
	 * @return String
	 */
	public String getId_iedgipdt() {
		return ((String) getAttrVal("Id_iedgipdt"));
	}
	/**
	 * IE请领明细主键
	 * @param Id_iedgipdt
	 */
	public void setId_iedgipdt(String Id_iedgipdt) {
		setAttrVal("Id_iedgipdt", Id_iedgipdt);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getOrder_no() {
		return ((String) getAttrVal("Order_no"));
	}
	/**
	 * 医嘱号
	 * @param Order_no
	 */
	public void setOrder_no(String Order_no) {
		setAttrVal("Order_no", Order_no);
	}
	/**
	 * 批次号
	 * @return String
	 */
	public String getPc_no() {
		return ((String) getAttrVal("Pc_no"));
	}
	/**
	 * 批次号
	 * @param Pc_no
	 */
	public void setPc_no(String Pc_no) {
		setAttrVal("Pc_no", Pc_no);
	}
	/**
	 * 领药量
	 * @return FDouble
	 */
	public FDouble getLy_count() {
		return ((FDouble) getAttrVal("Ly_count"));
	}
	/**
	 * 领药量
	 * @param Ly_count
	 */
	public void setLy_count(FDouble Ly_count) {
		setAttrVal("Ly_count", Ly_count);
	}
	/**
	 * 领药单位
	 * @return String
	 */
	public String getLy_unit() {
		return ((String) getAttrVal("Ly_unit"));
	}
	/**
	 * 领药单位
	 * @param Ly_unit
	 */
	public void setLy_unit(String Ly_unit) {
		setAttrVal("Ly_unit", Ly_unit);
	}
	/**
	 * 申请科室遍码
	 * @return String
	 */
	public String getCode_dep_phy() {
		return ((String) getAttrVal("Code_dep_phy"));
	}
	/**
	 * 申请科室遍码
	 * @param Code_dep_phy
	 */
	public void setCode_dep_phy(String Code_dep_phy) {
		setAttrVal("Code_dep_phy", Code_dep_phy);
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
}