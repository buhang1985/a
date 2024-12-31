package iih.bd.pp.priceengine;

import java.util.Map;

import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.ICalcPriceService;
import xap.mw.core.data.BizException;

/**
 * 价格计算引擎
 * 
 * @author yankan
 * @since 2017-07-25
 *
 */
public class PriceEngine {
	private static IServiceRepository<ICalcPriceService> serviceRepository = new ServiceRepository<ICalcPriceService>();
	/**
	 * 计算价格
	 * @param primdCode
	 * @param srvPriList
	 * @throws BizException
	 */
	public static Map<String, PriceResultDTO> calcPrice(String primdCode, PriceReqDTO[] priReqDTOs) throws BizException {
		ICalcPriceService calcPriService = serviceRepository.find(primdCode);
		if (calcPriService == null) {
			calcPriService = PriCalServiceFactory.createPriService(primdCode);
			if (calcPriService != null) {
				serviceRepository.store(primdCode, calcPriService);
			} else {
				throw new BizException("该定价模式没有对应的服务实现!");
			}
		}
		return calcPriService.calcPrice(priReqDTOs);
	}
}
