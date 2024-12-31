package iih.mi.itf2.dto.exportdir.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 目录导出出参 DTO数据 
 * 
 */
public class MiExportDirOutParam extends BaseDTO {
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