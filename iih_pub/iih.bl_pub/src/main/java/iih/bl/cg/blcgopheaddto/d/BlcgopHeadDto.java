package iih.bl.cg.blcgopheaddto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊费用清单头 DTO数据 
 * 
 */
public class BlcgopHeadDto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}
	/**
	 * 患者编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 价格分类
	 * @return String
	 */
	public String getPat_id_pripat() {
		return ((String) getAttrVal("Pat_id_pripat"));
	}
	/**
	 * 价格分类
	 * @param Pat_id_pripat
	 */
	public void setPat_id_pripat(String Pat_id_pripat) {
		setAttrVal("Pat_id_pripat", Pat_id_pripat);
	}
	/**
	 * 当前科室
	 * @return String
	 */
	public String getId_dep_reg() {
		return ((String) getAttrVal("Id_dep_reg"));
	}
	/**
	 * 当前科室
	 * @param Id_dep_reg
	 */
	public void setId_dep_reg(String Id_dep_reg) {
		setAttrVal("Id_dep_reg", Id_dep_reg);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getPat_dt_acpt() {
		return ((FDateTime) getAttrVal("Pat_dt_acpt"));
	}
	/**
	 * 入院日期
	 * @param Pat_dt_acpt
	 */
	public void setPat_dt_acpt(FDateTime Pat_dt_acpt) {
		setAttrVal("Pat_dt_acpt", Pat_dt_acpt);
	}
}