package iih.bd.pp.priceengine;

import java.util.Map;

import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.ICalcPriceService;
import iih.bd.pp.priceengine.bp.CalcSrvsetAmtPriBP;
import xap.mw.core.data.BizException;

/**
 * 计算服务套合计价
 * @author yankan
 * @since 2017-08-01
 *
 */
public class CalcSrvsetAmtPriceServiceImpl  implements ICalcPriceService{
	/**
	 * 计算价格
	 */
	@Override
	public Map<String, PriceResultDTO> calcPrice(PriceReqDTO[] priceReqDTOs) throws BizException {
		CalcSrvsetAmtPriBP calcPriceBP = new CalcSrvsetAmtPriBP();
		return calcPriceBP.exec(priceReqDTOs);
	}

}
