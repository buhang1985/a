package iih.sc.scbd.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 日志记录事件DTO DTO数据 
 * 
 */
public class ScLogEventDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 操作类型
	 * @return String
	 */
	public String getEuopertp() {
		return ((String) getAttrVal("Euopertp"));
	}
	/**
	 * 操作类型
	 * @param Euopertp
	 */
	public void setEuopertp(String Euopertp) {
		setAttrVal("Euopertp", Euopertp);
	}
	/**
	 * 新数据
	 * @return FArrayList
	 */
	public FArrayList getNewobjs() {
		return ((FArrayList) getAttrVal("Newobjs"));
	}
	/**
	 * 新数据
	 * @param Newobjs
	 */
	public void setNewobjs(FArrayList Newobjs) {
		setAttrVal("Newobjs", Newobjs);
	}
	/**
	 * 旧数据
	 * @return FArrayList
	 */
	public FArrayList getOldobjs() {
		return ((FArrayList) getAttrVal("Oldobjs"));
	}
	/**
	 * 旧数据
	 * @param Oldobjs
	 */
	public void setOldobjs(FArrayList Oldobjs) {
		setAttrVal("Oldobjs", Oldobjs);
	}
	/**
	 * 操作人员
	 * @return String
	 */
	public String getId_psn() {
		return ((String) getAttrVal("Id_psn"));
	}
	/**
	 * 操作人员
	 * @param Id_psn
	 */
	public void setId_psn(String Id_psn) {
		setAttrVal("Id_psn", Id_psn);
	}
}