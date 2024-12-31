package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者银行账户dto DTO数据 
 * 
 */
public class EnEntBankaccDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	public String getTimes_ip() {
		return ((String) getAttrVal("Times_ip"));
	}
	/**
	 * 住院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(String Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 账户名称
	 * @return String
	 */
	public String getName_acc() {
		return ((String) getAttrVal("Name_acc"));
	}
	/**
	 * 账户名称
	 * @param Name_acc
	 */
	public void setName_acc(String Name_acc) {
		setAttrVal("Name_acc", Name_acc);
	}
	/**
	 * 开户机构名称
	 * @return String
	 */
	public String getBank_name() {
		return ((String) getAttrVal("Bank_name"));
	}
	/**
	 * 开户机构名称
	 * @param Bank_name
	 */
	public void setBank_name(String Bank_name) {
		setAttrVal("Bank_name", Bank_name);
	}
	/**
	 * 账户
	 * @return String
	 */
	public String getNo_acc() {
		return ((String) getAttrVal("No_acc"));
	}
	/**
	 * 账户
	 * @param No_acc
	 */
	public void setNo_acc(String No_acc) {
		setAttrVal("No_acc", No_acc);
	}
	/**
	 * 联行号
	 * @return String
	 */
	public String getBank_id_code() {
		return ((String) getAttrVal("Bank_id_code"));
	}
	/**
	 * 联行号
	 * @param Bank_id_code
	 */
	public void setBank_id_code(String Bank_id_code) {
		setAttrVal("Bank_id_code", Bank_id_code);
	}
	/**
	 * 银行id
	 * @return String
	 */
	public String getId_bank() {
		return ((String) getAttrVal("Id_bank"));
	}
	/**
	 * 银行id
	 * @param Id_bank
	 */
	public void setId_bank(String Id_bank) {
		setAttrVal("Id_bank", Id_bank);
	}
}