package iih.ei.std.d.v1.bl.patregordistrcarddto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者注册或注册发卡入参 DTO数据 
 * 
 */
public class RegOrDistrParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 操作动作
	 * @return String
	 */
	public String getDotype() {
		return ((String) getAttrVal("Dotype"));
	}	
	/**
	 * 操作动作
	 * @param Dotype
	 */
	public void setDotype(String Dotype) {
		setAttrVal("Dotype", Dotype);
	}
	/**
	 * 操作员编码
	 * @return String
	 */
	public String getCode_opera() {
		return ((String) getAttrVal("Code_opera"));
	}	
	/**
	 * 操作员编码
	 * @param Code_opera
	 */
	public void setCode_opera(String Code_opera) {
		setAttrVal("Code_opera", Code_opera);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 就诊卡号
	 * @return String
	 */
	public String getCode_card() {
		return ((String) getAttrVal("Code_card"));
	}	
	/**
	 * 就诊卡号
	 * @param Code_card
	 */
	public void setCode_card(String Code_card) {
		setAttrVal("Code_card", Code_card);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getCode_idtp() {
		return ((String) getAttrVal("Code_idtp"));
	}	
	/**
	 * 证件类型
	 * @param Code_idtp
	 */
	public void setCode_idtp(String Code_idtp) {
		setAttrVal("Code_idtp", Code_idtp);
	}
	/**
	 * 证件号
	 * @return String
	 */
	public String getCode_idnum() {
		return ((String) getAttrVal("Code_idnum"));
	}	
	/**
	 * 证件号
	 * @param Code_idnum
	 */
	public void setCode_idnum(String Code_idnum) {
		setAttrVal("Code_idnum", Code_idnum);
	}
	/**
	 * 身份证uid
	 * @return String
	 */
	public String getUid() {
		return ((String) getAttrVal("Uid"));
	}	
	/**
	 * 身份证uid
	 * @param Uid
	 */
	public void setUid(String Uid) {
		setAttrVal("Uid", Uid);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getSex_pat() {
		return ((String) getAttrVal("Sex_pat"));
	}	
	/**
	 * 患者性别
	 * @param Sex_pat
	 */
	public void setSex_pat(String Sex_pat) {
		setAttrVal("Sex_pat", Sex_pat);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 移动电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 出生日期
	 * @return String
	 */
	public String getDt_birth() {
		return ((String) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(String Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 医保卡号
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 医保卡号
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 银行卡号
	 * @return String
	 */
	public String getCode_bank() {
		return ((String) getAttrVal("Code_bank"));
	}	
	/**
	 * 银行卡号
	 * @param Code_bank
	 */
	public void setCode_bank(String Code_bank) {
		setAttrVal("Code_bank", Code_bank);
	}
	/**
	 * 卡类型
	 * @return String
	 */
	public String getCode_cardtp() {
		return ((String) getAttrVal("Code_cardtp"));
	}	
	/**
	 * 卡类型
	 * @param Code_cardtp
	 */
	public void setCode_cardtp(String Code_cardtp) {
		setAttrVal("Code_cardtp", Code_cardtp);
	}
	/**
	 * 交易凭证号
	 * @return String
	 */
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}	
	/**
	 * 交易凭证号
	 * @param Bankno
	 */
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
	}
	/**
	 * 订单流水号
	 * @return String
	 */
	public String getPaymodenode() {
		return ((String) getAttrVal("Paymodenode"));
	}	
	/**
	 * 订单流水号
	 * @param Paymodenode
	 */
	public void setPaymodenode(String Paymodenode) {
		setAttrVal("Paymodenode", Paymodenode);
	}
	/**
	 * 支付方式
	 * @return String
	 */
	public String getCode_pm() {
		return ((String) getAttrVal("Code_pm"));
	}	
	/**
	 * 支付方式
	 * @param Code_pm
	 */
	public void setCode_pm(String Code_pm) {
		setAttrVal("Code_pm", Code_pm);
	}
	/**
	 * 金额
	 * @return String
	 */
	public String getAmt() {
		return ((String) getAttrVal("Amt"));
	}	
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(String Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 终端类型
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}	
	/**
	 * 终端类型
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 联系人名称
	 * @return String
	 */
	public String getName_patcont() {
		return ((String) getAttrVal("Name_patcont"));
	}	
	/**
	 * 联系人名称
	 * @param Name_patcont
	 */
	public void setName_patcont(String Name_patcont) {
		setAttrVal("Name_patcont", Name_patcont);
	}
	/**
	 * 联系人类型编码
	 * @return String
	 */
	public String getSd_patconttp() {
		return ((String) getAttrVal("Sd_patconttp"));
	}	
	/**
	 * 联系人类型编码
	 * @param Sd_patconttp
	 */
	public void setSd_patconttp(String Sd_patconttp) {
		setAttrVal("Sd_patconttp", Sd_patconttp);
	}
	/**
	 * 家属身份编码
	 * @return String
	 */
	public String getSd_fmrole() {
		return ((String) getAttrVal("Sd_fmrole"));
	}	
	/**
	 * 家属身份编码
	 * @param Sd_fmrole
	 */
	public void setSd_fmrole(String Sd_fmrole) {
		setAttrVal("Sd_fmrole", Sd_fmrole);
	}
	/**
	 * 患者联系人地址
	 * @return String
	 */
	public String getAddr_patcont() {
		return ((String) getAttrVal("Addr_patcont"));
	}	
	/**
	 * 患者联系人地址
	 * @param Addr_patcont
	 */
	public void setAddr_patcont(String Addr_patcont) {
		setAttrVal("Addr_patcont", Addr_patcont);
	}
	/**
	 * 患者联系人电话
	 * @return String
	 */
	public String getTel_patcont() {
		return ((String) getAttrVal("Tel_patcont"));
	}	
	/**
	 * 患者联系人电话
	 * @param Tel_patcont
	 */
	public void setTel_patcont(String Tel_patcont) {
		setAttrVal("Tel_patcont", Tel_patcont);
	}
	/**
	 * 联系人证件类型编码
	 * @return String
	 */
	public String getSd_contidtp() {
		return ((String) getAttrVal("Sd_contidtp"));
	}	
	/**
	 * 联系人证件类型编码
	 * @param Sd_contidtp
	 */
	public void setSd_contidtp(String Sd_contidtp) {
		setAttrVal("Sd_contidtp", Sd_contidtp);
	}
	/**
	 * 联系人证件号
	 * @return String
	 */
	public String getPatcontidno() {
		return ((String) getAttrVal("Patcontidno"));
	}	
	/**
	 * 联系人证件号
	 * @param Patcontidno
	 */
	public void setPatcontidno(String Patcontidno) {
		setAttrVal("Patcontidno", Patcontidno);
	}
	/**
	 * 工作单位
	 * @return String
	 */
	public String getWorkunit() {
		return ((String) getAttrVal("Workunit"));
	}	
	/**
	 * 工作单位
	 * @param Workunit
	 */
	public void setWorkunit(String Workunit) {
		setAttrVal("Workunit", Workunit);
	}
	/**
	 * 现住址区县码
	 * @return String
	 */
	public String getCode_nowarea() {
		return ((String) getAttrVal("Code_nowarea"));
	}	
	/**
	 * 现住址区县码
	 * @param Code_nowarea
	 */
	public void setCode_nowarea(String Code_nowarea) {
		setAttrVal("Code_nowarea", Code_nowarea);
	}
	/**
	 * 现住址详细地址
	 * @return String
	 */
	public String getAddr_now() {
		return ((String) getAttrVal("Addr_now"));
	}	
	/**
	 * 现住址详细地址
	 * @param Addr_now
	 */
	public void setAddr_now(String Addr_now) {
		setAttrVal("Addr_now", Addr_now);
	}
}