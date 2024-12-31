package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院特定类型血透编码DTO DTO数据 
 * 
 */
public class EnIpSpecTypeHemoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 血透ID
	 * @return String
	 */
	public String getId_hemo() {
		return ((String) getAttrVal("Id_hemo"));
	}
	/**
	 * 血透ID
	 * @param Id_hemo
	 */
	public void setId_hemo(String Id_hemo) {
		setAttrVal("Id_hemo", Id_hemo);
	}
}