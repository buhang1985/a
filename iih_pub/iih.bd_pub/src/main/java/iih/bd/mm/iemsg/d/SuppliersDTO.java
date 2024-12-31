package iih.bd.mm.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 生产商和供应商 DTO数据 
 * 
 */
public class SuppliersDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 供应商ID
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}
	/**
	 * 供应商ID
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 供应商与厂商编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 供应商与厂商编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 供应商与厂商名称 
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 供应商与厂商名称 
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 供应商与厂商邮编
	 * @return String
	 */
	public String getPostcode() {
		return ((String) getAttrVal("Postcode"));
	}
	/**
	 * 供应商与厂商邮编
	 * @param Postcode
	 */
	public void setPostcode(String Postcode) {
		setAttrVal("Postcode", Postcode);
	}
	/**
	 * 供应商与厂商地址
	 * @return String
	 */
	public String getAddr() {
		return ((String) getAttrVal("Addr"));
	}
	/**
	 * 供应商与厂商地址
	 * @param Addr
	 */
	public void setAddr(String Addr) {
		setAttrVal("Addr", Addr);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 供应商与厂商电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}
	/**
	 * 供应商与厂商电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 供应商与厂商产品范围
	 * @return String
	 */
	public String getMmrange() {
		return ((String) getAttrVal("Mmrange"));
	}
	/**
	 * 供应商与厂商产品范围
	 * @param Mmrange
	 */
	public void setMmrange(String Mmrange) {
		setAttrVal("Mmrange", Mmrange);
	}
	/**
	 * 供应商与厂商描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 供应商与厂商描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 供应商与厂商联系人
	 * @return String
	 */
	public String getLinkman() {
		return ((String) getAttrVal("Linkman"));
	}
	/**
	 * 供应商与厂商联系人
	 * @param Linkman
	 */
	public void setLinkman(String Linkman) {
		setAttrVal("Linkman", Linkman);
	}
	/**
	 * 消息类型
	 * @return String
	 */
	public String getMessagetype() {
		return ((String) getAttrVal("Messagetype"));
	}
	/**
	 * 消息类型
	 * @param Messagetype
	 */
	public void setMessagetype(String Messagetype) {
		setAttrVal("Messagetype", Messagetype);
	}
}