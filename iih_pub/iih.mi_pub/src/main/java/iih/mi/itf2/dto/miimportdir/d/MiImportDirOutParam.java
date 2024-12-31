package iih.mi.itf2.dto.miimportdir.d;

import xap.mw.core.data.*;

/**
 * 目录导入出参 DTO数据 
 * 
 */
public class MiImportDirOutParam extends BaseDTO {
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