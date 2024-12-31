package iih.pe.pqry.sortofabnordetecrate.d;

import xap.mw.core.data.BaseDTO;

/**
 * 体检异常发现检出率排序表 DTO数据 
 * 
 */
public class SortOfAbnormalDetecRateDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊断
	 * @return String
	 */
	public String getDiag() {
		return ((String) getAttrVal("Diag"));
	}
	/**
	 * 诊断
	 * @param Diag
	 */
	public void setDiag(String Diag) {
		setAttrVal("Diag", Diag);
	}
	
	/**
	 * 比例
	 * @return String
	 */
	public String getScale() {
		return ((String) getAttrVal("Scale"));
	}
	/**
	 * 比例
	 * @param Count
	 */
	public void setScale(String Scale) {
		setAttrVal("Scale", Scale);
	}
}
