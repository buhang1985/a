package iih.ei.std.d.v1.bd.sync.psndoc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 人员档案列表DTO DTO数据 
 * 
 */
public class PsnDocListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 人员档案
	 * @return String
	 */
	public FArrayList getPsndoc() {
		return ((FArrayList) getAttrVal("Psndoc"));
	}	
	/**
	 * 人员档案
	 * @param Psndoc
	 */
	public void setPsndoc(FArrayList Psndoc) {
		setAttrVal("Psndoc", Psndoc);
	}
}