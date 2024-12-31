package iih.mp.nr.msg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 标本号信息DTO DTO数据 
 * 
 */
public class SampleInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标本条码号
	 * @return String
	 */
	public String getBarcode() {
		return ((String) getAttrVal("Barcode"));
	}
	/**
	 * 标本条码号
	 * @param Barcode
	 */
	public void setBarcode(String Barcode) {
		setAttrVal("Barcode", Barcode);
	}
	/**
	 * 域ID
	 * @return String
	 */
	public String getDomainid() {
		return ((String) getAttrVal("Domainid"));
	}
	/**
	 * 域ID
	 * @param Domainid
	 */
	public void setDomainid(String Domainid) {
		setAttrVal("Domainid", Domainid);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getOrderno() {
		return ((String) getAttrVal("Orderno"));
	}
	/**
	 * 医嘱号
	 * @param Orderno
	 */
	public void setOrderno(String Orderno) {
		setAttrVal("Orderno", Orderno);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getPerformdeptcode() {
		return ((String) getAttrVal("Performdeptcode"));
	}
	/**
	 * 执行科室编码
	 * @param Performdeptcode
	 */
	public void setPerformdeptcode(String Performdeptcode) {
		setAttrVal("Performdeptcode", Performdeptcode);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getPerformdeptname() {
		return ((String) getAttrVal("Performdeptname"));
	}
	/**
	 * 执行科室名称
	 * @param Performdeptname
	 */
	public void setPerformdeptname(String Performdeptname) {
		setAttrVal("Performdeptname", Performdeptname);
	}
	/**
	 * 医疗机构代码
	 * @return String
	 */
	public String getHospitalcode() {
		return ((String) getAttrVal("Hospitalcode"));
	}
	/**
	 * 医疗机构代码
	 * @param Hospitalcode
	 */
	public void setHospitalcode(String Hospitalcode) {
		setAttrVal("Hospitalcode", Hospitalcode);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getHospitalname() {
		return ((String) getAttrVal("Hospitalname"));
	}
	/**
	 * 医疗机构名称
	 * @param Hospitalname
	 */
	public void setHospitalname(String Hospitalname) {
		setAttrVal("Hospitalname", Hospitalname);
	}
	/**
	 * 试管编码
	 * @return String
	 */
	public String getTubecode() {
		return ((String) getAttrVal("Tubecode"));
	}
	/**
	 * 试管编码
	 * @param Tubecode
	 */
	public void setTubecode(String Tubecode) {
		setAttrVal("Tubecode", Tubecode);
	}
	/**
	 * 试管费用编码
	 * @return String
	 */
	public String getTubechargecode() {
		return ((String) getAttrVal("Tubechargecode"));
	}
	/**
	 * 试管费用编码
	 * @param Tubechargecode
	 */
	public void setTubechargecode(String Tubechargecode) {
		setAttrVal("Tubechargecode", Tubechargecode);
	}
	/**
	 * 试管颜色
	 * @return String
	 */
	public String getTubecolour() {
		return ((String) getAttrVal("Tubecolour"));
	}
	/**
	 * 试管颜色
	 * @param Tubecolour
	 */
	public void setTubecolour(String Tubecolour) {
		setAttrVal("Tubecolour", Tubecolour);
	}
	/**
	 * 管数量
	 * @return String
	 */
	public String getTubequantity() {
		return ((String) getAttrVal("Tubequantity"));
	}
	/**
	 * 管数量
	 * @param Tubequantity
	 */
	public void setTubequantity(String Tubequantity) {
		setAttrVal("Tubequantity", Tubequantity);
	}
}