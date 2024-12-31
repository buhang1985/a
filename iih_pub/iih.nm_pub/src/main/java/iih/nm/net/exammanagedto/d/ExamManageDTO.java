package iih.nm.net.exammanagedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 考试管理 DTO数据 
 * 
 */
public class ExamManageDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * ID
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
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
	 * 是否部门
	 * @return FBoolean
	 */
	public FBoolean getFg_dep() {
		return ((FBoolean) getAttrVal("Fg_dep"));
	}
	/**
	 * 是否部门
	 * @param Fg_dep
	 */
	public void setFg_dep(FBoolean Fg_dep) {
		setAttrVal("Fg_dep", Fg_dep);
	}
}