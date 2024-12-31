package iih.bd.pp.priceengine;

import java.util.Map;

import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.ICalcPriceService;
import iih.bd.pp.priceengine.bp.CalcSrvCompPriBP;
import xap.mw.core.data.BizException;

/**
 * 计算服务组合计价
 * @author yankan
 * @since 2017-08-01
 *
 */
public class CalcSrvCompPriceServiceImpl  implements ICalcPriceService{
	/**
	 * 计算价格
	 */
	@Override
	public Map<String, PriceResultDTO> calcPrice(PriceReqDTO[] priceReqDTOs) throws BizException {
		CalcSrvCompPriBP calcPriceBP = new CalcSrvCompPriBP();
		return calcPriceBP.exec(priceReqDTOs);
	}

}
