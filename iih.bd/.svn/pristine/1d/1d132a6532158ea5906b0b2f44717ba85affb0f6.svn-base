package iih.bd.mm.iemsg;

import iih.bd.mm.iemsg.d.PricemmDTO;
import iih.bd.mm.iemsg.qry.MmPriceSql;
import iih.mm.st.stockpriceadjust.d.StockPriceAdjustDO;
import xap.mw.core.data.BizException;

/**
 * 获取物品调价修改后数据。
 * @author shao_yuan
 *
 */
public  class MmPriceBp{

	public PricemmDTO[] setPriDTO(StockPriceAdjustDO[] pridolist,String eventtype) throws BizException {		
				
		//获得物品调价数据信息
		MmPriceSql sql = new MmPriceSql();
		PricemmDTO[] ors=sql.setByStatu(pridolist,eventtype);
		return ors;
	}		

}
