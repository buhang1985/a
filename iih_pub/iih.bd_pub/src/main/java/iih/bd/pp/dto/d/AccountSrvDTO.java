package iih.bd.pp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 可维护核算分类和服务项目对照dto DTO数据 
 * 
 */
public class AccountSrvDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 核算分类和服务关系主键
	 * @return String
	 */
	public String getId_accsrv() {
		return ((String) getAttrVal("Id_accsrv"));
	}
	/**
	 * 核算分类和服务关系主键
	 * @param Id_accsrv
	 */
	public void setId_accsrv(String Id_accsrv) {
		setAttrVal("Id_accsrv", Id_accsrv);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 服务类型id
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务类型id
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 服务类型名称
	 * @return String
	 */
	public String getName_srvca() {
		return ((String) getAttrVal("Name_srvca"));
	}
	/**
	 * 服务类型名称
	 * @param Name_srvca
	 */
	public void setName_srvca(String Name_srvca) {
		setAttrVal("Name_srvca", Name_srvca);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getCode_srvca() {
		return ((String) getAttrVal("Code_srvca"));
	}
	/**
	 * 服务类型编码
	 * @param Code_srvca
	 */
	public void setCode_srvca(String Code_srvca) {
		setAttrVal("Code_srvca", Code_srvca);
	}
	/**
	 * 核算分类id
	 * @return String
	 */
	public String getId_acc_ca() {
		return ((String) getAttrVal("Id_acc_ca"));
	}
	/**
	 * 核算分类id
	 * @param Id_acc_ca
	 */
	public void setId_acc_ca(String Id_acc_ca) {
		setAttrVal("Id_acc_ca", Id_acc_ca);
	}
	/**
	 * 核算分类名称
	 * @return String
	 */
	public String getName_ca() {
		return ((String) getAttrVal("Name_ca"));
	}
	/**
	 * 核算分类名称
	 * @param Name_ca
	 */
	public void setName_ca(String Name_ca) {
		setAttrVal("Name_ca", Name_ca);
	}
	/**
	 * 核算分类编码
	 * @return String
	 */
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}
	/**
	 * 核算分类编码
	 * @param Code_ca
	 */
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	/**
	 * 核算体系
	 * @return String
	 */
	public String getId_acc() {
		return ((String) getAttrVal("Id_acc"));
	}
	/**
	 * 核算体系
	 * @param Id_acc
	 */
	public void setId_acc(String Id_acc) {
		setAttrVal("Id_acc", Id_acc);
	}
}