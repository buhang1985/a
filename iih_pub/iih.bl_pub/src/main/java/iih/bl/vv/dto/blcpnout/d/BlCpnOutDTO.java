package iih.bl.vv.dto.blcpnout.d;

import xap.mw.core.data.*;


/**
 * 优惠券发放DTO数据 
 * 
 */
public class BlCpnOutDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 优惠券发放主键
	 * @return String
	 */
	public String getId_blcpnout() {
		return ((String) getAttrVal("Id_blcpnout"));
	}
	/**
	 * 优惠券发放主键
	 * @param Id_blcpnout
	 */
	public void setId_blcpnout(String Id_blcpnout) {
		setAttrVal("Id_blcpnout", Id_blcpnout);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 类型
	 * @return String
	 */
	public String getEu_cpntp() {
		return ((String) getAttrVal("Eu_cpntp"));
	}
	/**
	 * 类型
	 * @param Eu_cpntp
	 */
	public void setEu_cpntp(String Eu_cpntp) {
		setAttrVal("Eu_cpntp", Eu_cpntp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
}