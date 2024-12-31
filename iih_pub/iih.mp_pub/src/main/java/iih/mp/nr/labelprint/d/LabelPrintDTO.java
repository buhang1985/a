package iih.mp.nr.labelprint.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 标签打印DTO DTO数据 
 * 
 */
public class LabelPrintDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标签类型
	 * @return String
	 */
	public String getId_labeltype() {
		return ((String) getAttrVal("Id_labeltype"));
	}
	/**
	 * 标签类型
	 * @param Id_labeltype
	 */
	public void setId_labeltype(String Id_labeltype) {
		setAttrVal("Id_labeltype", Id_labeltype);
	}
	/**
	 * 起始时间
	 * @return FDateTime
	 */
	public FDateTime getStarttime() {
		return ((FDateTime) getAttrVal("Starttime"));
	}
	/**
	 * 起始时间
	 * @param Starttime
	 */
	public void setStarttime(FDateTime Starttime) {
		setAttrVal("Starttime", Starttime);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getEndtime() {
		return ((FDateTime) getAttrVal("Endtime"));
	}
	/**
	 * 结束时间
	 * @param Endtime
	 */
	public void setEndtime(FDateTime Endtime) {
		setAttrVal("Endtime", Endtime);
	}
	/**
	 * 是否全部打印
	 * @return String
	 */
	public String getFgprint() {
		return ((String) getAttrVal("Fgprint"));
	}
	/**
	 * 是否全部打印
	 * @param Fgprint
	 */
	public void setFgprint(String Fgprint) {
		setAttrVal("Fgprint", Fgprint);
	}
	/**
	 * 长期临时
	 * @return String
	 */
	public String getFglong() {
		return ((String) getAttrVal("Fglong"));
	}
	/**
	 * 长期临时
	 * @param Fglong
	 */
	public void setFglong(String Fglong) {
		setAttrVal("Fglong", Fglong);
	}
	/**
	 * 标签类型名称
	 * @return String
	 */
	public String getName_labeltype() {
		return ((String) getAttrVal("Name_labeltype"));
	}
	/**
	 * 标签类型名称
	 * @param Name_labeltype
	 */
	public void setName_labeltype(String Name_labeltype) {
		setAttrVal("Name_labeltype", Name_labeltype);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 用法串
	 * @return String
	 */
	public String getId_routes() {
		return ((String) getAttrVal("Id_routes"));
	}
	/**
	 * 用法串
	 * @param Id_routes
	 */
	public void setId_routes(String Id_routes) {
		setAttrVal("Id_routes", Id_routes);
	}
	/**
	 * 标签类型编码
	 * @return String
	 */
	public String getCode_labeltype() {
		return ((String) getAttrVal("Code_labeltype"));
	}
	/**
	 * 标签类型编码
	 * @param Code_labeltype
	 */
	public void setCode_labeltype(String Code_labeltype) {
		setAttrVal("Code_labeltype", Code_labeltype);
	}
}