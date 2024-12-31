package iih.mi.biz.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 手术登记信息集合 DTO数据 
 * 
 */
public class OperationRegSetsInParam extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 手术信息集合
	 * @return FArrayList
	 */
	public FArrayList getOperationsets() {
		return ((FArrayList) getAttrVal("Operationsets"));
	}
	/**
	 * 手术信息集合
	 * @param Operationsets
	 */
	public void setOperationsets(FArrayList Operationsets) {
		setAttrVal("Operationsets", Operationsets);
	}
}