package iih.bl.hp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保费用明细对照 DTO数据 
 * 
 */
public class HpFeeDetailedDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 定点医保机构编码
	 * @return String
	 */
	public String getHporgcode() {
		return ((String) getAttrVal("Hporgcode"));
	}
	/**
	 * 定点医保机构编码
	 * @param Hporgcode
	 */
	public void setHporgcode(String Hporgcode) {
		setAttrVal("Hporgcode", Hporgcode);
	}
	/**
	 * 门诊/住院流水号
	 * @return String
	 */
	public String getSerialno() {
		return ((String) getAttrVal("Serialno"));
	}
	/**
	 * 门诊/住院流水号
	 * @param Serialno
	 */
	public void setSerialno(String Serialno) {
		setAttrVal("Serialno", Serialno);
	}
	/**
	 * 单据号
	 * @return String
	 */
	public String getBillno() {
		return ((String) getAttrVal("Billno"));
	}
	/**
	 * 单据号
	 * @param Billno
	 */
	public void setBillno(String Billno) {
		setAttrVal("Billno", Billno);
	}
	/**
	 * 交易类型
	 * @return String
	 */
	public String getTradetype() {
		return ((String) getAttrVal("Tradetype"));
	}
	/**
	 * 交易类型
	 * @param Tradetype
	 */
	public void setTradetype(String Tradetype) {
		setAttrVal("Tradetype", Tradetype);
	}
	/**
	 * 个人编号
	 * @return String
	 */
	public String getPersoncode() {
		return ((String) getAttrVal("Personcode"));
	}
	/**
	 * 个人编号
	 * @param Personcode
	 */
	public void setPersoncode(String Personcode) {
		setAttrVal("Personcode", Personcode);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getMedca() {
		return ((String) getAttrVal("Medca"));
	}
	/**
	 * 医疗类别
	 * @param Medca
	 */
	public void setMedca(String Medca) {
		setAttrVal("Medca", Medca);
	}
	/**
	 * 医疗人员类别
	 * @return String
	 */
	public String getPersonca() {
		return ((String) getAttrVal("Personca"));
	}
	/**
	 * 医疗人员类别
	 * @param Personca
	 */
	public void setPersonca(String Personca) {
		setAttrVal("Personca", Personca);
	}
	/**
	 * 医疗待遇类别
	 * @return String
	 */
	public String getTreatmentca() {
		return ((String) getAttrVal("Treatmentca"));
	}
	/**
	 * 医疗待遇类别
	 * @param Treatmentca
	 */
	public void setTreatmentca(String Treatmentca) {
		setAttrVal("Treatmentca", Treatmentca);
	}
	/**
	 * 单位编号
	 * @return String
	 */
	public String getCompanycode() {
		return ((String) getAttrVal("Companycode"));
	}
	/**
	 * 单位编号
	 * @param Companycode
	 */
	public void setCompanycode(String Companycode) {
		setAttrVal("Companycode", Companycode);
	}
	/**
	 * 经办时间
	 * @return String
	 */
	public String getOperatime() {
		return ((String) getAttrVal("Operatime"));
	}
	/**
	 * 经办时间
	 * @param Operatime
	 */
	public void setOperatime(String Operatime) {
		setAttrVal("Operatime", Operatime);
	}
	/**
	 * 进入统筹费用
	 * @return String
	 */
	public String getEnterhpfee() {
		return ((String) getAttrVal("Enterhpfee"));
	}
	/**
	 * 进入统筹费用
	 * @param Enterhpfee
	 */
	public void setEnterhpfee(String Enterhpfee) {
		setAttrVal("Enterhpfee", Enterhpfee);
	}
	/**
	 * 进入救助金费用
	 * @return String
	 */
	public String getEnterrescuefee() {
		return ((String) getAttrVal("Enterrescuefee"));
	}
	/**
	 * 进入救助金费用
	 * @param Enterrescuefee
	 */
	public void setEnterrescuefee(String Enterrescuefee) {
		setAttrVal("Enterrescuefee", Enterrescuefee);
	}
	/**
	 * 医疗费总额
	 * @return String
	 */
	public String getFeetotal() {
		return ((String) getAttrVal("Feetotal"));
	}
	/**
	 * 医疗费总额
	 * @param Feetotal
	 */
	public void setFeetotal(String Feetotal) {
		setAttrVal("Feetotal", Feetotal);
	}
	/**
	 * 符合基本医疗费用
	 * @return String
	 */
	public String getAccordbasicfee() {
		return ((String) getAttrVal("Accordbasicfee"));
	}
	/**
	 * 符合基本医疗费用
	 * @param Accordbasicfee
	 */
	public void setAccordbasicfee(String Accordbasicfee) {
		setAttrVal("Accordbasicfee", Accordbasicfee);
	}
	/**
	 * 账户支付金额
	 * @return String
	 */
	public String getPsnaccpay() {
		return ((String) getAttrVal("Psnaccpay"));
	}
	/**
	 * 账户支付金额
	 * @param Psnaccpay
	 */
	public void setPsnaccpay(String Psnaccpay) {
		setAttrVal("Psnaccpay", Psnaccpay);
	}
	/**
	 * 现金支付金额
	 * @return String
	 */
	public String getCashpay() {
		return ((String) getAttrVal("Cashpay"));
	}
	/**
	 * 现金支付金额
	 * @param Cashpay
	 */
	public void setCashpay(String Cashpay) {
		setAttrVal("Cashpay", Cashpay);
	}
	/**
	 * 统筹支付金额
	 * @return String
	 */
	public String getHppay() {
		return ((String) getAttrVal("Hppay"));
	}
	/**
	 * 统筹支付金额
	 * @param Hppay
	 */
	public void setHppay(String Hppay) {
		setAttrVal("Hppay", Hppay);
	}
	/**
	 * 大病救助基金支付
	 * @return String
	 */
	public String getIllnesspay() {
		return ((String) getAttrVal("Illnesspay"));
	}
	/**
	 * 大病救助基金支付
	 * @param Illnesspay
	 */
	public void setIllnesspay(String Illnesspay) {
		setAttrVal("Illnesspay", Illnesspay);
	}
	/**
	 * 公务员补助支付
	 * @return String
	 */
	public String getCivilservantpay() {
		return ((String) getAttrVal("Civilservantpay"));
	}
	/**
	 * 公务员补助支付
	 * @param Civilservantpay
	 */
	public void setCivilservantpay(String Civilservantpay) {
		setAttrVal("Civilservantpay", Civilservantpay);
	}
	/**
	 * 自费金额
	 * @return String
	 */
	public String getSelfamt() {
		return ((String) getAttrVal("Selfamt"));
	}
	/**
	 * 自费金额
	 * @param Selfamt
	 */
	public void setSelfamt(String Selfamt) {
		setAttrVal("Selfamt", Selfamt);
	}
	/**
	 * 乙类药品自理费用
	 * @return String
	 */
	public String getDrugsseftamt() {
		return ((String) getAttrVal("Drugsseftamt"));
	}
	/**
	 * 乙类药品自理费用
	 * @param Drugsseftamt
	 */
	public void setDrugsseftamt(String Drugsseftamt) {
		setAttrVal("Drugsseftamt", Drugsseftamt);
	}
	/**
	 * 特检自理费用
	 * @return String
	 */
	public String getSepcinspectionamt() {
		return ((String) getAttrVal("Sepcinspectionamt"));
	}
	/**
	 * 特检自理费用
	 * @param Sepcinspectionamt
	 */
	public void setSepcinspectionamt(String Sepcinspectionamt) {
		setAttrVal("Sepcinspectionamt", Sepcinspectionamt);
	}
	/**
	 * 特治自理费用
	 * @return String
	 */
	public String getSpectreatamt() {
		return ((String) getAttrVal("Spectreatamt"));
	}
	/**
	 * 特治自理费用
	 * @param Spectreatamt
	 */
	public void setSpectreatamt(String Spectreatamt) {
		setAttrVal("Spectreatamt", Spectreatamt);
	}
	/**
	 * 超出治疗方案自付费用
	 * @return String
	 */
	public String getOverselfamt() {
		return ((String) getAttrVal("Overselfamt"));
	}
	/**
	 * 超出治疗方案自付费用
	 * @param Overselfamt
	 */
	public void setOverselfamt(String Overselfamt) {
		setAttrVal("Overselfamt", Overselfamt);
	}
	/**
	 * 起付标准自付
	 * @return String
	 */
	public String getOvertopstdpay() {
		return ((String) getAttrVal("Overtopstdpay"));
	}
	/**
	 * 起付标准自付
	 * @param Overtopstdpay
	 */
	public void setOvertopstdpay(String Overtopstdpay) {
		setAttrVal("Overtopstdpay", Overtopstdpay);
	}
	/**
	 * 统筹自付费用
	 * @return String
	 */
	public String getHpselfamt() {
		return ((String) getAttrVal("Hpselfamt"));
	}
	/**
	 * 统筹自付费用
	 * @param Hpselfamt
	 */
	public void setHpselfamt(String Hpselfamt) {
		setAttrVal("Hpselfamt", Hpselfamt);
	}
	/**
	 * 救助金分段自付
	 * @return String
	 */
	public String getRescuesectionself() {
		return ((String) getAttrVal("Rescuesectionself"));
	}
	/**
	 * 救助金分段自付
	 * @param Rescuesectionself
	 */
	public void setRescuesectionself(String Rescuesectionself) {
		setAttrVal("Rescuesectionself", Rescuesectionself);
	}
	/**
	 * 超封顶自付金额
	 * @return String
	 */
	public String getOvertopselfamt() {
		return ((String) getAttrVal("Overtopselfamt"));
	}
	/**
	 * 超封顶自付金额
	 * @param Overtopselfamt
	 */
	public void setOvertopselfamt(String Overtopselfamt) {
		setAttrVal("Overtopselfamt", Overtopselfamt);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	public String getIptimes() {
		return ((String) getAttrVal("Iptimes"));
	}
	/**
	 * 住院次数
	 * @param Iptimes
	 */
	public void setIptimes(String Iptimes) {
		setAttrVal("Iptimes", Iptimes);
	}
}