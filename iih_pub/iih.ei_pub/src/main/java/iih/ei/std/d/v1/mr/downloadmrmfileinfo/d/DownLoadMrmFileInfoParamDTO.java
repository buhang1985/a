package iih.ei.std.d.v1.mr.downloadmrmfileinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 入参dto DTO数据 
 * 
 */
public class DownLoadMrmFileInfoParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊唯一编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 就诊唯一编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 数据集编码
	 * @return String
	 */
	public String getCode_set() {
		return ((String) getAttrVal("Code_set"));
	}	
	/**
	 * 数据集编码
	 * @param Code_set
	 */
	public void setCode_set(String Code_set) {
		setAttrVal("Code_set", Code_set);
	}
}