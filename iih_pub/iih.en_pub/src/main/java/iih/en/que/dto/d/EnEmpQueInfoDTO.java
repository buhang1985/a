package iih.en.que.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医生出诊队列信息DTO DTO数据 
 * 
 */
public class EnEmpQueInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 队列编码
	 * @return String
	 */
	public String getCode_que() {
		return ((String) getAttrVal("Code_que"));
	}
	/**
	 * 队列编码
	 * @param Code_que
	 */
	public void setCode_que(String Code_que) {
		setAttrVal("Code_que", Code_que);
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
	 * 分诊台id
	 * @return String
	 */
	public String getId_queben() {
		return ((String) getAttrVal("Id_queben"));
	}
	/**
	 * 分诊台id
	 * @param Id_queben
	 */
	public void setId_queben(String Id_queben) {
		setAttrVal("Id_queben", Id_queben);
	}
	/**
	 * 分诊台编码
	 * @return String
	 */
	public String getCode_queben() {
		return ((String) getAttrVal("Code_queben"));
	}
	/**
	 * 分诊台编码
	 * @param Code_queben
	 */
	public void setCode_queben(String Code_queben) {
		setAttrVal("Code_queben", Code_queben);
	}
	/**
	 * 分诊台名称
	 * @return String
	 */
	public String getName_queben() {
		return ((String) getAttrVal("Name_queben"));
	}
	/**
	 * 分诊台名称
	 * @param Name_queben
	 */
	public void setName_queben(String Name_queben) {
		setAttrVal("Name_queben", Name_queben);
	}
	/**
	 * 午别id
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 午别id
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 午别名称
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 午别名称
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 排班日期
	 * @return FDate
	 */
	public FDate getD_sch() {
		return ((FDate) getAttrVal("D_sch"));
	}
	/**
	 * 排班日期
	 * @param D_sch
	 */
	public void setD_sch(FDate D_sch) {
		setAttrVal("D_sch", D_sch);
	}
	/**
	 * 排班计划id
	 * @return String
	 */
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}
	/**
	 * 排班计划id
	 * @param Id_scpl
	 */
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
	}
	/**
	 * 排班计划名称
	 * @return String
	 */
	public String getName_scpl() {
		return ((String) getAttrVal("Name_scpl"));
	}
	/**
	 * 排班计划名称
	 * @param Name_scpl
	 */
	public void setName_scpl(String Name_scpl) {
		setAttrVal("Name_scpl", Name_scpl);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 排班资源id
	 * @return String
	 */
	public String getId_scres() {
		return ((String) getAttrVal("Id_scres"));
	}
	/**
	 * 排班资源id
	 * @param Id_scres
	 */
	public void setId_scres(String Id_scres) {
		setAttrVal("Id_scres", Id_scres);
	}
	/**
	 * 排班资源
	 * @return String
	 */
	public String getName_scres() {
		return ((String) getAttrVal("Name_scres"));
	}
	/**
	 * 排班资源
	 * @param Name_scres
	 */
	public void setName_scres(String Name_scres) {
		setAttrVal("Name_scres", Name_scres);
	}
	/**
	 * 排班服务id
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 排班服务id
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 排班服务
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}
	/**
	 * 排班服务
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
}