package iih.pe.por.dto.pecorpchargedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检团体费用结账单明细 DTO数据 
 * 
 */
public class PeCorpChargeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检团体结账明细主键标识
	 * @return String
	 */
	public String getId_pecorpchargeitm() {
		return ((String) getAttrVal("Id_pecorpchargeitm"));
	}
	/**
	 * 体检团体结账明细主键标识
	 * @param Id_pecorpchargeitm
	 */
	public void setId_pecorpchargeitm(String Id_pecorpchargeitm) {
		setAttrVal("Id_pecorpchargeitm", Id_pecorpchargeitm);
	}
	/**
	 * 体检团体结账ID
	 * @return String
	 */
	public String getId_pecorpcharge() {
		return ((String) getAttrVal("Id_pecorpcharge"));
	}
	/**
	 * 体检团体结账ID
	 * @param Id_pecorpcharge
	 */
	public void setId_pecorpcharge(String Id_pecorpcharge) {
		setAttrVal("Id_pecorpcharge", Id_pecorpcharge);
	}
	/**
	 * 体检项目ID
	 * @return String
	 */
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}
	/**
	 * 体检项目ID
	 * @param Id_pesrvbcatlog
	 */
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
	}
	/**
	 * 收费项目ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 收费项目ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 收费项目编码
	 * @return String
	 */
	public String getSd_srv() {
		return ((String) getAttrVal("Sd_srv"));
	}
	/**
	 * 收费项目编码
	 * @param Sd_srv
	 */
	public void setSd_srv(String Sd_srv) {
		setAttrVal("Sd_srv", Sd_srv);
	}
	/**
	 * 单项折扣
	 * @return FDouble
	 */
	public FDouble getDis_itm() {
		return ((FDouble) getAttrVal("Dis_itm"));
	}
	/**
	 * 单项折扣
	 * @param Dis_itm
	 */
	public void setDis_itm(FDouble Dis_itm) {
		setAttrVal("Dis_itm", Dis_itm);
	}
	/**
	 * 单项价格
	 * @return FDouble
	 */
	public FDouble getPri_itm() {
		return ((FDouble) getAttrVal("Pri_itm"));
	}
	/**
	 * 单项价格
	 * @param Pri_itm
	 */
	public void setPri_itm(FDouble Pri_itm) {
		setAttrVal("Pri_itm", Pri_itm);
	}
	/**
	 * 实收价格
	 * @return FDouble
	 */
	public FDouble getPri_charge() {
		return ((FDouble) getAttrVal("Pri_charge"));
	}
	/**
	 * 实收价格
	 * @param Pri_charge
	 */
	public void setPri_charge(FDouble Pri_charge) {
		setAttrVal("Pri_charge", Pri_charge);
	}
	/**
	 * 实收人数
	 * @return Integer
	 */
	public Integer getNum_charge() {
		return ((Integer) getAttrVal("Num_charge"));
	}
	/**
	 * 实收人数
	 * @param Num_charge
	 */
	public void setNum_charge(Integer Num_charge) {
		setAttrVal("Num_charge", Num_charge);
	}
	/**
	 * 应收金额
	 * @return FDouble
	 */
	public FDouble getAmt_charge() {
		return ((FDouble) getAttrVal("Amt_charge"));
	}
	/**
	 * 应收金额
	 * @param Amt_charge
	 */
	public void setAmt_charge(FDouble Amt_charge) {
		setAttrVal("Amt_charge", Amt_charge);
	}
	/**
	 * 体检项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 体检项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
}