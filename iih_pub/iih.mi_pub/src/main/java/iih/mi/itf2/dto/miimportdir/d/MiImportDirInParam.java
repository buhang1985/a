package iih.mi.itf2.dto.miimportdir.d;

import xap.mw.core.data.*;

/**
 * 目录导入入参 DTO数据 
 * 
 */
public class MiImportDirInParam extends BaseDTO {
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
}