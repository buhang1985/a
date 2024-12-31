package iih.ei.std.d.v1.en.opwaitque.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者候诊队列 DTO数据 
 * 
 */
public class OpWaitQueDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 顺序号
	 * @return String
	 */
	public String getRow_number() {
		return ((String) getAttrVal("Row_number"));
	}	
	/**
	 * 顺序号
	 * @param Row_number
	 */
	public void setRow_number(String Row_number) {
		setAttrVal("Row_number", Row_number);
	}
	/**
	 * 挂号顺序号
	 * @return String
	 */
	public String getCode_ticket() {
		return ((String) getAttrVal("Code_ticket"));
	}	
	/**
	 * 挂号顺序号
	 * @param Code_ticket
	 */
	public void setCode_ticket(String Code_ticket) {
		setAttrVal("Code_ticket", Code_ticket);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getTimes_op() {
		return ((Integer) getAttrVal("Times_op"));
	}	
	/**
	 * 就诊次数
	 * @param Times_op
	 */
	public void setTimes_op(Integer Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 诊室
	 * @return String
	 */
	public String getRoom_ent() {
		return ((String) getAttrVal("Room_ent"));
	}	
	/**
	 * 诊室
	 * @param Room_ent
	 */
	public void setRoom_ent(String Room_ent) {
		setAttrVal("Room_ent", Room_ent);
	}
	/**
	 * 就诊队列id
	 * @return String
	 */
	public String getId_ent_que() {
		return ((String) getAttrVal("Id_ent_que"));
	}	
	/**
	 * 就诊队列id
	 * @param Id_ent_que
	 */
	public void setId_ent_que(String Id_ent_que) {
		setAttrVal("Id_ent_que", Id_ent_que);
	}
	/**
	 * 叫号顺序号
	 * @return Integer
	 */
	public Integer getSortno_called() {
		return ((Integer) getAttrVal("Sortno_called"));
	}	
	/**
	 * 叫号顺序号
	 * @param Sortno_called
	 */
	public void setSortno_called(Integer Sortno_called) {
		setAttrVal("Sortno_called", Sortno_called);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getCode_entstatus() {
		return ((String) getAttrVal("Code_entstatus"));
	}	
	/**
	 * 就诊状态
	 * @param Code_entstatus
	 */
	public void setCode_entstatus(String Code_entstatus) {
		setAttrVal("Code_entstatus", Code_entstatus);
	}
	/**
	 * 就诊队列状态
	 * @return String
	 */
	public String getCode_questatus() {
		return ((String) getAttrVal("Code_questatus"));
	}	
	/**
	 * 就诊队列状态
	 * @param Code_questatus
	 */
	public void setCode_questatus(String Code_questatus) {
		setAttrVal("Code_questatus", Code_questatus);
	}
	/**
	 * 就诊站点
	 * @return String
	 */
	public String getId_que_site() {
		return ((String) getAttrVal("Id_que_site"));
	}	
	/**
	 * 就诊站点
	 * @param Id_que_site
	 */
	public void setId_que_site(String Id_que_site) {
		setAttrVal("Id_que_site", Id_que_site);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	/**
	 * 优先级
	 * @return Integer
	 */
	public Integer getLevel_pri() {
		return ((Integer) getAttrVal("Level_pri"));
	}	
	/**
	 * 优先级
	 * @param Level_pri
	 */
	public void setLevel_pri(Integer Level_pri) {
		setAttrVal("Level_pri", Level_pri);
	}
	/**
	 * 回诊标志
	 * @return String
	 */
	public String getFg_rtn() {
		return ((String) getAttrVal("Fg_rtn"));
	}	
	/**
	 * 回诊标志
	 * @param Fg_rtn
	 */
	public void setFg_rtn(String Fg_rtn) {
		setAttrVal("Fg_rtn", Fg_rtn);
	}
	/**
	 * 候诊标志
	 * @return String
	 */
	public String getFg_wait() {
		return ((String) getAttrVal("Fg_wait"));
	}	
	/**
	 * 候诊标志
	 * @param Fg_wait
	 */
	public void setFg_wait(String Fg_wait) {
		setAttrVal("Fg_wait", Fg_wait);
	}
	/**
	 * 队列id
	 * @return String
	 */
	public String getId_que() {
		return ((String) getAttrVal("Id_que"));
	}	
	/**
	 * 队列id
	 * @param Id_que
	 */
	public void setId_que(String Id_que) {
		setAttrVal("Id_que", Id_que);
	}
	/**
	 * 当前叫号时间
	 * @return FDateTime
	 */
	public FDateTime getCallnotime() {
		return ((FDateTime) getAttrVal("Callnotime"));
	}	
	/**
	 * 当前叫号时间
	 * @param Callnotime
	 */
	public void setCallnotime(FDateTime Callnotime) {
		setAttrVal("Callnotime", Callnotime);
	}
	/**
	 * 当前就诊科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	/**
	 * 当前就诊科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 当前就诊科室名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	/**
	 * 当前就诊科室名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 当前就诊医生
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}	
	/**
	 * 当前就诊医生
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 当前就诊医生名称
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}	
	/**
	 * 当前就诊医生名称
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
}