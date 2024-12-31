package iih.mi.mibd.treatdircomp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 诊疗项目对照DTO DTO数据 
 * 
 */
public class TreatDirCompDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊疗项目对照主键
	 * @return String
	 */
	public String getId_treatcomp() {
		return ((String) getAttrVal("Id_treatcomp"));
	}
	/**
	 * 诊疗项目对照主键
	 * @param Id_treatcomp
	 */
	public void setId_treatcomp(String Id_treatcomp) {
		setAttrVal("Id_treatcomp", Id_treatcomp);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 医保系统
	 * @return String
	 */
	public String getId_mis() {
		return ((String) getAttrVal("Id_mis"));
	}
	/**
	 * 医保系统
	 * @param Id_mis
	 */
	public void setId_mis(String Id_mis) {
		setAttrVal("Id_mis", Id_mis);
	}
	/**
	 * 状态
	 * @return Integer
	 */
	public Integer getEu_status() {
		return ((Integer) getAttrVal("Eu_status"));
	}
	/**
	 * 状态
	 * @param Eu_status
	 */
	public void setEu_status(Integer Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * HIS诊疗
	 * @return String
	 */
	public String getId_treat() {
		return ((String) getAttrVal("Id_treat"));
	}
	/**
	 * HIS诊疗
	 * @param Id_treat
	 */
	public void setId_treat(String Id_treat) {
		setAttrVal("Id_treat", Id_treat);
	}
	/**
	 * HIS诊疗名称
	 * @return String
	 */
	public String getTreat_name() {
		return ((String) getAttrVal("Treat_name"));
	}
	/**
	 * HIS诊疗名称
	 * @param Treat_name
	 */
	public void setTreat_name(String Treat_name) {
		setAttrVal("Treat_name", Treat_name);
	}
	/**
	 * HIS诊疗编码
	 * @return String
	 */
	public String getTreat_code() {
		return ((String) getAttrVal("Treat_code"));
	}
	/**
	 * HIS诊疗编码
	 * @param Treat_code
	 */
	public void setTreat_code(String Treat_code) {
		setAttrVal("Treat_code", Treat_code);
	}
	/**
	 * HIS诊疗单位
	 * @return String
	 */
	public String getTreat_unit() {
		return ((String) getAttrVal("Treat_unit"));
	}
	/**
	 * HIS诊疗单位
	 * @param Treat_unit
	 */
	public void setTreat_unit(String Treat_unit) {
		setAttrVal("Treat_unit", Treat_unit);
	}
	/**
	 * HIS诊疗单价
	 * @return FDouble
	 */
	public FDouble getTreat_price() {
		return ((FDouble) getAttrVal("Treat_price"));
	}
	/**
	 * HIS诊疗单价
	 * @param Treat_price
	 */
	public void setTreat_price(FDouble Treat_price) {
		setAttrVal("Treat_price", Treat_price);
	}
	/**
	 * 收费等级
	 * @return String
	 */
	public String getEu_feelevel() {
		return ((String) getAttrVal("Eu_feelevel"));
	}
	/**
	 * 收费等级
	 * @param Eu_feelevel
	 */
	public void setEu_feelevel(String Eu_feelevel) {
		setAttrVal("Eu_feelevel", Eu_feelevel);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 限价
	 * @return FDouble
	 */
	public FDouble getPri_max() {
		return ((FDouble) getAttrVal("Pri_max"));
	}
	/**
	 * 限价
	 * @param Pri_max
	 */
	public void setPri_max(FDouble Pri_max) {
		setAttrVal("Pri_max", Pri_max);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 审批时间
	 * @return FDateTime
	 */
	public FDateTime getDt_approved() {
		return ((FDateTime) getAttrVal("Dt_approved"));
	}
	/**
	 * 审批时间
	 * @param Dt_approved
	 */
	public void setDt_approved(FDateTime Dt_approved) {
		setAttrVal("Dt_approved", Dt_approved);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 版本
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 版本
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
}