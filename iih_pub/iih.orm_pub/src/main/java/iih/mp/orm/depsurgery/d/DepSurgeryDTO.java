package iih.mp.orm.depsurgery.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 科室手术查询 DTO数据 
 * 
 */
public class DepSurgeryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dept_exec() {
		return ((String) getAttrVal("Id_dept_exec"));
	}
	/**
	 * 科室
	 * @param Id_dept_exec
	 */
	public void setId_dept_exec(String Id_dept_exec) {
		setAttrVal("Id_dept_exec", Id_dept_exec);
	}
	/**
	 * 手术例数
	 * @return String
	 */
	public String getSurgerynum() {
		return ((String) getAttrVal("Surgerynum"));
	}
	/**
	 * 手术例数
	 * @param Surgerynum
	 */
	public void setSurgerynum(String Surgerynum) {
		setAttrVal("Surgerynum", Surgerynum);
	}
	/**
	 * 急诊手术
	 * @return String
	 */
	public String getEmersurnum() {
		return ((String) getAttrVal("Emersurnum"));
	}
	/**
	 * 急诊手术
	 * @param Emersurnum
	 */
	public void setEmersurnum(String Emersurnum) {
		setAttrVal("Emersurnum", Emersurnum);
	}
	/**
	 * 择期手术
	 * @return String
	 */
	public String getElecsurnum() {
		return ((String) getAttrVal("Elecsurnum"));
	}
	/**
	 * 择期手术
	 * @param Elecsurnum
	 */
	public void setElecsurnum(String Elecsurnum) {
		setAttrVal("Elecsurnum", Elecsurnum);
	}
	/**
	 * 无菌手术
	 * @return String
	 */
	public String getStersurnum() {
		return ((String) getAttrVal("Stersurnum"));
	}
	/**
	 * 无菌手术
	 * @param Stersurnum
	 */
	public void setStersurnum(String Stersurnum) {
		setAttrVal("Stersurnum", Stersurnum);
	}
	/**
	 * 隔离手术
	 * @return String
	 */
	public String getIsolasurnum() {
		return ((String) getAttrVal("Isolasurnum"));
	}
	/**
	 * 隔离手术
	 * @param Isolasurnum
	 */
	public void setIsolasurnum(String Isolasurnum) {
		setAttrVal("Isolasurnum", Isolasurnum);
	}
	/**
	 * 手术费
	 * @return Integer
	 */
	public Integer getSurbl() {
		return ((Integer) getAttrVal("Surbl"));
	}
	/**
	 * 手术费
	 * @param Surbl
	 */
	public void setSurbl(Integer Surbl) {
		setAttrVal("Surbl", Surbl);
	}
	/**
	 * 麻醉费
	 * @return Integer
	 */
	public Integer getAnabl() {
		return ((Integer) getAttrVal("Anabl"));
	}
	/**
	 * 麻醉费
	 * @param Anabl
	 */
	public void setAnabl(Integer Anabl) {
		setAttrVal("Anabl", Anabl);
	}
	/**
	 * 西药费
	 * @return Integer
	 */
	public Integer getXiyaobl() {
		return ((Integer) getAttrVal("Xiyaobl"));
	}
	/**
	 * 西药费
	 * @param Xiyaobl
	 */
	public void setXiyaobl(Integer Xiyaobl) {
		setAttrVal("Xiyaobl", Xiyaobl);
	}
	/**
	 * 材料费
	 * @return Integer
	 */
	public Integer getMatebl() {
		return ((Integer) getAttrVal("Matebl"));
	}
	/**
	 * 材料费
	 * @param Matebl
	 */
	public void setMatebl(Integer Matebl) {
		setAttrVal("Matebl", Matebl);
	}
	/**
	 * 合计
	 * @return Integer
	 */
	public Integer getTotalbl() {
		return ((Integer) getAttrVal("Totalbl"));
	}
	/**
	 * 合计
	 * @param Totalbl
	 */
	public void setTotalbl(Integer Totalbl) {
		setAttrVal("Totalbl", Totalbl);
	}
}