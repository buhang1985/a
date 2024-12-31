package iih.pi.reg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者新建更新服务结果DTO DTO数据 
 * 
 */
public class PiPatWSCUResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 成功失败标识
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 成功失败标识
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
}