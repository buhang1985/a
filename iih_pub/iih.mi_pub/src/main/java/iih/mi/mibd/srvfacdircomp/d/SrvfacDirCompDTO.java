package iih.mi.mibd.srvfacdircomp.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 服务设施目录对照DTO DTO数据 
 * 
 */
public class SrvfacDirCompDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务设施对照主键
	 * @return String
	 */
	public String getId_srvfaccomp() {
		return ((String) getAttrVal("Id_srvfaccomp"));
	}
	/**
	 * 服务设施对照主键
	 * @param Id_srvfaccomp
	 */
	public void setId_srvfaccomp(String Id_srvfaccomp) {
		setAttrVal("Id_srvfaccomp", Id_srvfaccomp);
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
	 * HIS服务设施
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * HIS服务设施
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * HIS服务设施名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}
	/**
	 * HIS服务设施名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * HIS服务设施编码
	 * @return String
	 */
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}
	/**
	 * HIS服务设施编码
	 * @param Srv_code
	 */
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	/**
	 * HIS服务设施单位
	 * @return String
	 */
	public String getSrv_unit() {
		return ((String) getAttrVal("Srv_unit"));
	}
	/**
	 * HIS服务设施单位
	 * @param Srv_unit
	 */
	public void setSrv_unit(String Srv_unit) {
		setAttrVal("Srv_unit", Srv_unit);
	}
	/**
	 * HIS服务设施单价
	 * @return FDouble
	 */
	public FDouble getSrv_price() {
		return ((FDouble) getAttrVal("Srv_price"));
	}
	/**
	 * HIS服务设施单价
	 * @param Srv_price
	 */
	public void setSrv_price(FDouble Srv_price) {
		setAttrVal("Srv_price", Srv_price);
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
	public String getCreateby() {
		return ((String) getAttrVal("Createby"));
	}
	/**
	 * 创建人
	 * @param Createby
	 */
	public void setCreateby(String Createby) {
		setAttrVal("Createby", Createby);
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