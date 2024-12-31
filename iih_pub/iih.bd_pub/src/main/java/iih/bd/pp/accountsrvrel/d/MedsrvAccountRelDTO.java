package iih.bd.pp.accountsrvrel.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医疗服务与核算科目关系DTO DTO数据 
 * 
 */
public class MedsrvAccountRelDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗服务 
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务 
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 共有核算科目
	 * @return String
	 */
	public String getId_account() {
		return ((String) getAttrVal("Id_account"));
	}
	/**
	 * 共有核算科目
	 * @param Id_account
	 */
	public void setId_account(String Id_account) {
		setAttrVal("Id_account", Id_account);
	}
	/**
	 * 门诊核算科目
	 * @return String
	 */
	public String getId_account_op() {
		return ((String) getAttrVal("Id_account_op"));
	}
	/**
	 * 门诊核算科目
	 * @param Id_account_op
	 */
	public void setId_account_op(String Id_account_op) {
		setAttrVal("Id_account_op", Id_account_op);
	}
	/**
	 * 住院核算科目
	 * @return String
	 */
	public String getId_account_ip() {
		return ((String) getAttrVal("Id_account_ip"));
	}
	/**
	 * 住院核算科目
	 * @param Id_account_ip
	 */
	public void setId_account_ip(String Id_account_ip) {
		setAttrVal("Id_account_ip", Id_account_ip);
	}
}