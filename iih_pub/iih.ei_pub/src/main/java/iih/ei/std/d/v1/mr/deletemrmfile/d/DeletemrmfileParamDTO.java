package iih.ei.std.d.v1.mr.deletemrmfile.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 第三方删除病案文件入参 DTO数据 
 * 
 */
public class DeletemrmfileParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 业务主键
	 * @return String
	 */
	public String getId_busy() {
		return ((String) getAttrVal("Id_busy"));
	}	
	/**
	 * 业务主键
	 * @param Id_busy
	 */
	public void setId_busy(String Id_busy) {
		setAttrVal("Id_busy", Id_busy);
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