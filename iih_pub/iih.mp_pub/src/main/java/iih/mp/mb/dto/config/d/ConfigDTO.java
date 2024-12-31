package iih.mp.mb.dto.config.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 参数优先计算 DTO数据 
 * 
 */
public class ConfigDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 参数名称
	 * @return String
	 */
	public String getConfigname() {
		return ((String) getAttrVal("Configname"));
	}
	/**
	 * 参数名称
	 * @param Configname
	 */
	public void setConfigname(String Configname) {
		setAttrVal("Configname", Configname);
	}
	/**
	 * 参数值
	 * @return String
	 */
	public String getConfigvalue() {
		return ((String) getAttrVal("Configvalue"));
	}
	/**
	 * 参数值
	 * @param Configvalue
	 */
	public void setConfigvalue(String Configvalue) {
		setAttrVal("Configvalue", Configvalue);
	}
	/**
	 * 参数描述
	 * @return String
	 */
	public String getConfigdesc() {
		return ((String) getAttrVal("Configdesc"));
	}
	/**
	 * 参数描述
	 * @param Configdesc
	 */
	public void setConfigdesc(String Configdesc) {
		setAttrVal("Configdesc", Configdesc);
	}
	/**
	 * 设备类型
	 * @return String
	 */
	public String getDevicetype() {
		return ((String) getAttrVal("Devicetype"));
	}
	/**
	 * 设备类型
	 * @param Devicetype
	 */
	public void setDevicetype(String Devicetype) {
		setAttrVal("Devicetype", Devicetype);
	}
	/**
	 * 产品标识
	 * @return String
	 */
	public String getProduct() {
		return ((String) getAttrVal("Product"));
	}
	/**
	 * 产品标识
	 * @param Product
	 */
	public void setProduct(String Product) {
		setAttrVal("Product", Product);
	}
	/**
	 * 平台
	 * @return String
	 */
	public String getPlatform() {
		return ((String) getAttrVal("Platform"));
	}
	/**
	 * 平台
	 * @param Platform
	 */
	public void setPlatform(String Platform) {
		setAttrVal("Platform", Platform);
	}
	/**
	 * 设备型号
	 * @return String
	 */
	public String getDevicemodel() {
		return ((String) getAttrVal("Devicemodel"));
	}
	/**
	 * 设备型号
	 * @param Devicemodel
	 */
	public void setDevicemodel(String Devicemodel) {
		setAttrVal("Devicemodel", Devicemodel);
	}
	/**
	 * 优先级
	 * @return Integer
	 */
	public Integer getLev() {
		return ((Integer) getAttrVal("Lev"));
	}
	/**
	 * 优先级
	 * @param Lev
	 */
	public void setLev(Integer Lev) {
		setAttrVal("Lev", Lev);
	}
}