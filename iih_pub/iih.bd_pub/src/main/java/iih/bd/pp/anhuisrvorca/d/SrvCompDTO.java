package iih.bd.pp.anhuisrvorca.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 服务对照信息 DTO数据 
 * 
 */
public class SrvCompDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务主键
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务主键
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * his服务编码
	 * @return String
	 */
	public String getSrv_hiscode() {
		return ((String) getAttrVal("Srv_hiscode"));
	}
	/**
	 * his服务编码
	 * @param Srv_hiscode
	 */
	public void setSrv_hiscode(String Srv_hiscode) {
		setAttrVal("Srv_hiscode", Srv_hiscode);
	}
	/**
	 * his服务名称
	 * @return String
	 */
	public String getSrv_hisname() {
		return ((String) getAttrVal("Srv_hisname"));
	}
	/**
	 * his服务名称
	 * @param Srv_hisname
	 */
	public void setSrv_hisname(String Srv_hisname) {
		setAttrVal("Srv_hisname", Srv_hisname);
	}
	/**
	 * 医保服务编码
	 * @return String
	 */
	public String getSrv_hpcode() {
		return ((String) getAttrVal("Srv_hpcode"));
	}
	/**
	 * 医保服务编码
	 * @param Srv_hpcode
	 */
	public void setSrv_hpcode(String Srv_hpcode) {
		setAttrVal("Srv_hpcode", Srv_hpcode);
	}
	/**
	 * 医保服务名称
	 * @return String
	 */
	public String getSrv_() {
		return ((String) getAttrVal("Srv_"));
	}
	/**
	 * 医保服务名称
	 * @param Srv_
	 */
	public void setSrv_(String Srv_) {
		setAttrVal("Srv_", Srv_);
	}
	/**
	 * 医保账单项编码
	 * @return String
	 */
	public String getCodeca() {
		return ((String) getAttrVal("Codeca"));
	}
	/**
	 * 医保账单项编码
	 * @param Codeca
	 */
	public void setCodeca(String Codeca) {
		setAttrVal("Codeca", Codeca);
	}
	/**
	 * 账单项编码名称
	 * @return String
	 */
	public String getCodeca_name() {
		return ((String) getAttrVal("Codeca_name"));
	}
	/**
	 * 账单项编码名称
	 * @param Codeca_name
	 */
	public void setCodeca_name(String Codeca_name) {
		setAttrVal("Codeca_name", Codeca_name);
	}
	/**
	 * 自付比例
	 * @return String
	 */
	public String getRate() {
		return ((String) getAttrVal("Rate"));
	}
	/**
	 * 自付比例
	 * @param Rate
	 */
	public void setRate(String Rate) {
		setAttrVal("Rate", Rate);
	}
}