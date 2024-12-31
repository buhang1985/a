package iih.en.que.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 分诊台工作点DTO DTO数据 
 * 
 */
public class TriageSiteDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 科室ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 队列ID
	 * @return String
	 */
	public String getId_que() {
		return ((String) getAttrVal("Id_que"));
	}
	/**
	 * 队列ID
	 * @param Id_que
	 */
	public void setId_que(String Id_que) {
		setAttrVal("Id_que", Id_que);
	}
	/**
	 * 排班服务ID
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 排班服务ID
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 排班资源类型
	 * @return String
	 */
	public String getSd_screstp() {
		return ((String) getAttrVal("Sd_screstp"));
	}
	/**
	 * 排班资源类型
	 * @param Sd_screstp
	 */
	public void setSd_screstp(String Sd_screstp) {
		setAttrVal("Sd_screstp", Sd_screstp);
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
	 * 队列名称
	 * @return String
	 */
	public String getName_que() {
		return ((String) getAttrVal("Name_que"));
	}
	/**
	 * 队列名称
	 * @param Name_que
	 */
	public void setName_que(String Name_que) {
		setAttrVal("Name_que", Name_que);
	}
	/**
	 * 排班服务名称
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}
	/**
	 * 排班服务名称
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
	/**
	 * 未分诊人数
	 * @return Integer
	 */
	public Integer getNum_notriage() {
		return ((Integer) getAttrVal("Num_notriage"));
	}
	/**
	 * 未分诊人数
	 * @param Num_notriage
	 */
	public void setNum_notriage(Integer Num_notriage) {
		setAttrVal("Num_notriage", Num_notriage);
	}
	/**
	 * 分诊人数
	 * @return Integer
	 */
	public Integer getNum_triage() {
		return ((Integer) getAttrVal("Num_triage"));
	}
	/**
	 * 分诊人数
	 * @param Num_triage
	 */
	public void setNum_triage(Integer Num_triage) {
		setAttrVal("Num_triage", Num_triage);
	}
	/**
	 * 候诊人数
	 * @return Integer
	 */
	public Integer getNum_wait() {
		return ((Integer) getAttrVal("Num_wait"));
	}
	/**
	 * 候诊人数
	 * @param Num_wait
	 */
	public void setNum_wait(Integer Num_wait) {
		setAttrVal("Num_wait", Num_wait);
	}
	/**
	 * 工作点列表
	 * @return FArrayList
	 */
	public FArrayList getList_quesite() {
		return ((FArrayList) getAttrVal("List_quesite"));
	}
	/**
	 * 工作点列表
	 * @param List_quesite
	 */
	public void setList_quesite(FArrayList List_quesite) {
		setAttrVal("List_quesite", List_quesite);
	}
}