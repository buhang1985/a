package iih.mp.nr.vitalsigns.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 下拉枚举值 DTO数据 
 * 
 */
public class EnumSourceDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键标识
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主键标识
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 枚举分类
	 * @return String
	 */
	public String getId_ca() {
		return ((String) getAttrVal("Id_ca"));
	}
	/**
	 * 枚举分类
	 * @param Id_ca
	 */
	public void setId_ca(String Id_ca) {
		setAttrVal("Id_ca", Id_ca);
	}
	/**
	 * 父级ID
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}
	/**
	 * 父级ID
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
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
	/**
	 * 值
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 值
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 系统事件标识
	 * @return FBoolean
	 */
	public FBoolean getFg_sysevent() {
		return ((FBoolean) getAttrVal("Fg_sysevent"));
	}
	/**
	 * 系统事件标识
	 * @param Fg_sysevent
	 */
	public void setFg_sysevent(FBoolean Fg_sysevent) {
		setAttrVal("Fg_sysevent", Fg_sysevent);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
}