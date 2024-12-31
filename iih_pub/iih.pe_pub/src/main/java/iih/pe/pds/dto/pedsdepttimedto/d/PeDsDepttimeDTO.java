package iih.pe.pds.dto.pedsdepttimedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检优化科室检查时间 DTO数据 
 * 
 */
public class PeDsDepttimeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检科室ID
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}
	/**
	 * 体检科室ID
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 平均检查时间
	 * @return FDouble
	 */
	public FDouble getAvgtime() {
		return ((FDouble) getAttrVal("Avgtime"));
	}
	/**
	 * 平均检查时间
	 * @param Avgtime
	 */
	public void setAvgtime(FDouble Avgtime) {
		setAttrVal("Avgtime", Avgtime);
	}
}