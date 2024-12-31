package iih.ci.ord.dto.outexecprintdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 外送打印单据dto DTO数据 
 * 
 */
public class OutExecPrintDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 服务名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 主服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 主服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务类型ID
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 服务类型ID
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 服务分类ID
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务分类ID
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 服务分类编码
	 * @return String
	 */
	public String getSd_srvca() {
		return ((String) getAttrVal("Sd_srvca"));
	}
	/**
	 * 服务分类编码
	 * @param Sd_srvca
	 */
	public void setSd_srvca(String Sd_srvca) {
		setAttrVal("Sd_srvca", Sd_srvca);
	}
	/**
	 * 服务分类
	 * @return String
	 */
	public String getName_srvca() {
		return ((String) getAttrVal("Name_srvca"));
	}
	/**
	 * 服务分类
	 * @param Name_srvca
	 */
	public void setName_srvca(String Name_srvca) {
		setAttrVal("Name_srvca", Name_srvca);
	}
	/**
	 * 记账状态ID
	 * @return String
	 */
	public String getId_su_bl() {
		return ((String) getAttrVal("Id_su_bl"));
	}
	/**
	 * 记账状态ID
	 * @param Id_su_bl
	 */
	public void setId_su_bl(String Id_su_bl) {
		setAttrVal("Id_su_bl", Id_su_bl);
	}
	/**
	 * 记账状态编码
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 记账状态编码
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 记账状态
	 * @return String
	 */
	public String getName_su_bl() {
		return ((String) getAttrVal("Name_su_bl"));
	}
	/**
	 * 记账状态
	 * @param Name_su_bl
	 */
	public void setName_su_bl(String Name_su_bl) {
		setAttrVal("Name_su_bl", Name_su_bl);
	}
	/**
	 * 开立医生id
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立医生id
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立医生签名
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开立医生签名
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 医嘱生效日期
	 * @return String
	 */
	public String getDt_effe() {
		return ((String) getAttrVal("Dt_effe"));
	}
	/**
	 * 医嘱生效日期
	 * @param Dt_effe
	 */
	public void setDt_effe(String Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 医嘱状态
	 * @return String
	 */
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}
	/**
	 * 医嘱状态
	 * @param Sd_su_or
	 */
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
}