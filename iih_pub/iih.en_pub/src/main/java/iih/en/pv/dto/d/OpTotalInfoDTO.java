package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊统计信息DTO DTO数据 
 * 
 */
public class OpTotalInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 科室id
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 科室id
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 科室name
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 科室name
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 日期
	 * @return String
	 */
	public String getDt_statist() {
		return ((String) getAttrVal("Dt_statist"));
	}
	/**
	 * 日期
	 * @param Dt_statist
	 */
	public void setDt_statist(String Dt_statist) {
		setAttrVal("Dt_statist", Dt_statist);
	}
	/**
	 * 挂号类型
	 * @return String
	 */
	public String getName_svrtp() {
		return ((String) getAttrVal("Name_svrtp"));
	}
	/**
	 * 挂号类型
	 * @param Name_svrtp
	 */
	public void setName_svrtp(String Name_svrtp) {
		setAttrVal("Name_svrtp", Name_svrtp);
	}
	/**
	 * 工作量
	 * @return Integer
	 */
	public Integer getNum_acpt() {
		return ((Integer) getAttrVal("Num_acpt"));
	}
	/**
	 * 工作量
	 * @param Num_acpt
	 */
	public void setNum_acpt(Integer Num_acpt) {
		setAttrVal("Num_acpt", Num_acpt);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getSd_dep_phy() {
		return ((String) getAttrVal("Sd_dep_phy"));
	}
	/**
	 * 科室编码
	 * @param Sd_dep_phy
	 */
	public void setSd_dep_phy(String Sd_dep_phy) {
		setAttrVal("Sd_dep_phy", Sd_dep_phy);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务类型
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
}