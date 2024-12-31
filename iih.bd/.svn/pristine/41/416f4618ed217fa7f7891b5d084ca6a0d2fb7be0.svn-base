package iih.bd.pp.priceengine;

import java.util.Map;

import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.ICalcPriceService;
import iih.bd.pp.priceengine.bp.CalcBasicSrvPriceBP;
import xap.mw.core.data.BizException;

/**
 * 本服务定价服务
 * @author yankan
 * @since 2017-08-01
 *
 */
public class CalcBasicSrvPriceServiceImpl implements ICalcPriceService {
	/**
	 * 计算价格
	 */
	@Override
	public Map<String, PriceResultDTO> calcPrice(PriceReqDTO[] priceReqDTOs) throws BizException {
		CalcBasicSrvPriceBP calcBP = new CalcBasicSrvPriceBP();
		return calcBP.exec(priceReqDTOs);
	}

}
