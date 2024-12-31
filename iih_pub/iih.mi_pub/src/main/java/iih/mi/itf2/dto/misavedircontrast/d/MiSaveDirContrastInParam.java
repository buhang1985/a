package iih.mi.itf2.dto.misavedircontrast.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 目录保存对照入参 DTO数据 
 * 
 */
public class MiSaveDirContrastInParam extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 目录类型
	 * @return String
	 */
	public String getDirtype() {
		return ((String) getAttrVal("Dirtype"));
	}
	/**
	 * 目录类型
	 * @param Dirtype
	 */
	public void setDirtype(String Dirtype) {
		setAttrVal("Dirtype", Dirtype);
	}
	/**
	 * 目录保存对照入参集合
	 * @return FArrayList
	 */
	public FArrayList getDetail() {
		return ((FArrayList) getAttrVal("Detail"));
	}
	/**
	 * 目录保存对照入参集合
	 * @param Detail
	 */
	public void setDetail(FArrayList Detail) {
		setAttrVal("Detail", Detail);
	}
}