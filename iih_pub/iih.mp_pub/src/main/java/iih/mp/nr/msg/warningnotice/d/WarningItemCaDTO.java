package iih.mp.nr.msg.warningnotice.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 警告项目分类 DTO数据 
 * 
 */
public class WarningItemCaDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 项目分类代码
	 * @return String
	 */
	public String getLabitemcode() {
		return ((String) getAttrVal("Labitemcode"));
	}
	/**
	 * 项目分类代码
	 * @param Labitemcode
	 */
	public void setLabitemcode(String Labitemcode) {
		setAttrVal("Labitemcode", Labitemcode);
	}
	/**
	 * 项目分类名称
	 * @return String
	 */
	public String getLabitemname() {
		return ((String) getAttrVal("Labitemname"));
	}
	/**
	 * 项目分类名称
	 * @param Labitemname
	 */
	public void setLabitemname(String Labitemname) {
		setAttrVal("Labitemname", Labitemname);
	}
	/**
	 * 项目子分类
	 * @return FArrayList2
	 */
	public FArrayList2 getWarningdetail() {
		return ((FArrayList2) getAttrVal("Warningdetail"));
	}
	/**
	 * 项目子分类
	 * @param Warningdetail
	 */
	public void setWarningdetail(FArrayList2 Warningdetail) {
		setAttrVal("Warningdetail", Warningdetail);
	}
}