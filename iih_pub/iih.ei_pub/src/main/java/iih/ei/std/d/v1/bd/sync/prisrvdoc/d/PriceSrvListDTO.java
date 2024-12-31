package iih.ei.std.d.v1.bd.sync.prisrvdoc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 价表项目列表DTO DTO数据 
 * 
 */
public class PriceSrvListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 价表项目
	 * @return String
	 */
	public FArrayList getPricesrv() {
		return ((FArrayList) getAttrVal("Pricesrv"));
	}	
	/**
	 * 价表项目
	 * @param Pricesrv
	 */
	public void setPricesrv(FArrayList Pricesrv) {
		setAttrVal("Pricesrv", Pricesrv);
	}
}