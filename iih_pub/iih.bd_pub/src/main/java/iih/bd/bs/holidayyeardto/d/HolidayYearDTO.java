package iih.bd.bs.holidayyeardto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 假日年度查询DTO DTO数据 
 * 
 */
public class HolidayYearDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 假日年度
	 * @return FDate
	 */
	public FDate getDt_holidayyear() {
		return ((FDate) getAttrVal("Dt_holidayyear"));
	}
	/**
	 * 假日年度
	 * @param Dt_holidayyear
	 */
	public void setDt_holidayyear(FDate Dt_holidayyear) {
		setAttrVal("Dt_holidayyear", Dt_holidayyear);
	}
}