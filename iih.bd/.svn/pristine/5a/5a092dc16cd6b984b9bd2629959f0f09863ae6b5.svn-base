package iih.bd.pp.priceengine;

import java.util.Map;

import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.ICalcPriceService;
import iih.bd.pp.priceengine.bp.CalcSrvsetFixPriBP;
import xap.mw.core.data.BizException;

/**
 * 计算服务套成员项目个数定价
 * @author yankan
 * @since 2017-08-01
 *
 */
public class CalcSrvsetFixPriceServiceImpl  implements ICalcPriceService{
	/**
	 * 计算价格
	 */
	@Override
	public Map<String, PriceResultDTO> calcPrice(PriceReqDTO[] priceReqDTOs) throws BizException {
		CalcSrvsetFixPriBP calcPriceBP = new CalcSrvsetFixPriBP();
		return calcPriceBP.exec(priceReqDTOs);
	}

}
