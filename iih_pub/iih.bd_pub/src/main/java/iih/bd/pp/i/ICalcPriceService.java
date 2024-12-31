package iih.bd.pp.i;

import java.util.Map;

import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import xap.mw.core.data.BizException;

/**
 * 计价服务接口
 * @author yankan
 * @since 2017-07-26
 *
 */
public interface ICalcPriceService {
	/**
	 * 计算服务价格
	 * 
	 * @param priceReqDTOs,计价请求DTO集合
	 * @return srvPriMap,服务价格map，key: 服务ID，value: 服务价格结果DTO
	 * @throws BizException
	 */
	public abstract Map<String, PriceResultDTO> calcPrice(PriceReqDTO[] priceReqDTOs) throws BizException;
}
