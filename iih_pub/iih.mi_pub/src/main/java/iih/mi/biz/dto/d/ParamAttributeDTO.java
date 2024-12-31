package iih.mi.biz.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

/**
 * 出入参类型集 DTO数据 
 * 
 */
public class ParamAttributeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 一级参数
	 * @return FArrayList
	 */
	public FArrayList getParamattributelevel1() {
		return ((FArrayList) getAttrVal("Paramattributelevel1"));
	}
	/**
	 * 一级参数
	 * @param Paramattributelevel1
	 */
	public void setParamattributelevel1(FArrayList Paramattributelevel1) {
		setAttrVal("Paramattributelevel1", Paramattributelevel1);
	}
	/**
	 * 二级参数
	 * @return FArrayList
	 */
	public FArrayList getParamattributestr2() {
		return ((FArrayList) getAttrVal("Paramattributestr2"));
	}
	/**
	 * 二级参数
	 * @param Paramattributestr2
	 */
	public void setParamattributestr2(FArrayList Paramattributestr2) {
		setAttrVal("Paramattributestr2", Paramattributestr2);
	}
}