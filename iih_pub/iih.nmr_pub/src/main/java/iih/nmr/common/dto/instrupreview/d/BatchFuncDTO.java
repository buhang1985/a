package iih.nmr.common.dto.instrupreview.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 文书批量预览节点参数 DTO数据 
 * 
 */
public class BatchFuncDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 节点编码
	 * @return String
	 */
	public String getFun_code() {
		return ((String) getAttrVal("Fun_code"));
	}
	/**
	 * 节点编码
	 * @param Fun_code
	 */
	public void setFun_code(String Fun_code) {
		setAttrVal("Fun_code", Fun_code);
	}
	/**
	 * 参数名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 参数名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 参数值
	 * @return String
	 */
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}
	/**
	 * 参数值
	 * @param Val
	 */
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
}