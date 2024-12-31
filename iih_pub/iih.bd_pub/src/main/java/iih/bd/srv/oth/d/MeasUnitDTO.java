package iih.bd.srv.oth.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 包装单位信息DTO DTO数据 
 * 
 */
public class MeasUnitDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 计量单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}
	/**
	 * 计量单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 计量单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 系数_与基本
	 * @return FDouble
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}
	/**
	 * 系数_与基本
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	/**
	 * 当前选项标识
	 * @return FBoolean
	 */
	public FBoolean getFg_cur() {
		return ((FBoolean) getAttrVal("Fg_cur"));
	}
	/**
	 * 当前选项标识
	 * @param Fg_cur
	 */
	public void setFg_cur(FBoolean Fg_cur) {
		setAttrVal("Fg_cur", Fg_cur);
	}
}