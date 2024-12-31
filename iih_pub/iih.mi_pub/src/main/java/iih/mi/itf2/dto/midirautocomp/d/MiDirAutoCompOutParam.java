package iih.mi.itf2.dto.midirautocomp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 目录自动对照出参 DTO数据 
 * 
 */
public class MiDirAutoCompOutParam extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 出参明细
	 * @return FArrayList
	 */
	public FArrayList getDetail() {
		return ((FArrayList) getAttrVal("Detail"));
	}
	/**
	 * 出参明细
	 * @param Detail
	 */
	public void setDetail(FArrayList Detail) {
		setAttrVal("Detail", Detail);
	}
}