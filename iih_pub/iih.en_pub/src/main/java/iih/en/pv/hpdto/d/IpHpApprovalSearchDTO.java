package iih.en.pv.hpdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保审批信息查询条件 DTO数据 
 * 
 */
public class IpHpApprovalSearchDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 身份证号
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}
	/**
	 * 身份证号
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
	}
	/**
	 * 审批类别id
	 * @return String
	 */
	public String getId_approvaltp() {
		return ((String) getAttrVal("Id_approvaltp"));
	}
	/**
	 * 审批类别id
	 * @param Id_approvaltp
	 */
	public void setId_approvaltp(String Id_approvaltp) {
		setAttrVal("Id_approvaltp", Id_approvaltp);
	}
	/**
	 * 审批类别编码
	 * @return String
	 */
	public String getCode_approvaltp() {
		return ((String) getAttrVal("Code_approvaltp"));
	}
	/**
	 * 审批类别编码
	 * @param Code_approvaltp
	 */
	public void setCode_approvaltp(String Code_approvaltp) {
		setAttrVal("Code_approvaltp", Code_approvaltp);
	}
	/**
	 * 审批类别
	 * @return String
	 */
	public String getName_approvaltp() {
		return ((String) getAttrVal("Name_approvaltp"));
	}
	/**
	 * 审批类别
	 * @param Name_approvaltp
	 */
	public void setName_approvaltp(String Name_approvaltp) {
		setAttrVal("Name_approvaltp", Name_approvaltp);
	}
}