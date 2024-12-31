package iih.bd.pp.priceengine;

import java.util.Map;

import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.ICalcPriceService;
import iih.bd.pp.priceengine.bp.CalcResPriBP;
import xap.mw.core.data.BizException;

/**
 * 计算物品价格
 * @author yankan
 * @since 2017-08-01
 *
 */
public class CalcResPriceServiceImpl implements ICalcPriceService{
	/**
	 * 计算价格
	 */
	@Override
	public Map<String, PriceResultDTO> calcPrice(PriceReqDTO[] priceReqDTOs) throws BizException {
		CalcResPriBP calcPriceBP = new CalcResPriBP();
		return calcPriceBP.exec(priceReqDTOs);
	}

}
