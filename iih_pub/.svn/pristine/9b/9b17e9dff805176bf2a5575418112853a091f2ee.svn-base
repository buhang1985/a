package iih.mi.biz.dto.verify.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 智能审核入参 DTO数据 
 * 
 */
public class VerifyInputDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医生工作站IP地址
	 * @return String
	 */
	public String getAgentip() {
		return ((String) getAttrVal("Agentip"));
	}
	/**
	 * 医生工作站IP地址
	 * @param Agentip
	 */
	public void setAgentip(String Agentip) {
		setAttrVal("Agentip", Agentip);
	}
	/**
	 * 医生工作站网卡MAC地址
	 * @return String
	 */
	public String getAgentmac() {
		return ((String) getAttrVal("Agentmac"));
	}
	/**
	 * 医生工作站网卡MAC地址
	 * @param Agentmac
	 */
	public void setAgentmac(String Agentmac) {
		setAttrVal("Agentmac", Agentmac);
	}
	/**
	 * 社保卡号（“身份证号-”或者“-社保卡号”区分唯一参保人，”-”必须保留，）
	 * @return String
	 */
	public String getHpcard() {
		return ((String) getAttrVal("Hpcard"));
	}
	/**
	 * 社保卡号（“身份证号-”或者“-社保卡号”区分唯一参保人，”-”必须保留，）
	 * @param Hpcard
	 */
	public void setHpcard(String Hpcard) {
		setAttrVal("Hpcard", Hpcard);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getIdcard() {
		return ((String) getAttrVal("Idcard"));
	}
	/**
	 * 身份证号
	 * @param Idcard
	 */
	public void setIdcard(String Idcard) {
		setAttrVal("Idcard", Idcard);
	}
	/**
	 * 就诊唯一编号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊唯一编号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 交易时间
	 * @return FDateTime
	 */
	public FDateTime getDtime() {
		return ((FDateTime) getAttrVal("Dtime"));
	}
	/**
	 * 交易时间
	 * @param Dtime
	 */
	public void setDtime(FDateTime Dtime) {
		setAttrVal("Dtime", Dtime);
	}
	/**
	 * 医师编号_当前提交审核请求的医师
	 * @return String
	 */
	public String getCode_doc() {
		return ((String) getAttrVal("Code_doc"));
	}
	/**
	 * 医师编号_当前提交审核请求的医师
	 * @param Code_doc
	 */
	public void setCode_doc(String Code_doc) {
		setAttrVal("Code_doc", Code_doc);
	}
	/**
	 * 总条数_当前待结算费用明细总条数 （住院审核时必传，门诊不用传）
	 * @return Integer
	 */
	public Integer getTotalnum() {
		return ((Integer) getAttrVal("Totalnum"));
	}
	/**
	 * 总条数_当前待结算费用明细总条数 （住院审核时必传，门诊不用传）
	 * @param Totalnum
	 */
	public void setTotalnum(Integer Totalnum) {
		setAttrVal("Totalnum", Totalnum);
	}
	/**
	 * 总金额_当前待结算费用明细总金额（住院审核时必传，门诊不用传）
	 * @return String
	 */
	public FDouble getTotalamount() {
		return ((FDouble) getAttrVal("Totalamount"));
	}
	/**
	 * 总金额_当前待结算费用明细总金额（住院审核时必传，门诊不用传）
	 * @param Totalamount
	 */
	public void setTotalamount(FDouble Totalamount) {
		setAttrVal("Totalamount", Totalamount);
	}
	/**
	 * 主单ID
	 * @return String
	 */
	public String getClaimid() {
		return ((String) getAttrVal("Claimid"));
	}
	/**
	 * 主单ID
	 * @param Claimid
	 */
	public void setClaimid(String Claimid) {
		setAttrVal("Claimid", Claimid);
	}
	/**
	 * 主单(就诊信息)
	 * @return String
	 */
	public VerifyEntInputDTO getHospitalclaim() {
		return ((VerifyEntInputDTO) getAttrVal("Hospitalclaim"));
	}
	/**
	 * 主单(就诊信息)
	 * @param Hospitalclaim
	 */
	public void setHospitalclaim(VerifyEntInputDTO Hospitalclaim) {
		setAttrVal("Hospitalclaim", Hospitalclaim);
	}
	/**
	 * 处方明细信息
	 * @return FArrayList
	 */
	public FArrayList getSrvdetail() {
		return ((FArrayList) getAttrVal("Srvdetail"));
	}
	/**
	 * 处方明细信息
	 * @param Srvdetail
	 */
	public void setSrvdetail(FArrayList Srvdetail) {
		setAttrVal("Srvdetail", Srvdetail);
	}
}