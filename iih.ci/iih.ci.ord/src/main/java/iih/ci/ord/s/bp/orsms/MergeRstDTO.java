package iih.ci.ord.s.bp.orsms;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FMap2;

/**
 * 合单返回值
 * @author zhangwq
 *
 */
public class MergeRstDTO extends BaseDTO{
	/**
	 * 结果编码
	 * @return String
	 */
	public String getResultcode() {
		return ((String) getAttrVal("Resultcode"));
	}
	/**
	 * 结果编码
	 * @param Resultcode
	 */
	public void setResultcode(String Resultcode) {
		setAttrVal("Resultcode", Resultcode);
	}
	/**
	 * 结果编码
	 * @return FMap2
	 */
	public FMap2 getExtension() {
		return ((FMap2) getAttrVal("Extension"));
	}
	/**
	 * 结果编码
	 * @param Extension
	 */
	public void setExtension(FMap2 Extension) {
		setAttrVal("Extension", Extension);
	}
}
