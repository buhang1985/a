package iih.ci.ord.i.meta;

import iih.ci.ord.i.common.b.BaseEmsDTO;
import xap.mw.core.data.FArrayList;

/**
 * 医疗单返回结果对象
 * 
 * @author wangqingzhu
 *
 */
public class EmsRstDTO extends BaseEmsDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	/**
	 * 错误医嘱
	 * 
	 * @return FArrayList
	 */
	public FArrayList getErrorEmsList() {
		return ((FArrayList) getAttrVal("ErrorEmsList"));
	}

	/**
	 * 错误医嘱
	 * 
	 * @param ErrorEmsList
	 */
	public void setErrorEmsList(FArrayList ErrorEmsList) {
		setAttrVal("ErrorEmsList", ErrorEmsList);
	}
}
