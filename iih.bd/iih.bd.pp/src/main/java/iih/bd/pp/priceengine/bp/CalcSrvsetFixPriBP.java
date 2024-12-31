package iih.bd.pp.priceengine.bp;

import java.util.Map;

import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import xap.mw.core.data.BizException;

/**
 * 服务套成员项目个数定价
 * @author yankan
 * @since 2017-07-26
 *
 */
public class CalcSrvsetFixPriBP {
	/**
	 * 计算价格
	 * 
	 * @param priceReqDTOs 计价请求集合
	 * @return 计价结果map,[key: 服务ID，value: 服务计价结果DTO]
	 * @throws BizException
	 */
	public Map<String, PriceResultDTO> exec(PriceReqDTO[] priceReqDTOs) throws BizException {		
		return null;
	}
}
