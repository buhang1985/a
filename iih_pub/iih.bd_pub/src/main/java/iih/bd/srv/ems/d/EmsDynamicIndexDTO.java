package iih.bd.srv.ems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医疗单动态指标信息DTO DTO数据 
 * 
 */
public class EmsDynamicIndexDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务主键标识
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务主键标识
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 医疗服务编码
	 * @return String
	 */
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}
	/**
	 * 医疗服务编码
	 * @param Srv_code
	 */
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	/**
	 * 显示名称
	 * @return String
	 */
	public String getShowname() {
		return ((String) getAttrVal("Showname"));
	}
	/**
	 * 显示名称
	 * @param Showname
	 */
	public void setShowname(String Showname) {
		setAttrVal("Showname", Showname);
	}
	/**
	 * 数据类型
	 * @return String
	 */
	public String getDatatype() {
		return ((String) getAttrVal("Datatype"));
	}
	/**
	 * 数据类型
	 * @param Datatype
	 */
	public void setDatatype(String Datatype) {
		setAttrVal("Datatype", Datatype);
	}
	/**
	 * 最大值
	 * @return Integer
	 */
	public Integer getMaxv() {
		return ((Integer) getAttrVal("Maxv"));
	}
	/**
	 * 最大值
	 * @param Maxv
	 */
	public void setMaxv(Integer Maxv) {
		setAttrVal("Maxv", Maxv);
	}
	/**
	 * 最小值
	 * @return Integer
	 */
	public Integer getMinv() {
		return ((Integer) getAttrVal("Minv"));
	}
	/**
	 * 最小值
	 * @param Minv
	 */
	public void setMinv(Integer Minv) {
		setAttrVal("Minv", Minv);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}
	/**
	 * 单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getUnitname() {
		return ((String) getAttrVal("Unitname"));
	}
	/**
	 * 单位名称
	 * @param Unitname
	 */
	public void setUnitname(String Unitname) {
		setAttrVal("Unitname", Unitname);
	}
	/**
	 * 值域
	 * @return String
	 */
	public String getEnumvalues() {
		return ((String) getAttrVal("Enumvalues"));
	}
	/**
	 * 值域
	 * @param Enumvalues
	 */
	public void setEnumvalues(String Enumvalues) {
		setAttrVal("Enumvalues", Enumvalues);
	}
	/**
	 * 指标值
	 * @return String
	 */
	public String getIndexval() {
		return ((String) getAttrVal("Indexval"));
	}
	/**
	 * 指标值
	 * @param Indexval
	 */
	public void setIndexval(String Indexval) {
		setAttrVal("Indexval", Indexval);
	}
	/**
	 * 允许为空标识
	 * @return FBoolean
	 */
	public FBoolean getFg_allowempty() {
		return ((FBoolean) getAttrVal("Fg_allowempty"));
	}
	/**
	 * 允许为空标识
	 * @param Fg_allowempty
	 */
	public void setFg_allowempty(FBoolean Fg_allowempty) {
		setAttrVal("Fg_allowempty", Fg_allowempty);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
}