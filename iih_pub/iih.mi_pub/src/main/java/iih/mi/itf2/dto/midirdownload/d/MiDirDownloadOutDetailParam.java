package iih.mi.itf2.dto.midirdownload.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 目录下载出参明细 DTO数据 
 * 
 */
public class MiDirDownloadOutDetailParam extends BaseDTO {
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
	 * 目录上传地址
	 * @return String
	 */
	public String getDirkey() {
		return ((String) getAttrVal("Dirkey"));
	}
	/**
	 * 目录上传地址
	 * @param Dirkey
	 */
	public void setDirkey(String Dirkey) {
		setAttrVal("Dirkey", Dirkey);
	}
}