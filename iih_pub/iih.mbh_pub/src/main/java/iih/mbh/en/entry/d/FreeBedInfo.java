package iih.mbh.en.entry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 空闲床位信息 DTO数据 
 * 
 */
public class FreeBedInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 床位编码
	 * @return String
	 */
	public String getBed_code() {
		return ((String) getAttrVal("Bed_code"));
	}
	/**
	 * 床位编码
	 * @param Bed_code
	 */
	public void setBed_code(String Bed_code) {
		setAttrVal("Bed_code", Bed_code);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getBed_name() {
		return ((String) getAttrVal("Bed_name"));
	}
	/**
	 * 床位号
	 * @param Bed_name
	 */
	public void setBed_name(String Bed_name) {
		setAttrVal("Bed_name", Bed_name);
	}
	/**
	 * 床类型
	 * @return String
	 */
	public String getBed_type() {
		return ((String) getAttrVal("Bed_type"));
	}
	/**
	 * 床类型
	 * @param Bed_type
	 */
	public void setBed_type(String Bed_type) {
		setAttrVal("Bed_type", Bed_type);
	}
	/**
	 * 床位所属病区
	 * @return String
	 */
	public String getId_dep_belong() {
		return ((String) getAttrVal("Id_dep_belong"));
	}
	/**
	 * 床位所属病区
	 * @param Id_dep_belong
	 */
	public void setId_dep_belong(String Id_dep_belong) {
		setAttrVal("Id_dep_belong", Id_dep_belong);
	}
}