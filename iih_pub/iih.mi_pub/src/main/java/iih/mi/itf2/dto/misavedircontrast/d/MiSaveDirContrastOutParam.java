package iih.mi.itf2.dto.misavedircontrast.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 目录保存对照出参 DTO数据 
 * 
 */
public class MiSaveDirContrastOutParam extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 目录保存对照出参集合
	 * @return FArrayList
	 */
	public FArrayList getDetail() {
		return ((FArrayList) getAttrVal("Detail"));
	}
	/**
	 * 目录保存对照出参集合
	 * @param Detail
	 */
	public void setDetail(FArrayList Detail) {
		setAttrVal("Detail", Detail);
	}
}