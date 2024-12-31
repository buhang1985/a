package iih.en.pv.outpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 挂号就诊联系人DTO DTO数据 
 * 
 */
public class OpRegPiContDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者就诊联系人ID
	 * @return String
	 */
	public String getId_patcont() {
		return ((String) getAttrVal("Id_patcont"));
	}
	/**
	 * 患者就诊联系人ID
	 * @param Id_patcont
	 */
	public void setId_patcont(String Id_patcont) {
		setAttrVal("Id_patcont", Id_patcont);
	}
	/**
	 * 联系人类型编码
	 * @return String
	 */
	public String getSd_conttp() {
		return ((String) getAttrVal("Sd_conttp"));
	}
	/**
	 * 联系人类型编码
	 * @param Sd_conttp
	 */
	public void setSd_conttp(String Sd_conttp) {
		setAttrVal("Sd_conttp", Sd_conttp);
	}
	/**
	 * 联系人类型ID
	 * @return String
	 */
	public String getId_conttp() {
		return ((String) getAttrVal("Id_conttp"));
	}
	/**
	 * 联系人类型ID
	 * @param Id_conttp
	 */
	public void setId_conttp(String Id_conttp) {
		setAttrVal("Id_conttp", Id_conttp);
	}
	/**
	 * 联系人类型名称
	 * @return String
	 */
	public String getName_conttp() {
		return ((String) getAttrVal("Name_conttp"));
	}
	/**
	 * 联系人类型名称
	 * @param Name_conttp
	 */
	public void setName_conttp(String Name_conttp) {
		setAttrVal("Name_conttp", Name_conttp);
	}
	/**
	 * 联系人姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 联系人姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getConttel() {
		return ((String) getAttrVal("Conttel"));
	}
	/**
	 * 联系人电话
	 * @param Conttel
	 */
	public void setConttel(String Conttel) {
		setAttrVal("Conttel", Conttel);
	}
	/**
	 * 联系人地址
	 * @return String
	 */
	public String getContaddr() {
		return ((String) getAttrVal("Contaddr"));
	}
	/**
	 * 联系人地址
	 * @param Contaddr
	 */
	public void setContaddr(String Contaddr) {
		setAttrVal("Contaddr", Contaddr);
	}
	/**
	 * 合同单位ID
	 * @return String
	 */
	public String getId_cust_cmpy() {
		return ((String) getAttrVal("Id_cust_cmpy"));
	}
	/**
	 * 合同单位ID
	 * @param Id_cust_cmpy
	 */
	public void setId_cust_cmpy(String Id_cust_cmpy) {
		setAttrVal("Id_cust_cmpy", Id_cust_cmpy);
	}
	/**
	 * 合同单位
	 * @return String
	 */
	public String getName_cust_compy() {
		return ((String) getAttrVal("Name_cust_compy"));
	}
	/**
	 * 合同单位
	 * @param Name_cust_compy
	 */
	public void setName_cust_compy(String Name_cust_compy) {
		setAttrVal("Name_cust_compy", Name_cust_compy);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
}